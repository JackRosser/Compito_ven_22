package lettore_multimediale;
import lettore_multimediale.audio.Audio;
import lettore_multimediale.immagine.Immagine;
import lettore_multimediale.video.Video;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        ElementoMultimediale[] raccoltaDati = new ElementoMultimediale[5];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < raccoltaDati.length; i++) {
            String elemento;
            while (true) {
                System.out.println("Inserisci oggetto numero " + (i + 1) + ": audio, video o immagine?");
                elemento = scanner.nextLine().toLowerCase();
                if (elemento.equals("audio") || elemento.equals("video") || elemento.equals("immagine")) {
                    break;
                } else {
                    System.out.println("Input non valido! Devi scrivere 'audio', 'video' o 'immagine'.");
                }
            }


            if (elemento.equals("audio")) {
                System.out.println("Inserisci un titolo per " + elemento + " " + (i + 1));
                String titolo = scanner.nextLine();
                System.out.println("Inserisci la durata");
                int durata = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Inserisci il volume");
                int volume = scanner.nextInt();
                scanner.nextLine();
                Audio audio = new Audio(titolo, volume, durata);
                System.out.println("Vuoi alzare il volume? s/n");
                String risposta = scanner.nextLine();
                if (risposta.equalsIgnoreCase("s")) {
                    audio.alzaVolume();
                    raccoltaDati[i] = audio;
                    System.out.println("Oggetto inserito in memoria con volume alzato");
                } else {
                    raccoltaDati[i] = audio;
                    System.out.println("Oggetto inserito in memoria senza alzare il volume");
                }
            }

            if (elemento.equals("video")) {
                System.out.println("Inserisci titolo per " + elemento + " " + (i + 1));
                String titolo = scanner.nextLine();
                System.out.println("Inserisci una durata");
                int durata = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Inserisci un volume");
                int volume = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Inserisci una luminosità");
                int luminosita = scanner.nextInt();
                scanner.nextLine();
                Video video = new Video(titolo, durata, luminosita, volume);
                raccoltaDati[i] = video;
                System.out.println("Oggetto Inserito");
            }

            if (elemento.equals("immagine")) {
                System.out.println("Inserisci un titolo per " + elemento + " " + (i + 1));
                String titolo = scanner.nextLine();
                System.out.println("Inserisci una luminosità");
                int luminosita = scanner.nextInt();
                scanner.nextLine();
                Immagine immagine = new Immagine(titolo, luminosita);
                raccoltaDati[i] = immagine;
            }
        }


// CHIUSURA FOR

        while (true) {
            System.out.println("Digita un numero per visualizzare l'elemento relativo al numero, premi 0 per uscire");
            int scelta = scanner.nextInt();
            scanner.nextLine();
            if (scelta == 0) {
                System.out.println("Programma terminato");
                break;
            } else if (scelta > 0 && scelta <= raccoltaDati.length && raccoltaDati[scelta - 1] != null) {
                if (raccoltaDati[scelta - 1] instanceof Immagine) {
                    ((Immagine) raccoltaDati[scelta - 1]).show();
                } else if (raccoltaDati[scelta - 1] instanceof Video) {
                    ((Video) raccoltaDati[scelta - 1]).play();
                } else if (raccoltaDati[scelta - 1] instanceof Audio) {
                    ((Audio) raccoltaDati[scelta - 1]).play();
                }
            } else {
                System.out.println("Inserire un numero valido");
            }
        }


        scanner.close();
    }
}
