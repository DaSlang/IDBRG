package it.unibas.idbrg.modello;

import java.util.HashMap;
import java.util.Map;


public class Modello {
    
    private Map<String, Object> mappaBean = new HashMap<>();
    
    public void putBean (String chiave, Object oggetto) {
        this.mappaBean.put(chiave, oggetto);
    }
    
    public Object getBean (String chiave) {
        return this.mappaBean.get(chiave);
    }

}