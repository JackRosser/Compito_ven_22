package lettore_multimediale.video;

import lettore_multimediale.ElementoMultimediale;
import lettore_multimediale.Playable;

public class Video extends ElementoMultimediale implements Playable {
    private int durata;
    private int luminosita;
    private int volume;

    public Video(String titolo, int durata, int luminosita, int volume) {
        super(titolo);
        this.durata = Math.max(durata, 1);
        this.luminosita = Math.max(luminosita, 0);
        this.volume = Math.max(volume, 0);
    }

    public int getDurata() {
        return durata;
    }

    public int getLuminosita() {
        return luminosita;
    }

    public int getVolume() {
        return volume;
    }

    public void alzaVol() {
        volume++;
    }
    public void alzaLum() {
        luminosita++;
    }

    public void abbassaVol() {
        if (volume > 0) {
            volume--;
        }
    }

    public void abbassaLum() {
        if (luminosita > 0) {
            luminosita--;
        }
    }


    @Override
    public void play() {
        String esclamativi = "!".repeat(volume);
        String asterischi = "*".repeat(luminosita);
        for (int i = 0; i < durata; i++) {
            System.out.println(getTitolo() + " " + esclamativi + asterischi);
        }
    }
}
