package telephone.card;

public abstract class MobileCard{
    public  String cardNumber;
    private int _minutesSpent = 0;
    private int _sentSMS = 0;

    public MobileCard(String cardNumber){

        this.cardNumber = cardNumber;
    }

    public int get_minutesSpent() {
        return _minutesSpent;
    }

    public void set_minutesSpent(int _minutesSpent) {
        this._minutesSpent = _minutesSpent;
    }

    public int get_sentSMS() {
        return _sentSMS;
    }

    public void set_sentSMS(int _sentSMS) {
        this._sentSMS = _sentSMS;
    }
    public void addSpentMinutes(int minutesSpent){
        this._minutesSpent += minutesSpent;
    }

    public void addSentSMS(int sentSMS){
        this._sentSMS += sentSMS;
    }

    public double getCheck(){
        double check = 0;

        check = (double)get_minutesSpent() * PriceList.get_priceMinuteMobilPhone() + get_sentSMS() * PriceList.get_priceSMS();

        return  check;
    }

}
