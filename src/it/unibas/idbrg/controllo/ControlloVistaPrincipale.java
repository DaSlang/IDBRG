package it.unibas.idbrg.controllo;

import it.unibas.idbrg.Applicazione;
import it.unibas.idbrg.Costanti;
import it.unibas.idbrg.modello.Relazione;
import it.unibas.idbrg.persistenza.DAOException;
import it.unibas.idbrg.persistenza.IDAORelazione;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ControlloVistaPrincipale {

    private Action azioneGeneraSchema = new AzioneGeneraSchema();
    private Action azioneSalva = new AzioneSalva();
    private Action azioneVisualizzaSchema = new AzioneVisualizzaSchema();

    public Action getAzioneGeneraSchema() {
        return azioneGeneraSchema;
    }

    public Action getAzioneSalva() {
        return this.azioneSalva;
    }

    public Action getAzioneVisualizzaSchema() {
        return azioneVisualizzaSchema;
    }

    private class AzioneGeneraSchema extends AbstractAction {

        public AzioneGeneraSchema() {
            this.putValue(Action.NAME, "Genera relazione");
            this.putValue(Action.SHORT_DESCRIPTION, "Genera una relazionale con attributi e dipendenze");
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_G);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl G"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String errori = this.verificaForm();
            if (!errori.isEmpty()) {
                Applicazione.getInstance().getFrame().schermoErrori(errori);
                return;
            }
            String nomeRelazione = Applicazione.getInstance().getVistaPrincipale().getNomeRelazione();
            int numeroAttributi = Applicazione.getInstance().getVistaPrincipale().getNumeroAttributi();
            int numeroDipendenze = Applicazione.getInstance().getVistaPrincipale().getNumeroDipendenze();
            Relazione relazione = new Relazione(nomeRelazione, numeroAttributi, numeroDipendenze);
            List<Relazione> listaRelazioni = (List<Relazione>) Applicazione.getInstance().getModello().getBean(Costanti.MODELLO_LISTA_RELAZIONE);
            listaRelazioni.add(relazione);
            Applicazione.getInstance().getVistaPrincipale().aggiornaLista();
            this.abilitaAzioniRelazione();
        }

        private void abilitaAzioniRelazione() {
            azioneSalva.setEnabled(true);
            azioneVisualizzaSchema.setEnabled(true);
        }

        private String verificaForm() {
            StringBuilder errori = new StringBuilder();
            String nomeRelazione = Applicazione.getInstance().getVistaPrincipale().getNomeRelazione();
            if (nomeRelazione.trim().isEmpty()) {
                errori.append("Inserire il nome della relazione\n");
            }
            if (!errori.equals("") && this.isRelazionePresente(nomeRelazione)) {
                errori.append("Il nome della relazione è già stato inserito\n");
            }
            return errori.toString();
        }

        private boolean isRelazionePresente(String nomeRelazione) {
            List<Relazione> listaRelazioni = (List<Relazione>) Applicazione.getInstance().getModello().getBean(Costanti.MODELLO_LISTA_RELAZIONE);
            for (Relazione relazione : listaRelazioni) {
                if (relazione.getNome().equals(nomeRelazione)) {
                    return true;
                }
            }
            return false;
        }

    }

    private class AzioneSalva extends AbstractAction {

        public AzioneSalva() {
            this.putValue(Action.NAME, "Salva relazione selezionata");
            this.putValue(Action.SHORT_DESCRIPTION, "includere l'estensione (compatibile con il normalizer unibas)");
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_S);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl S"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAORelazione daoRelazione = Applicazione.getInstance().getiDaoRelazione();
            int index = Applicazione.getInstance().getVistaPrincipale().getIndexElementoSelezionato();
            if (index == -1) {
                Applicazione.getInstance().getFrame().schermoErrori("E' necessario selezionare una relazione");
                return;
            }
            List<Relazione> listaRelazioni = (List<Relazione>) Applicazione.getInstance().getModello().getBean(Costanti.MODELLO_LISTA_RELAZIONE);
            Relazione relazione = listaRelazioni.get(index);
            String nomeFile = this.acquisisciFile();
            if (nomeFile != null) {
                try {
                    daoRelazione.salva(relazione, nomeFile + ".txt");
                } catch (DAOException daoe) {
                    Applicazione.getInstance().getFrame().schermoErrori("Non è stato possibile salvare il file");
                }
            }
        }

        private String acquisisciFile() {
            String nomeFile = null;
            JFileChooser fileChooser = Applicazione.getInstance().getFrame().getFileChooser();
            FileFilter filtro = new FileNameExtensionFilter(".txt", "txt");
            fileChooser.addChoosableFileFilter(filtro);
            fileChooser.setAcceptAllFileFilterUsed(false);
            int scelta = fileChooser.showSaveDialog(Applicazione.getInstance().getFrame());
            if (scelta == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                return file.toString();
            } else if (scelta == JFileChooser.CANCEL_OPTION) {
                nomeFile = null;
            }
            return nomeFile;
        }
    }
    
    private class AzioneVisualizzaSchema extends AbstractAction {

        public AzioneVisualizzaSchema() {
            this.putValue(Action.NAME, "Visualizza lo schema selezionato");
            this.putValue(Action.SHORT_DESCRIPTION, "Visualizza lo schema selezionato nella lista");
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_M);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl M"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int index = Applicazione.getInstance().getVistaPrincipale().getIndexElementoSelezionato();
            if (index == -1) {
                Applicazione.getInstance().getFrame().schermoErrori("Selezionare una relazione");
                return;
            }
            List<Relazione> listaRelazioni = (List<Relazione>) Applicazione.getInstance().getModello().getBean(Costanti.MODELLO_LISTA_RELAZIONE);
            Relazione relazione = listaRelazioni.get(index);
            Applicazione.getInstance().getFrame().schermoInformazioni(relazione.presentationString());
        }
        
    }

}
