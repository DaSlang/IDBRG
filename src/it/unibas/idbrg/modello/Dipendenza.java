package it.unibas.idbrg.modello;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Dipendenza {
    
    private List<Character> determinante = new ArrayList<> ();
    private List<Character> determinato = new ArrayList<> ();

    public Dipendenza(List<Character> determinante, List<Character> determinato) {
        this.determinante = determinante;
        this.determinato = determinato;
    }
    
    public void aggiungiDeterminante (char attributo) {
        this.determinante.add(attributo);
    }
    
    public void aggiungiDeterminato (char attributo) {
        this.determinato.add(attributo);
    }

    public List<Character> getDeterminante() {
        return determinante;
    }

    public List<Character> getDeterminato() {
        return determinato;
    }
    
    /*public Set getInsiemeAttributi() {
        Set<Character> insieme = new HashSet<>(determinante);
        insieme.addAll(determinato);
        return insieme;
    }*/ //vedi costruttore relazione

    @Override
    public String toString() {
        StringBuilder stringa = new StringBuilder();
        stringa.append("(");
        for (Character character : this.determinante) {
            stringa.append(character).append(",");
        }
        stringa.deleteCharAt(stringa.length() - 1).append(")");
        stringa.append(" -> ");
        stringa.append("(");
        for (Character carattere : this.determinato) {
            stringa.append(carattere).append(",");
        }
        stringa.deleteCharAt(stringa.length() - 1).append(")");
        return stringa.toString();
    }
    
    @Override
    public boolean equals (Object o) {
        Dipendenza altra = (Dipendenza) o;
        return altra.getDeterminante().equals(this.determinante) && altra.getDeterminato().equals(this.determinato);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.determinante);
        hash = 59 * hash + Objects.hashCode(this.determinato);
        return hash;
    }
}