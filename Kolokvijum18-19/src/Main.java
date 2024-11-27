import telephone.LandlineTelephone;
import telephone.MobilePhone;
import telephone.Telephone;
import telephone.card.MTS;
import telephone.card.MobileCard;
import telephone.card.VIP;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MobilePhone telephone1 = new MobilePhone("Samsung", 2);
        MobilePhone telephone2 = new MobilePhone("Honor", 1);
        MobilePhone telephone3 = new MobilePhone( "Redmi", 2);

        LandlineTelephone telephone4 = new LandlineTelephone("LG", "034 111 111");
        LandlineTelephone telephone5 = new LandlineTelephone("Toshiba", "034 222 222");



        MobileCard card1 = new VIP("062 111 111");
        MobileCard card2 = new VIP("062 111 222");
        MobileCard card6 = new MTS("063 222 344", 40);

        MobileCard card3 = new MTS("063 111 333", 10);

        MobileCard card4 = new MTS("063 222 222", 20);
        MobileCard card5 = new VIP("062 222 333");


        List<MobileCard> mobileCardList = new ArrayList<>();
        List<Telephone> telephoneList = new ArrayList<>();
        try{
            telephoneList.add(telephone1);
            telephoneList.add(telephone2);
            telephoneList.add(telephone3);
            telephoneList.add(telephone4);
            telephoneList.add(telephone5);

            if(telephone1 instanceof  MobilePhone && telephone2 instanceof MobilePhone && telephone3 instanceof MobilePhone){
                try {
                    telephone1.addCard(card6);
                    telephone1.addCard(card1);
                    telephone1.addCard(card2);

                }catch (Exception e){
                    System.out.println(e.getMessage());
                }


                telephone2.addCard(card3);


                telephone3.addCard(card4);
                telephone3.addCard(card5);

                telephone1.addTalk(card1.cardNumber, 90);
                telephone1.addTalk(card2.cardNumber, 20);





                telephone2.addTalk(card3.cardNumber, 30);

                telephone3.addTalk(card4.cardNumber, 30);
                telephone3.addTalk(card5.cardNumber, 20);
                telephone3.addSMS(card5.cardNumber, 40);
                try {
                    System.out.println("Removed card: " + telephone1.removeCard(card3.cardNumber) + "\n");
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }

                Test.usage(telephoneList);

                Test.check(telephoneList);
                System.out.println("\n");
                Test.printDiscounts(telephoneList);
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }



    }
}