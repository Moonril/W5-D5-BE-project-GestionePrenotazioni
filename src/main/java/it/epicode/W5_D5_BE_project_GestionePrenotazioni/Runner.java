package it.epicode.W5_D5_BE_project_GestionePrenotazioni;

import it.epicode.W5_D5_BE_project_GestionePrenotazioni.bean.Edificio;
import it.epicode.W5_D5_BE_project_GestionePrenotazioni.bean.Postazione;
import it.epicode.W5_D5_BE_project_GestionePrenotazioni.enums.TipoPostazione;
import it.epicode.W5_D5_BE_project_GestionePrenotazioni.repositories.EdificioRepository;
import it.epicode.W5_D5_BE_project_GestionePrenotazioni.repositories.PostazioneRepository;
import it.epicode.W5_D5_BE_project_GestionePrenotazioni.repositories.PrenotazioneRepository;
import it.epicode.W5_D5_BE_project_GestionePrenotazioni.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//riaggiungere component
public class Runner implements CommandLineRunner {

    @Autowired
    private EdificioRepository edificioRepository;
    @Autowired
    private PostazioneRepository postazioneRepository;
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private UtenteRepository utenteRepository;


    @Autowired
    @Qualifier("torre glories")
    private Edificio torreGlories;
    @Autowired
    @Qualifier("pavillion")
    private Edificio pavillion;
    @Autowired
    @Qualifier("hotel porta fira")
    private Edificio portaFira;


    @Autowired
    @Qualifier("sala riunioni")
    private Postazione salaRiunioni;
    @Autowired
    @Qualifier("sala privata")
    private Postazione salaPrivata;
    @Autowired
    @Qualifier("openspace")
    private Postazione openspace;

    @Override
    public void run(String... args) throws Exception {

        // edifici e postazioni creati con i bean
        edificioRepository.save(torreGlories);
        edificioRepository.save(pavillion);
        edificioRepository.save(portaFira);

        postazioneRepository.save(salaPrivata);
        postazioneRepository.save(salaRiunioni);
        postazioneRepository.save(openspace);

        torreGlories.setPostazioni(new ArrayList<>(List.of(openspace)));
        pavillion.setPostazioni(new ArrayList<>(List.of(salaRiunioni)));
        portaFira.setPostazioni(new ArrayList<>(List.of(salaPrivata)));

        openspace.setEdificio(torreGlories);
        salaRiunioni.setEdificio(pavillion);
        salaPrivata.setEdificio(portaFira);

        edificioRepository.save(torreGlories);
        edificioRepository.save(pavillion);
        edificioRepository.save(portaFira);

        postazioneRepository.save(salaPrivata);
        postazioneRepository.save(salaRiunioni);
        postazioneRepository.save(openspace);


        //edifici e postazioni aggiuntivi


        Edificio guell = new Edificio("park guell", "Barcelona");

        Postazione azzurra = new Postazione("piazza azzurra", TipoPostazione.OPENSPACE, 500, true);
        Postazione gialla = new Postazione("piazza gialla", TipoPostazione.OPENSPACE, 300, false);

        guell.setPostazioni(new ArrayList<>(List.of(azzurra, gialla)));
        azzurra.setEdificio(guell);
        gialla.setEdificio(guell);

        edificioRepository.save(guell);
        postazioneRepository.save(azzurra);
        postazioneRepository.save(gialla);


        Postazione salaRossa = new Postazione("grande sala rossa per riunioni", TipoPostazione.SALA_RIUNIONI, 50, true);
        portaFira.getPostazioni().add(salaRossa);
        salaRossa.setEdificio(portaFira);
        edificioRepository.save(portaFira);
        postazioneRepository.save(salaRossa);


        Postazione salaVerde = new Postazione("una piccola sala verde privata con pochi spazi", TipoPostazione.PRIVATA, 5, true);
        pavillion.getPostazioni().add(salaVerde);
        salaVerde.setEdificio(pavillion);
        edificioRepository.save(pavillion);
        postazioneRepository.save(salaVerde);



    }
}
