package lettore_multimediale.immagine;

import lettore_multimediale.ElementoMultimediale;
import lettore_multimediale.Showable;

public class Immagine extends ElementoMultimediale implements Showable {

    private int luminosita;
    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = Math.max(luminosita, 0);
    }

    public int getLuminosita() {
        return luminosita;
    }

    public void alzaLum() {
        luminosita++;
    }

    public void abbassaLum() {
        if(luminosita > 0) {
            luminosita--;
        }
    }

    @Override
    public void show() {
        String esclamativi = "!".repeat(luminosita);
System.out.println(getTitolo() + " " + esclamativi);
    }
}
