import merljivi.Osoba;
import merljivi.tovar.Kontejner;
import prevoz.Aerodrom;
import prevoz.PutnickiAvion;
import prevoz.TeretniAvion;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        char[] oznakaAerodroma = {'T', 'E', 'S', 'L', 'A'};

        Aerodrom aerodrom = new Aerodrom("Nikola Tesla", 10);

        Osoba osoba1 = new Osoba("Bogdan", 83.0);
        Osoba osoba2 = new Osoba("Ivana", 60.0);

        Kontejner kontejner = new Kontejner(900, 5);
        try{
            PutnickiAvion putnickiAvion = new PutnickiAvion("Boing64547", 9000.0, 8000.0);

            putnickiAvion.dodajMerljiv(osoba1);
            putnickiAvion.dodajMerljiv(osoba2);
//            System.out.println(putnickiAvion);
            System.out.println("\n\n\n");
            aerodrom.sleti(putnickiAvion);
            System.out.println("\n\n\n");
            aerodrom.ispisi();

            TeretniAvion teretniAvion = new TeretniAvion("TER1234567", 10000.0, 6000);
            putnickiAvion.dodajMerljiv(kontejner);

//            System.out.println(aerodrom);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}