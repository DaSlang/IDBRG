package it.unibas.idbrg.modello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GeneratoreDipendenza {

    private static Character[] arrayCaratteri = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    private static Random random = new Random ();
    private static List<Character> determinante;
    private static List<Character> determinato;
    
    private static Logger logger = LoggerFactory.getLogger(GeneratoreDipendenza.class);
    
    private GeneratoreDipendenza() {
    }

    public static List<Character> getDeterminante() {
        return determinante;
    }

    public static List<Character> getDeterminato() {
        return determinato;
    }
    
    public static List<Character> getAttributi () {
        return Arrays.asList(arrayCaratteri);
    }
    
    public static Dipendenza generaDipendenza (int numeroAttributi) {
        GeneratoreDipendenza.determinante = GeneratoreDipendenza.generaAttributi(numeroAttributi, null);
        while (numeroAttributi <= 3 && determinante.size() == numeroAttributi) {            
            GeneratoreDipendenza.determinante = GeneratoreDipendenza.generaAttributi(numeroAttributi, null); // se si genera un determinante da 2 con attributi = 2 non avrà determinato (banale) così invece ricalcoliamo, da 4 in poi no problemi perché dim determinante massimo 3
        }
        GeneratoreDipendenza.determinato = GeneratoreDipendenza.generaAttributi(numeroAttributi, determinante);
        return new Dipendenza(determinante, determinato);
    }
    
    private static List<Character> generaAttributi (int numeroAttributi, List<Character> listaControllo) {
        Set<Character> insiemeAttributi = new HashSet<>();
        int dimAttributiDeterminante = random.nextInt(3) + 1;
        int dimAttributiDeterminato = random.nextInt(3) + 1;
        if (listaControllo == null) {
            for (int i = 0; i < dimAttributiDeterminante; i++) {
                Character attributoDaAggiungere = GeneratoreDipendenza.generaAttributoCasuale(Arrays.asList(GeneratoreDipendenza.arrayCaratteri), numeroAttributi);
                insiemeAttributi.add(attributoDaAggiungere);
            }
        } else {
            for (int i = 0; i < dimAttributiDeterminato; i++) {
                List<Character> possibiliAttributiDeterminato = GeneratoreDipendenza.rimuoviAttributiDeterminante(listaControllo, numeroAttributi);
                Character attributoDaAggiungere = GeneratoreDipendenza.generaAttributoCasuale(possibiliAttributiDeterminato, possibiliAttributiDeterminato.size());
                insiemeAttributi.add(attributoDaAggiungere);
            }
        }
        return new ArrayList<>(insiemeAttributi);
    }
    
    private static Character generaAttributoCasuale (List<Character> attributi, int numeroAttributi) {
        if (numeroAttributi <= 0) {
            throw new IllegalArgumentException("Parametro non valido");
        }
        int indiceAttributo = random.nextInt(numeroAttributi);
        Character attributoDaAggiungere = attributi.get(indiceAttributo);
        return attributoDaAggiungere;
    }
    
    private static List<Character> rimuoviAttributiDeterminante (List<Character> determinante, int numeroAttributi) {
        List<Character> listaAttributTotali = Arrays.asList(GeneratoreDipendenza.arrayCaratteri);
        List<Character> listaAttributiScremata = new ArrayList<>();
        for (int i = 0; i < numeroAttributi; i++) {
            listaAttributiScremata.add(listaAttributTotali.get(i));
        }
        List<Character> listaFiltrata = new ArrayList<>();
        for (Character character : listaAttributiScremata) {
            if (!(determinante.contains(character))) {
                listaFiltrata.add(character);
            }
        }
        return listaFiltrata;
    }
    
}