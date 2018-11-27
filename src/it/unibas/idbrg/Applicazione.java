/**
 *
 * @author Slang
 * @author Odin
 */
package it.unibas.idbrg;

import it.unibas.idbrg.controllo.ControlloFrame;
import it.unibas.idbrg.modello.Modello;
import it.unibas.idbrg.persistenza.IDAORelazione;
import it.unibas.idbrg.controllo.ControlloVistaPrincipale;
import it.unibas.idbrg.modello.Relazione;
import it.unibas.idbrg.persistenza.DAORelazione;
import it.unibas.idbrg.vista.Frame;
import it.unibas.idbrg.vista.VistaPrincipale;
import java.util.ArrayList;
import javax.swing.SwingUtilities;


public class Applicazione {
    
    private static Applicazione singleton = new Applicazione();
    private Modello modello;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private IDAORelazione iDaoRelazione;
    private ControlloVistaPrincipale controlloVistaPrincipale;
    private ControlloFrame controlloFrame;
    
    public static Applicazione getInstance() {
        return Applicazione.singleton;
    }

    public Modello getModello() {
        return modello;
    }

    public Frame getFrame() {
        return frame;
    }

    public ControlloFrame getControlloFrame() {
        return controlloFrame;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public ControlloVistaPrincipale getControlloVistaPrincipale() {
        return controlloVistaPrincipale;
    }

    public IDAORelazione getiDaoRelazione() {
        return iDaoRelazione;
    }
    
    public void inizializza () {
        this.modello = new Modello();
        this.modello.putBean(Costanti.MODELLO_LISTA_RELAZIONE, new ArrayList<>());
        this.frame = new Frame();
        this.controlloVistaPrincipale = new ControlloVistaPrincipale();
        this.controlloFrame = new ControlloFrame();
        this.vistaPrincipale = new VistaPrincipale();
        this.iDaoRelazione = new DAORelazione();
        this.vistaPrincipale.inizializza();
        this.frame.inizializza();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable () {
            @Override
            public void run() {
                Applicazione.getInstance().inizializza();
            }
        });
    }
    
}