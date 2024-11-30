package merljivi.tovar;

import merljivi.Osoba;
import merljivi.interfaces.Merljiv;

import java.lang.reflect.Array;

public class Kontejner implements Merljiv {
    private int jedinstveniBroj;
    private static  int broj = 0;
    public Merljiv[] merljivi;
    private double tezina;

    public Kontejner(double tezina, int kapacitet){
        this.tezina = tezina;
        this.jedinstveniBroj = ++broj;
        merljivi = new Merljiv[kapacitet];
    }
    public void dodaj(Merljiv merljivObjekat) throws Exception {
        if(merljivObjekat instanceof Osoba){
            throw  new Exception("Pogresan tip!");

        }
        int index = proveriMesto();
        if(index < 0){
            throw new Exception("Niz popunjen!");
        }
        merljivi[index] = merljivObjekat;

    }
    public void izvadi(String naziv){
        for (Merljiv merljiv : merljivi) {
            if(merljiv != null && merljiv.dajNaziv().equals(naziv)){
                merljiv = null;
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

    private int proveriMesto(){
        for(int i = 0; i < merljivi.length; i++){
            if(merljivi[i] == null) return  i;
        }
        return -1;
    }

}
