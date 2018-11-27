package it.unibas.idbrg.modello;

import java.util.HashSet;
import java.util.Set;


public class Relazione {
    
    private Set<Character> insiemeAttributi = new HashSet <Character> ();
    private Set<Dipendenza> insiemeDipendenze = new HashSet<> ();
    private String nome;

    public Relazione(String nome, int numeroAttributi, int numeroDipendenze) {
        this.nome = nome;
        if (numeroAttributi < 2 ||numeroAttributi > 7) {
            throw new IllegalArgumentException("Il numero massimo di attributi è 7");
        }
        for (int i = 0; i < numeroDipendenze; i++) {
            Dipendenza dipendenza = GeneratoreDipendenza.generaDipendenza(numeroAttributi);            
            insiemeDipendenze.add(dipendenza);
            //insiemeAttributi.addAll(dipendenza.getInsiemeAttributi());  se creo una sola dipendenza con C->D gli attribut non possono essere l'unione se ne do 4 in input
        }
        for (int i = 0; i < numeroAttributi; i++) {
            insiemeAttributi.add(GeneratoreDipendenza.getAttributi().get(i));
        }
    }

    @Override
    public String toString() {
        StringBuilder stringa = new StringBuilder();
        stringa.append(this.nome + "<");
        String attributi = this.insiemeAttributi.toString();
        attributi = attributi.replace("[", "(");
        attributi = attributi.replace("]", ")");
        stringa.append(attributi).append(" ");
        String dipendenze = this.insiemeDipendenze.toString();
        dipendenze = dipendenze.replace("[", "{");
        dipendenze = dipendenze.replace("]", "}");
        stringa.append(dipendenze);
        stringa.append(">");
        return stringa.toString();
    }
    
    public String presentationString () {
        StringBuilder stringa = new StringBuilder();
        stringa.append("Nome relazione: ").append(this.nome).append("\n\n");
        stringa.append("Attributi: ").append(this.insiemeAttributi).append("\n\n");
        for (Dipendenza dipendenza : this.insiemeDipendenze) {
            stringa.append(dipendenza.toString());
            stringa.append('\n');
        }
        return stringa.toString();
    }

    public String getNome() {
        return nome;
    }
    
}