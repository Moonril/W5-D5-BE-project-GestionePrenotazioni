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
@ToString(exclude = "prenotazioni")
public class Utente {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private String cognome;
    private String username;
    private String email;

    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioni;

    public Utente(String nome, String cognome, String username, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.email = email;
    }
}
