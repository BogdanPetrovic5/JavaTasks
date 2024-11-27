package Shop;

public class Food extends Product{

    private int _quantity;
    public int fillLimit = 20;
    public int sellQuantity = 0;

    public Food(String name, double price){
        super(name,price);
        this._quantity = 0;
    }
    public Food(String name, double price, int quantity){
        super(name,price);
        this._quantity = quantity;
    }
    public Food(Product product, int _quantity){
        super(product.name, product.price);
        this._quantity = _quantity;
    }
    public int getQuantity(){
        return this._quantity;
    }
    public void setQuantity(int quantity){
        this._quantity = quantity;
    }


    @Override
    public double getPrice() {
        return super.price * (double)this._quantity;
    }

    @Override
    public String toString() {
        return "[ Namirnica [ "+ super.toString() +  " ] " + getQuantity() + " ]";
    }
}
