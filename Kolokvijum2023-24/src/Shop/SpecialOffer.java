package Shop;


import Exceptions.AlreadySpecialOffer;
import Exceptions.BulkException;

public class SpecialOffer extends Food{
    private double _discount;

    public SpecialOffer(Product product, double discount){
        super(product.name, product.price - (product.price * (discount / 100)), 0);
        if(product instanceof SpecialOffer){
            throw new AlreadySpecialOffer("Object is type of special offer");
        }
        if(product instanceof Bulk){
            throw new BulkException("Object is type of Bulk");
        }
        this._discount = discount;
    }

    public SpecialOffer(SpecialOffer specialOffer, int quantity){
        super(specialOffer, quantity);
        this._discount = specialOffer._discount;
    }


    public double getStandardPrice() {
        return super.getQuantity() * super.getPrice() / (1 - (_discount / 100));
    }

    public Food takeFromDiscount(SpecialOffer specialOffer){
        return new Food(specialOffer.name, specialOffer.getQuantity() * specialOffer.getPrice() / (1 - (specialOffer._discount / 100)));
    }

    @Override
    public String toString() {
        return "[Akcija" + super.toString() + "%" + this._discount + "]";
    }
}
