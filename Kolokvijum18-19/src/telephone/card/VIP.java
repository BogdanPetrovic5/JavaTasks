package telephone.card;

import telephone.card.interfaces.IDiscount;

public class VIP extends MobileCard implements IDiscount {
    private int _discount = 100;
    public VIP (String cardNumber){
        super(cardNumber);
    }

    @Override
    public int giveDiscount() {
        return this._discount;
    }

    @Override
    public double getCheck() {
        return super.getCheck() - giveDiscount();
    }
}
