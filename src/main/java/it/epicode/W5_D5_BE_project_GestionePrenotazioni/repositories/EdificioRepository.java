package it.epicode.W5_D5_BE_project_GestionePrenotazioni.repositories;

import it.epicode.W5_D5_BE_project_GestionePrenotazioni.bean.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {
}
