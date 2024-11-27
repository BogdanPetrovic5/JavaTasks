package telephone.card;

public class PriceList {
    private static double _priceMinuteLandlinePhone = 7.0;

    private static double _priceMinuteMobilPhone = 10.0;

    private static double _priceSMS = 5.0;

    public static double get_priceMinuteLandlinePhone() {
        return _priceMinuteLandlinePhone;
    }

    public static double get_priceMinuteMobilPhone() {
        return _priceMinuteMobilPhone;
    }

    public static double get_priceSMS() {
        return _priceSMS;
    }

    public static void set_priceMinuteLandlinePhone(double _priceMinuteLandlinePhone) {
        PriceList._priceMinuteLandlinePhone = _priceMinuteLandlinePhone;
    }

    public static void set_priceMinuteMobilPhone(double _priceMinuteMobilPhone) {
        PriceList._priceMinuteMobilPhone = _priceMinuteMobilPhone;
    }

    public static void set_priceSMS(double _priceSMS) {
        PriceList._priceSMS = _priceSMS;
    }
}
