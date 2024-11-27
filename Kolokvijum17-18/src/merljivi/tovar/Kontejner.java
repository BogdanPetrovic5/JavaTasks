package merljivi.tovar;

import merljivi.interfaces.Merljiv;

import java.lang.reflect.Array;

public class Kontejner implements Merljiv {
    private int jedinstveniBroj;

    public Merljiv[] merljivi;
    private double tezina;

    public Kontejner(double tezina, int kapacitet){
        this.tezina = tezina;
        merljivi = new Merljiv[kapacitet];
    }
    public void dodaj(){

    }
    public void izvadi(String naziv){
        for (Merljiv merljiv : merljivi) {
            if(merljiv != null && merljiv.dajNaziv().equals(naziv)){
                merljivi.r
            }
        }
    }
    @Override
    public double dajTezinu() {
        return 0;
    }

    @Override
    public String dajNaziv() {
        return "";
    }
}
