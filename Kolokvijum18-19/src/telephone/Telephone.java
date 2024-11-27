package telephone;

public abstract class Telephone {
    private String _brand;

    public Telephone(String brand){
        this._brand = brand;
    }

    public String get_brand() {
        return this._brand;
    }
    public abstract double getCheck();

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + getPhoneNumber() + " " + getCheck();
    }
    public abstract String getPhoneNumber();

}
