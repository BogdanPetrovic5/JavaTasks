package merljivi;

import merljivi.interfaces.Merljiv;

public class Osoba implements Merljiv {
    protected   String ime;
    protected double tezina;
    @Override
    public double dajTezinu() {
        return 0;
    }

    @Override
    public String dajNaziv() {
        return "";
    }
}
