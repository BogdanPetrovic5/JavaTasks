package Buyers;

import Buyers.Interfaces.IDiscount;
import Shop.Product;
import Shop.SpecialOffer;

public class Student extends Buyer implements IDiscount {
    public  String index;

    public Student(String name, double budget, int maxProducts) {
        super(name, budget, maxProducts);
    }

    @Override
    public double getDiscount() {
        double totalDiscount = 0;

        for(Product product : wishlist){
            if(!(product instanceof SpecialOffer)){
                totalDiscount = totalDiscount + (discount / 100);
            }
        }
        return  totalDiscount;
    }

    @Override
    public String toString() {
        return super.toString() + "- Student";
    }
}
