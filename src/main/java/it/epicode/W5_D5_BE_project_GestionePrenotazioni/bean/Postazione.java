package it.epicode.W5_D5_BE_project_GestionePrenotazioni.bean;

import it.epicode.W5_D5_BE_project_GestionePrenotazioni.enums.TipoPostazione;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Data
@NoArgsConstructor
@Entity
@ToString(exclude = "prenotazioni")
public class Postazione {
    @Id
    @GeneratedValue
    private long id;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;
    private int maxOccupanti;

    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;


    public Postazione(String descrizione, TipoPostazione tipoPostazione, int maxOccupanti) {
        this.descrizione = descrizione;
        this.tipoPostazione = tipoPostazione;
        this.maxOccupanti = maxOccupanti;
    }
}
