package prevoz;

import merljivi.Osoba;
import merljivi.interfaces.Merljiv;
import merljivi.tovar.Kontejner;
import merljivi.tovar.Paket;

public class TeretniAvion extends Avion{
    public TeretniAvion(String oznaka, double maksimalnaTezina, double tezinaPrazan) throws Exception {
        super(oznaka, maksimalnaTezina, tezinaPrazan);
    }

    @Override
    public void dodajMerljiv(Merljiv merljiv) throws Exception {
        if(merljiv.dajTezinu() + super.dajTezinu() < super.maksimalnaTezina) throw new Exception("Avion preopterecen");
        if(!(merljiv instanceof Kontejner)) throw new Exception("Samo su kontejneri dostupni za transport!");
        for(int i = 0; i < merljivi.length;i++){
            if(merljivi[i] == null){
                merljivi[i] = merljiv;
                break;
            }
        }
        super.setTrenutnaTezina();
    }

    @Override
    public void dodajMerljiv(Merljiv merljiv, int index) throws Exception {
        if(merljiv.dajTezinu() + super.dajTezinu() < super.maksimalnaTezina) throw new Exception("Avion preopterecen");
        if(!(merljiv instanceof Kontejner)) throw new Exception("Samo su kontejneri dostupni za transport!");
        if(merljivi[index] != null) throw new Exception("Mesto vec zauzeto");
        merljivi[index] = merljiv;
        super.setTrenutnaTezina();
    }
}
