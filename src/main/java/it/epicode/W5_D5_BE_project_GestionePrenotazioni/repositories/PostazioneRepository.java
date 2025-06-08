package it.epicode.W5_D5_BE_project_GestionePrenotazioni.repositories;

import it.epicode.W5_D5_BE_project_GestionePrenotazioni.bean.Postazione;
import it.epicode.W5_D5_BE_project_GestionePrenotazioni.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

    @Query("""
    SELECT p FROM Postazione p
    WHERE p.edificio.citta = :citta
    AND p.id NOT IN (
        SELECT pr.postazione.id FROM Prenotazione pr
        WHERE pr.dataPrenotazione = :data
    )
""")
    List<Postazione> findPostazioniDisponibiliByCittaAndData(@Param("citta") String citta, @Param("data") LocalDate data);



    @Query("""
    SELECT p FROM Postazione p 
    LEFT JOIN Prenotazione pr ON pr.postazione = p AND pr.dataPrenotazione = :data
    WHERE p.tipoPostazione = :tipo AND pr.id IS NULL
    """)
    List<Postazione> findPostazioniDisponibiliByTipoAndData(@Param("tipo") TipoPostazione tipo,
                                                            @Param("data") LocalDate data);





}
