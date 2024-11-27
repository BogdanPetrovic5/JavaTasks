import telephone.LandlineTelephone;
import telephone.MobilePhone;
import telephone.Telephone;
import telephone.card.VIP;

import java.util.List;

public class Test {
    public static void printDiscounts(List<Telephone> telephoneList){
        int totalDiscount = 0;
        for(Telephone telephone : telephoneList){
            if(telephone instanceof MobilePhone){
                totalDiscount += ((MobilePhone) telephone).giveDiscount();
            }
        }
        System.out.println(totalDiscount);
    }
    public static void usage(List<Telephone> telephoneList){
        for(Telephone telephone : telephoneList){
            System.out.println(telephone.toString());
        }
    }
    public static void check(List<Telephone> telephoneList){
        double totalCheck = 0;
        for(Telephone telephone : telephoneList){
            totalCheck += telephone.getCheck();
        }
        System.out.println(totalCheck);
    }


}
