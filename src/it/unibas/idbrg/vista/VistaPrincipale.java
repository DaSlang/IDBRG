package it.unibas.idbrg.vista;

import it.unibas.idbrg.Applicazione;
import it.unibas.idbrg.Costanti;
import it.unibas.idbrg.modello.Relazione;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {

    private ModelloListaIDBRG modelloLista;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pannelloGenera = new javax.swing.JPanel();
        javax.swing.JLabel labelNumeroAttributi = new javax.swing.JLabel();
        spinnerAttributi = new javax.swing.JSpinner();
        javax.swing.JLabel labelDipendenze = new javax.swing.JLabel();
        spinnerDipendenze = new javax.swing.JSpinner();
        bottoneGeneraSchema = new javax.swing.JButton();
        javax.swing.JLabel labelNome = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        bottoneVisualizzaRelazione = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaRelazioni = new javax.swing.JList<>();
        bottoneSalva = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        pannelloGenera.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Generazione Schema", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        labelNumeroAttributi.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        labelNumeroAttributi.setText("Inserisci il numero di attributi  (max 7):");
        labelNumeroAttributi.setToolTipText("(per un massimo di attributi da A a G)");

        spinnerAttributi.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        spinnerAttributi.setModel(new javax.swing.SpinnerNumberModel(2, 2, 7, 1));

        labelDipendenze.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        labelDipendenze.setText("Inserisci il n° massimo di dipendenze:");
        labelDipendenze.setToolTipText("(in caso di duplicati ne saranno visualizzate di meno)");

        spinnerDipendenze.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        spinnerDipendenze.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        bottoneGeneraSchema.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        bottoneGeneraSchema.setText("jButton1");

        labelNome.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        labelNome.setText("Nome schema relazionale:");

        javax.swing.GroupLayout pannelloGeneraLayout = new javax.swing.GroupLayout(pannelloGenera);
        pannelloGenera.setLayout(pannelloGeneraLayout);
        pannelloGeneraLayout.setHorizontalGroup(
            pannelloGeneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloGeneraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bottoneGeneraSchema)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pannelloGeneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pannelloGeneraLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pannelloGeneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelDipendenze)
                        .addComponent(labelNumeroAttributi)
                        .addComponent(labelNome))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                    .addGroup(pannelloGeneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelloGeneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinnerDipendenze, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerAttributi, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(textNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap()))
        );
        pannelloGeneraLayout.setVerticalGroup(
            pannelloGeneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelloGeneraLayout.createSequentialGroup()
                .addContainerGap(156, Short.MAX_VALUE)
                .addComponent(bottoneGeneraSchema)
                .addContainerGap())
            .addGroup(pannelloGeneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pannelloGeneraLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pannelloGeneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelNome)
                        .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(23, 23, 23)
                    .addGroup(pannelloGeneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelNumeroAttributi)
                        .addComponent(spinnerAttributi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(25, 25, 25)
                    .addGroup(pannelloGeneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelDipendenze)
                        .addComponent(spinnerDipendenze, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(59, Short.MAX_VALUE)))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Schemi Generati", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        bottoneVisualizzaRelazione.setText("jButton1");

        listaRelazioni.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaRelazioni);

        bottoneSalva.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bottoneSalva)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 371, Short.MAX_VALUE)
                        .addComponent(bottoneVisualizzaRelazione))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bottoneSalva)
                    .addComponent(bottoneVisualizzaRelazione))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pannelloGenera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pannelloGenera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void inizializza() {
        initComponents();
        this.inizializzaLista();
        inizializzaAzioni();
    }

    public void inizializzaLista() {
        List<Relazione> listaCorrente = (List<Relazione>) Applicazione.getInstance().getModello().getBean(Costanti.MODELLO_LISTA_RELAZIONE);
        this.modelloLista = new ModelloListaIDBRG(listaCorrente);
        this.listaRelazioni.setModel(modelloLista);
    }
    
    public void aggiornaLista() {
        this.modelloLista.aggiornaLista();
    }
    
    public int getIndexElementoSelezionato() {
        return this.listaRelazioni.getSelectedIndex();
    }

    public String getNomeRelazione() {
        return this.textNome.getText();
    }

    public int getNumeroAttributi() {
        return (Integer) this.spinnerAttributi.getValue();
    }

    public int getNumeroDipendenze() {
        return (Integer) this.spinnerDipendenze.getValue();
    }

    private void inizializzaAzioni() {
        this.bottoneGeneraSchema.setAction(Applicazione.getInstance().getControlloVistaPrincipale().getAzioneGeneraSchema());
        this.textNome.setAction(Applicazione.getInstance().getControlloVistaPrincipale().getAzioneGeneraSchema());
        this.bottoneSalva.setAction(Applicazione.getInstance().getControlloVistaPrincipale().getAzioneSalva());
        this.bottoneVisualizzaRelazione.setAction(Applicazione.getInstance().getControlloVistaPrincipale().getAzioneVisualizzaSchema());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneGeneraSchema;
    private javax.swing.JButton bottoneSalva;
    private javax.swing.JButton bottoneVisualizzaRelazione;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaRelazioni;
    private javax.swing.JPanel pannelloGenera;
    private javax.swing.JSpinner spinnerAttributi;
    private javax.swing.JSpinner spinnerDipendenze;
    private javax.swing.JTextField textNome;
    // End of variables declaration//GEN-END:variables
}
