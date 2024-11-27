package Shop;

import Exceptions.NoSpace;
import Exceptions.NotEnoughException;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    public List<Product> products;
    public int capacity = 0;

    public Shop(int capacity, List<Product> products){

        this.capacity = capacity;
        this.products = products;
    }
    public void addToShop(Product newProduct){
        if(products.size() == capacity){
            throw new NoSpace("No more space.");
        }else{
            for(Product product : products){
                if(newProduct.name.equals(product.name)){
                    if(product instanceof Food){
                        ((Food)product).setQuantity( ((Food) product).getQuantity() + 1);
                    }else if(product instanceof Bulk){
                        ((Bulk) product).setQuantity( ((Bulk) product).getQuantity() + 1);
                    }else products.add(product);
                    break;
                }
            }
        }


    }

    public void fillShop(){
        for(Product product : products){
            if(product instanceof Food){
                Food food = (Food)product;
                if(food.getQuantity() <= food.fillLimit){
                    food.setQuantity(20);
                }
            }else if(product instanceof Bulk){
                Bulk bulk = (Bulk)product;
                if(bulk.getQuantity() <= bulk.fillLimit){
                    bulk.setQuantity(2000);
                }

            }
        }
    }
    public void removeFromStore(Product product){
        products.remove(product);
    }
    public Product giveToCustomer(Product customer, int quantity){
        for(Product product : products){
            if(customer instanceof Food && product instanceof Food){
                Food customerFood = (Food)customer;
                Food shopFood = (Food)product;

                if(customerFood.name.equals(shopFood.name)){
                    if(shopFood.getQuantity() - quantity >= 0){
                        shopFood.setQuantity(shopFood.getQuantity() - quantity);
                        if(shopFood.getQuantity() == 0) this.removeFromStore(product);
                        return shopFood;
                    }else{
                        throw new NotEnoughException("Not enough of products");
                    }
                }
            }else if(customer instanceof Bulk && product instanceof Bulk){
                Bulk customerBulk = (Bulk)customer;
                Bulk shopBulk = (Bulk)product;

                if(customerBulk.name.equals(product.name)){
                    if(shopBulk.getQuantity() - quantity >= 0){
                        shopBulk.setQuantity(shopBulk.getQuantity() - quantity);
                        if(shopBulk.getQuantity() == 0) this.removeFromStore(product);
                        return shopBulk;
                    }else{
                        throw new NotEnoughException("Not enough of products");
                    }
                }
            }
        }
        return null;
    }
    public void giveBack(Product product){
        addToShop(product);
    }

    @Override
    public String toString() {
        return products.toString();
    }
}
