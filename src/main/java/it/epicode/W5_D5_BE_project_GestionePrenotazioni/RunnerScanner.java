package it.epicode.W5_D5_BE_project_GestionePrenotazioni;

import it.epicode.W5_D5_BE_project_GestionePrenotazioni.repositories.EdificioRepository;
import it.epicode.W5_D5_BE_project_GestionePrenotazioni.repositories.PostazioneRepository;
import it.epicode.W5_D5_BE_project_GestionePrenotazioni.repositories.PrenotazioneRepository;
import it.epicode.W5_D5_BE_project_GestionePrenotazioni.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class RunnerScanner implements CommandLineRunner {

    @Autowired
    private EdificioRepository edificioRepository;
    @Autowired
    private PostazioneRepository postazioneRepository;
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    public void run(String... args) throws Exception {

    }
}
