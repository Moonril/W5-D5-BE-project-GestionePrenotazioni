package it.epicode.W5_D5_BE_project_GestionePrenotazioni.repositories;

import it.epicode.W5_D5_BE_project_GestionePrenotazioni.bean.Prenotazione;
import it.epicode.W5_D5_BE_project_GestionePrenotazioni.bean.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    List<Prenotazione> findByUtente(Utente utente);
}
