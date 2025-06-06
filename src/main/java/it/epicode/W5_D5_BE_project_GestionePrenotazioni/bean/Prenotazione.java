package it.epicode.W5_D5_BE_project_GestionePrenotazioni.bean;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@Entity
public class Prenotazione {
    @Id
    @GeneratedValue
    private long id;
    private LocalDate dataPrenotazione;


    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;


}
