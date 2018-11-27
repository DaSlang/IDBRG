package it.unibas.idbrg.vista;

import it.unibas.idbrg.modello.Relazione;
import java.util.List;
import javax.swing.AbstractListModel;

public class ModelloListaIDBRG extends AbstractListModel {
    
    private List<Relazione> listaRelazioni;
    
    public ModelloListaIDBRG(List<Relazione> listaRelazioni) {
        this.listaRelazioni = listaRelazioni;
    }

    @Override
    public int getSize() {
        return this.listaRelazioni.size();
    }

    @Override
    public Object getElementAt(int index) {
        if (this.listaRelazioni.isEmpty()) {
            return null;
        }
        return listaRelazioni.get(index);
    }
    
    public void aggiornaLista() {
        super.fireContentsChanged(this, 0, this.getSize());
    }
    
}
