package prevoz;

import merljivi.interfaces.Merljiv;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Aerodrom {
    protected String naziv;
    public Avion[] avioni;

    public Aerodrom(String oznaka, int kapacitet){

        this.naziv = oznaka;
        avioni = new Avion[kapacitet];
    }

    public void sleti(Avion avion){
      for(int i = 0; i < avioni.length;i++){
          if(avioni[i] == null){
              avioni[i] = avion;
              break;
          }
      }
    }
    public void ispisi(){
        for(Avion avion : avioni){
            if(avion != null) System.out.println(avion);

        }
    }
    public void odleti(char[] oznaka){
        for(Avion avion : avioni){
            if(this.naziv.equals(avion.oznaka)) {
                System.out.println(avion);
                break;
            }
        }
    }
    public void dodajMerljiv(char[] oznaka, Merljiv merljiv) throws Exception {
        for(Avion avion : avioni){
            if(this.naziv.equals(avion.oznaka)){
                try {
                    avion.dodajMerljiv(merljiv);
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public void dohvatiTezinu(){
        double ukupnaTezina = 0;
        for(Avion avion : avioni){
            if(avion != null) ukupnaTezina += avion.dajTezinu();

        }
        System.out.println(ukupnaTezina);
    }

    @Override
    public String toString() {
        String string = "";

        for(Avion avion : avioni){
            if(avion != null){
                if(avion instanceof PutnickiAvion){
                    string = string + "P";

                }
                if(avion instanceof TeretniAvion){
                    string = string + "T";
                }
                string = string + " " + avion.toString();
            }

        }
        return  string;
    }
}
