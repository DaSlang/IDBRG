package it.unibas.idbrg.persistenza;

import it.unibas.idbrg.modello.Relazione;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DAORelazione implements IDAORelazione {

    @Override
    public void salva(Relazione relazione, String nomeFile) throws DAOException {
        PrintWriter flusso = null;
        try {
            FileWriter file = new FileWriter(nomeFile);
            flusso = new PrintWriter(file);
            flusso.println(relazione.toString());
        } catch (IOException ioe ) {
            throw new DAOException("Problemi nel salvataggio del file");
        } finally {
            try {
                if (flusso != null) {
                    flusso.close();
                }
            } catch (Exception e) {
            }
        }
    }
    
}