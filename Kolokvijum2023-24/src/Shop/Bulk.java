package Shop;

public class Bulk extends Product{
    private  int _quantity;
    public int fillLimit = 2000;
    public int sellQuantity = 0;
    public Bulk(String name, double price){
        super(name, price);
        this._quantity = 0;
    }
    public Bulk(String name, double price, int quantity){
        super(name, price);
        this._quantity = quantity;
    }

    public Bulk(Product product, int quantity){
        super(product.name, product.price);
        this._quantity = quantity;
    }
    @Override
    public double getPrice() {
        return (this._quantity/1000) * super.price;
    }

    public int getQuantity() {
        return _quantity;
    }

    public void setQuantity(int _quantity) {
        this._quantity = _quantity;
    }

    @Override
    public String toString() {
        return "[ Rinfuz [" + super.toString() + " ] " + _quantity + "]";
    }
}
