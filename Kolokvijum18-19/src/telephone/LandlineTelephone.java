package telephone;

import telephone.card.PriceList;

public class LandlineTelephone extends Telephone{
    private int _spentMinutes = 0;
    private String _phoneNumber;

    public  LandlineTelephone(String brand, String phoneNumber){
        super(brand);
        this._phoneNumber = phoneNumber;
    }
    @Override
    public double getCheck() {
        return PriceList.get_priceMinuteLandlinePhone() * _spentMinutes;
    }

    public void addTalk(int minutes){
        _spentMinutes += minutes;
    }

    @Override
    public String getPhoneNumber() {
        return _phoneNumber;
    }
}
