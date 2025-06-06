package it.epicode.W5_D5_BE_project_GestionePrenotazioni.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
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
    private String indirizzo;


    @OneToMany(mappedBy = "edificio")
    private List<Postazione> postazioni = new ArrayList<>();


    public Edificio(String nome, String citta, String indirizzo) {
        this.nome = nome;
        this.citta = citta;
        this.indirizzo = indirizzo;

    }
}
