package it.epicode.W5_D5_BE_project_GestionePrenotazioni;

import it.epicode.W5_D5_BE_project_GestionePrenotazioni.bean.Utente;
import it.epicode.W5_D5_BE_project_GestionePrenotazioni.exceptions.UsernameEsistenteException;
import it.epicode.W5_D5_BE_project_GestionePrenotazioni.repositories.EdificioRepository;
import it.epicode.W5_D5_BE_project_GestionePrenotazioni.repositories.PostazioneRepository;
import it.epicode.W5_D5_BE_project_GestionePrenotazioni.repositories.PrenotazioneRepository;
import it.epicode.W5_D5_BE_project_GestionePrenotazioni.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class RunnerScanner implements CommandLineRunner {

    @Autowired
    private EdificioRepository edificioRepository;
    @Autowired
    private PostazioneRepository postazioneRepository;
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private UtenteRepository utenteRepository;

    //scanner fuori
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String... args) throws Exception {



        //menu

        int scelta = -1;

        while (scelta!=0) {

            try {

                System.out.println("Welcome user!");
                System.out.println("1 - Esegui il Login");
                System.out.println("2 - Registrazione");
                System.out.println("0 - Esci");


                scelta = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Inserisci un numero valido.");
                continue;
            }

            switch (scelta){
                case 1 -> {
                    boolean loginRiuscito = false;

                    while (!loginRiuscito) {
                        try {


                            System.out.println("Inserisci l'username: ");
                            String username = scanner.nextLine();
                            System.out.println("Inserisci l'email'");
                            String email = scanner.nextLine();

                            //cerca utente nel database
                            Utente utente = utenteRepository.findByUsername(username);

                            //controlla che sia username che email siano corretti
                            if (utente != null && utente.getEmail().equals(email)) {
                                System.out.println("Accesso eseguito, " + username);
                                loginRiuscito = true;
                                menuPrincipale(utente);
                            } else {
                                System.out.println("Username o password errati. Riprova.\n");
                            }

                        } catch (Exception e) {
                            System.out.println("Errore durante il login: " + e.getMessage());
                        }
                    }
                }

                case 2 -> {

                    try {
                        System.out.println("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.println("Cognome: ");
                        String cognome = scanner.nextLine();
                        System.out.println("Inserisci l'username: ");
                        String username = scanner.nextLine();
                        System.out.println("Inserisci l'email");
                        String email = scanner.nextLine();

                        if (utenteRepository.existsByUsername(username)) {
                            throw new UsernameEsistenteException("Username già esistente.");
                        }

                        Utente utente = new Utente(nome, cognome, username, email);
                        utenteRepository.save(utente);
                        System.out.println("Registrazione completata!");
                    } catch (UsernameEsistenteException e) {
                        System.out.println("Errore: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Errore durante la creazione dell'utente: " + e.getMessage());
                    }

                }

                case 0 -> System.out.println("Alla prossima!");
                default -> System.out.println("scelta non valida");
            }

        }

    }

    private void menuPrincipale(Utente utente){
        boolean continua = true;
        int scelta1 = -1;

        while (continua) {
            try {

                System.out.println("\n--- MENU PRINCIPALE ---");
                System.out.println("1) Cerca postazioni disponibili per città e prenota");
                System.out.println("2) Cerca postazioni disponibili per tipo e prenota");
                System.out.println("3) Visualizza prenotazioni in corso");
                System.out.println("0) Logout");

                scelta1 = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Inserisci un numero valido!");
                continue;
            }

            switch (scelta1) {
                case 1 -> {
                    System.out.println("Inserisci");
                }
                case 2 -> {}
                case 3 -> {}
                case 0 -> continua = false;
                default -> System.out.println("Scelta non valida");
            }



        }
    }
}
