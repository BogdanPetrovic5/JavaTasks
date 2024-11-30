package prevoz;

import merljivi.Osoba;
import merljivi.interfaces.Merljiv;
import merljivi.tovar.Paket;

public class PutnickiAvion extends Avion{

    public PutnickiAvion(String oznaka, double maksimalnaTezina, double tezina) throws Exception {
        super(oznaka, maksimalnaTezina, tezina);
    }


    @Override
    public void dodajMerljiv(Merljiv merljiv) throws Exception {


        if(merljiv.dajTezinu() + super.dajTezinu() > super.maksimalnaTezina) throw new Exception("Avion preopterecen");
        if(!(merljiv instanceof Osoba) && !(merljiv instanceof Paket)) throw new Exception("Samo su osobe ili paketi dostupni za transport");

        for(int i = 0; i < merljivi.length;i++){
            if(merljivi[i] == null){
                merljivi[i] = merljiv;
                break;
            }

        }
        super.setTezinaPrazan(merljiv.dajTezinu() + super.dajTezinu());

    }

    @Override
    public void dodajMerljiv(Merljiv merljiv, int index) throws Exception {

        if(merljiv.dajTezinu() + super.dajTezinu() > super.maksimalnaTezina) throw new Exception("Avion preopterecen");
        if(!(merljiv instanceof Osoba) && !(merljiv instanceof Paket)) throw new Exception("Samo su osobe ili paketi dostupni za transport");
        if(merljivi[index] != null) throw new Exception("Mesto vec zauzeto");
        merljivi[index] = merljiv;

    }

    @Override
    public String toString() {
        String stringReprezentacija = "";
        stringReprezentacija = super.toString();

        for(Merljiv merljiv : merljivi){
            if(merljiv != null){
                if(merljiv instanceof Osoba){
                    stringReprezentacija = stringReprezentacija + " " + merljiv.dajNaziv() + " " + dajTezinu() + " ";
                }
            }


        }
        for(Merljiv merljiv : merljivi){
            if(merljiv != null){
                if(merljiv instanceof Paket){
                    stringReprezentacija = stringReprezentacija + " " + merljiv.dajNaziv() + " " + dajTezinu() + " ";
                }
            }


        }

        return stringReprezentacija;
    }
}
