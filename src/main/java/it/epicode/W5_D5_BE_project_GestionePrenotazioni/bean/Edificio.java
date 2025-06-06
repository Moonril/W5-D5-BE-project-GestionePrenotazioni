package it.epicode.W5_D5_BE_project_GestionePrenotazioni.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Data
@NoArgsConstructor
@Entity
@ToString(exclude = "postazioni")
public class Edificio {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String citta;


    @OneToMany(mappedBy = "edificio")
    private List<Postazione> postazioni;
}
