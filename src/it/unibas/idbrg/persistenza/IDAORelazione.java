package it.unibas.idbrg.persistenza;

import it.unibas.idbrg.modello.Relazione;


public interface IDAORelazione {
    
    public void salva (Relazione relazione, String nomeFile) throws DAOException;
    
}
