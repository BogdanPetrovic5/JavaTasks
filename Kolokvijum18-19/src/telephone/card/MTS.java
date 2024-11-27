package telephone.card;

public class MTS extends MobileCard{
    private double _freeMinutes;

    public MTS(String cardNumber, int freeMinutes){
        super(cardNumber);
        _freeMinutes = freeMinutes;
    }

    @Override
    public double getCheck() {
        return super.getCheck() - _freeMinutes * PriceList.get_priceMinuteMobilPhone();
    }
}
