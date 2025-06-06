package it.epicode.W5_D5_BE_project_GestionePrenotazioni.exceptions;

public class UsernameEsistenteException extends RuntimeException {
    public UsernameEsistenteException(String message) {
        super(message);
    }
}
