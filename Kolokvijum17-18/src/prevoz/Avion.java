package prevoz;

import merljivi.interfaces.Merljiv;

public abstract class Avion implements Merljiv {
    public String oznaka;
    public double maksimalnaTezina = 1000;
    private double tezinaPrazan;

    Merljiv[] merljivi = new Merljiv[10];

    public Avion(String oznaka, double maksimalnaTezina, double tezinaPrazan) throws Exception {
        this.maksimalnaTezina = maksimalnaTezina;
        this.tezinaPrazan = tezinaPrazan;
        if(oznaka.length() == 10){
            this.oznaka = oznaka;
        }else throw  new Exception("Oznaka mora da ima tacno 10 karaktera");
    }


    public void ispisi(){
        for(Merljiv merljiv : merljivi){
            if(merljiv != null)  System.out.println(merljiv);

        }

    }


    @Override
    public double dajTezinu() {
        return tezinaPrazan;
    }

    public void setTezinaPrazan(double tezinaPrazan) {
        this.tezinaPrazan = tezinaPrazan;
        System.out.println(tezinaPrazan);
    }

    @Override
    public String dajNaziv() {
        return  "";
    }

    public abstract void dodajMerljiv(Merljiv merljiv) throws Exception;
    public abstract void dodajMerljiv(Merljiv merljiv, int index) throws Exception;

    public void uzmi(int index) throws Exception {
        if(merljivi[index] == null) throw  new Exception("Prazno mesto");
        merljivi[index] = null;

    }

    public void setTrenutnaTezina(){


    }
    @Override
    public String toString() {
        return oznaka + "(" + this.dajTezinu() + ")";
    }
}
