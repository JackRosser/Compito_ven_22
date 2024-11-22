package lettore_multimediale.audio;
import lettore_multimediale.ElementoMultimediale;
import lettore_multimediale.Playable;

// inizializzo il costruttore
public class Audio extends ElementoMultimediale implements Playable{
    private int volume;
    private int durata;

    public Audio(String titolo, int volume, int durata) {
        super(titolo);
        this.volume = Math.max(volume, 0);
        this.durata = Math.max(durata, 1);
    }

    // qua metto i getter che mi permettono di richiamare i valori successivamente
    public int getVolume() {
        return volume;
    }

    public int getDurata() {
        return durata;
    }

    // definisco le funzioni per alzamento e abbassamento volume
    public void alzaVolume() {
        volume++;
    }

    public void abbassaVolume() {
        if (volume > 0) {
            volume --;
        }
    }


    // specifico la classe play per il mio audio.
    // ripete l'audio a seconda della durata e mette i punti esclamativi a seconda del volume
    @Override
    public void play() {
String esclamativi = "!".repeat(volume);
        for (int i = 0; i < durata; i++) {
    System.out.println((getTitolo() + " " + esclamativi));
};
    }

}
