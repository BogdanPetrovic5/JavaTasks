package telephone;

import telephone.card.MobileCard;
import telephone.card.VIP;
import telephone.card.interfaces.IDiscount;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone extends Telephone implements IDiscount {
    private List<MobileCard> mobileCardList = new ArrayList<>();
    private int _maxCards;

    public MobilePhone(String brand, int maxCard){
        super(brand);
        _maxCards = maxCard;

    }

    public double getCheck(){
        double totalCheck = 0;
        if(mobileCardList != null){
            for(MobileCard card : mobileCardList){
                totalCheck += card.getCheck();
            }
        }
        return totalCheck;
    }

    @Override
    public String getPhoneNumber() {
        StringBuilder numbers = new StringBuilder();
        if(mobileCardList != null){
            for(MobileCard card : mobileCardList){
                numbers.append(card.cardNumber).append(" ");
            }
        }
        return numbers.toString();
    }

    @Override
    public int giveDiscount() {
        int totalDiscount = 0;
        for(MobileCard card : mobileCardList){
            if(card instanceof VIP){
                totalDiscount += ((VIP) card).giveDiscount();
            }
        }
        return  totalDiscount;
    }

    public void addCard(MobileCard card) throws Exception {
        if(mobileCardList.size() < _maxCards){
            mobileCardList.add(card);
        }else throw new Exception("Slots exceeded");
    }
    public double removeCard(String number) throws Exception {
        if(mobileCardList != null){
            MobileCard card = mobileCardList.stream().filter(c -> c.cardNumber.equals(number)).findFirst().orElse(null);
            if(card != null){
               mobileCardList.remove(card);
               return card.getCheck();
            }

        }
        throw new Exception("No such card");


    }
    public void addTalk(String number, int minutes){
        if(mobileCardList != null){
            MobileCard card = mobileCardList.stream().filter(c -> c.cardNumber.equals(number)).findFirst().orElse(null);
            if(card != null){

                card.addSpentMinutes(minutes);
            }
        }
    }
    public void addSMS(String number, int sms){
        if(mobileCardList != null){
            MobileCard card = mobileCardList.stream().filter(c -> c.cardNumber.equals(number)).findFirst().orElse(null);
            if(card != null){

                card.addSpentMinutes(sms);
            }
        }
    }


}
