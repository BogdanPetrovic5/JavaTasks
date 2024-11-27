package Buyers;

import Exceptions.BudgetException;
import Exceptions.NotEnoughException;
import Shop.Product;
import Shop.Shop;
import Shop.Food;
import Shop.Bulk;

import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Buyer {
    public String name;
    public  double budget;
    int maxProducts;


    static double currentBudget = 0;
    public List<Product> wishlist;
    Shop shop;

    public  Buyer(String name, double budget, int maxProducts){
        this.name = name;
        this.budget = budget;
        this.maxProducts = maxProducts;
        wishlist = new ArrayList<>();
    }
    public void updateWishlist(Product newProduct, int quantity, Shop shop){
        boolean found = false;

        if(this._checkShop(newProduct, shop, quantity)){

            if(currentBudget + newProduct.price * quantity <= budget ){
                if(wishlist != null){
                    for (Product product : wishlist) {

                        if (product.getClass() == newProduct.getClass() && product.name.equals(newProduct.name)) {

                            if(product instanceof Food){
                                ((Food) product).sellQuantity += quantity;
                            }else if(product instanceof Bulk) ((Bulk) product).sellQuantity += quantity;

                            found = true;
                            break;
                        }
                    }
                }

                if (!found) {
                    if(newProduct instanceof Food){
                        ((Food) newProduct).sellQuantity = quantity;
                    }else if(newProduct instanceof Bulk) ((Bulk) newProduct).sellQuantity = quantity;
                    wishlist.add(newProduct);

                }
                currentBudget = this.wishlistValue(quantity);
            }else throw new BudgetException("Not enough budget");

        }else throw new NotEnoughException("Not enough items in store");


    }
    public double wishlistValue(int quantity){
        double value = 0;
        for(Product product : wishlist){
            if(product != null){
                value += product.price * quantity;
            }

        }
        return value;
    }

    public void addToWishlist(Shop shop, Product newProduct, int quantity){
        updateWishlist(newProduct, quantity, shop);
        this.shop = shop;

    }
    public void buy(){
        if(Objects.nonNull(shop) && Objects.nonNull(wishlist)){
            for(Product product : wishlist){
                if(product instanceof Food) shop.giveToCustomer(product, ((Food) product).sellQuantity);
                else if(product instanceof  Bulk) shop.giveToCustomer(product, ((Bulk) product).sellQuantity);

                budget -= product.price;
            }
        }
    }

    @Override
    public String toString() {
        return "Kupac {" + this.name + "}";
    }

    private boolean _checkShop(Product newProduct, Shop shop, int quantity){
        for(Product product : shop.products){
           if(product.getClass() == newProduct.getClass() && product.name.equals(newProduct.name)){
               if((product instanceof Food && ((Food) product).getQuantity() - quantity >= 0)){
                   return true;
               }
               if(product instanceof Bulk && ((Bulk) product).getQuantity() - quantity >= 0){
                   return  true;
               }
           }
        }
        return  false;
    }

}
