package it.unibas.idbrg.controllo;

import it.unibas.idbrg.Applicazione;
import it.unibas.idbrg.Costanti;
import it.unibas.idbrg.modello.Relazione;
import it.unibas.idbrg.persistenza.DAOException;
import it.unibas.idbrg.persistenza.IDAORelazione;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;


public class ControlloFrame {
    
    private Action azioneEsci = new AzioneEsci();
    private Action azioneSalva = Applicazione.getInstance().getControlloVistaPrincipale().getAzioneSalva();

    public Action getAzioneEsci() {
        return azioneEsci;
    }

    public Action getAzioneSalva() {
        return azioneSalva;
    }
    
    private class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
            this.putValue(Action.NAME, "Esci");
            this.putValue(Action.SHORT_DESCRIPTION, "Esci dall'applicazione");
            this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl E"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
        
    }
    
}