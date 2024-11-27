package Shop;

import Exceptions.NotComparable;
import Shop.Interfaces.IComparable;

public abstract class Product implements IComparable {
    public String name;
    public double price;


    public Product(){}
    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }
    public abstract double getPrice();

    @Override
    public String toString(){
        return name + " " + price;
    }

    @Override
    public boolean compare(Object object) {
        if(!(object instanceof Product)){
            throw new NotComparable("Objects are not of the same type!");
        }
        Product product = (Product)object;
        return product.name.equals(this.name) && product.price == this.price;
    }
}
