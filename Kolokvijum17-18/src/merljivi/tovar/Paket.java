package merljivi.tovar;

import merljivi.interfaces.Merljiv;

public class Paket implements Merljiv {
    public  String opis;
    private double tezina;

    public  Paket(String opis, double tezina){
        this.opis = opis;
        this.tezina = tezina;
    }
    @Override
    public double dajTezinu() {
        return tezina;
    }

    @Override
    public String dajNaziv() {
        return opis;
    }
}
