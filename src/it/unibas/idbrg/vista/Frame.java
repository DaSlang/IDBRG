package it.unibas.idbrg.vista;

import it.unibas.idbrg.Applicazione;
import it.unibas.idbrg.Costanti;
import it.unibas.idbrg.modello.Relazione;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Frame extends javax.swing.JFrame {
    
    private static final Logger logger = LoggerFactory.getLogger(Frame.class);
    
    static {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            logger.error("Errore nel caricamento del Look and Feel");
        }
    }
    
    private JFileChooser fileChooser = new JFileChooser();

    public JFileChooser getFileChooser() {
        return fileChooser;
    }

    public JMenuItem getItemEsci() {
        return itemEsci;
    }

    public JMenuItem getItemGeneraRelazione() {
        return itemGeneraRelazione;
    }

    public JMenuItem getItemSalvaRelazione() {
        return itemSalvaRelazione;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JMenuBar menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu menuFile = new javax.swing.JMenu();
        itemGeneraRelazione = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemSalvaRelazione = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        itemEsci = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuFile.setText("File");

        itemGeneraRelazione.setText("jMenuItem1");
        menuFile.add(itemGeneraRelazione);
        menuFile.add(jSeparator1);

        itemSalvaRelazione.setText("jMenuItem1");
        menuFile.add(itemSalvaRelazione);
        menuFile.add(jSeparator3);

        itemEsci.setText("jMenuItem1");
        menuFile.add(itemEsci);

        menuBar.add(menuFile);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   public void inizializza () {
       initComponents();
       inizializzaAzioni();
       this.setTitle("Generatore schema relazionale");
       JScrollPane pannello = new JScrollPane(Applicazione.getInstance().getVistaPrincipale());
       this.setContentPane(pannello);
       this.pack();
       this.setLocationRelativeTo(null);
       this.setVisible(true);
   }
   
   private void inizializzaAzioni () {
       this.itemEsci.setAction(Applicazione.getInstance().getControlloFrame().getAzioneEsci());
       this.itemSalvaRelazione.setAction(Applicazione.getInstance().getControlloFrame().getAzioneSalva());
       this.itemGeneraRelazione.setAction(Applicazione.getInstance().getControlloVistaPrincipale().getAzioneGeneraSchema());
   }
   
   public void schermoErrori (String errori) {
       JOptionPane.showMessageDialog(this, errori, "Errori", JOptionPane.ERROR_MESSAGE);
   }
   
   public void schermoInformazioni (String informazione) {
       JOptionPane.showMessageDialog(this, informazione, "Visualizza", JOptionPane.INFORMATION_MESSAGE);
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemEsci;
    private javax.swing.JMenuItem itemGeneraRelazione;
    private javax.swing.JMenuItem itemSalvaRelazione;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
