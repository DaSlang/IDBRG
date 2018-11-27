package it.unibas.idbrg.test;

import it.unibas.idbrg.modello.Dipendenza;
import it.unibas.idbrg.modello.GeneratoreDipendenza;
import it.unibas.idbrg.modello.Relazione;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class TestStampa {
    
    public TestStampa() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testDipendenzaStampa (){
        Dipendenza dipendenzaGenerata1 = GeneratoreDipendenza.generaDipendenza(5);
        Dipendenza dipendenzaGenerata2 = GeneratoreDipendenza.generaDipendenza(7);
        Dipendenza dipendenzaGenerata3 = GeneratoreDipendenza.generaDipendenza(6);
        System.out.println(dipendenzaGenerata1);
        System.out.println(dipendenzaGenerata2);
        System.out.println(dipendenzaGenerata3);
    }
    
    @Test
    public void testStampaRelazione () {
        Relazione relazione1 = new Relazione ("r1", 4, 6);
        Relazione relazione2 = new Relazione ("r2", 5, 6);
        Relazione relazione3 = new Relazione ("r3", 6, 6);
        System.out.println(relazione1);
        System.out.println(relazione2);
        System.out.println(relazione3);
    }
    
}
