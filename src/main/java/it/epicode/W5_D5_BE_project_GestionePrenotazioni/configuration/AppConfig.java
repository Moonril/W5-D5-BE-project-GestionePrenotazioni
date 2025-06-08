package it.epicode.W5_D5_BE_project_GestionePrenotazioni.configuration;

import it.epicode.W5_D5_BE_project_GestionePrenotazioni.bean.Edificio;
import it.epicode.W5_D5_BE_project_GestionePrenotazioni.bean.Postazione;
import it.epicode.W5_D5_BE_project_GestionePrenotazioni.enums.TipoPostazione;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // edifici

    @Bean(name = "torre glories")
    public Edificio getTorreGlories(){
        Edificio glories = new Edificio();
        glories.setNome("Torre Glories");
        glories.setCitta("Barcelona");
        glories.setIndirizzo("Avenida Diagonal, 211");
        return glories;
    }

    @Bean(name = "pavillion")
    public Edificio getPavillion(){
        Edificio pavillion = new Edificio();
        pavillion.setNome("Pavillion");
        pavillion.setCitta("Barcelona");
        pavillion.setIndirizzo("Avenida de Francesc Ferre, 7");
        return pavillion;
    }

    @Bean(name = "hotel porta fira")
    public Edificio getPortaFira(){
        Edificio fira = new Edificio();
        fira.setNome("Hotel Porta Fira");
        fira.setCitta("Barcelona");
        fira.setIndirizzo("Plaza Europa, 45");
        return fira;
    }



    // postazioni


    @Bean(name = "sala riunioni")
    public Postazione getSalaRiunioni(){
        Postazione riunioni = new Postazione();
        riunioni.setDescrizione("una sala per le riunioni");
        riunioni.setMaxOccupanti(20);
        riunioni.setTipoPostazione(TipoPostazione.SALA_RIUNIONI);
        return riunioni;
    }

    @Bean(name = "sala privata")
    public Postazione getSalaPrivata(){
        Postazione privata = new Postazione();
        privata.setDescrizione("una sala privata");
        privata.setMaxOccupanti(5);
        privata.setTipoPostazione(TipoPostazione.PRIVATA);
        return privata;
    }

    @Bean(name = "openspace")
    public Postazione getOpenspace(){
        Postazione openspace = new Postazione();
        openspace.setDescrizione("sala openspace");
        openspace.setMaxOccupanti(100);
        openspace.setTipoPostazione(TipoPostazione.OPENSPACE);
        return openspace;
    }


}
