import Buyers.Buyer;
import Buyers.Student;
import Exceptions.BudgetException;
import Exceptions.NotEnoughException;
import Shop.Shop;
import Shop.Product;
import Shop.SpecialOffer;
import Shop.Bulk;
import Shop.Food;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        List<Product> productList = new ArrayList<Product>();

        Product bulk1 = new Bulk("Rice", 150, 5000);
        Product bulk2 = new Bulk("Flour", 70, 3000);
        Product bulk3 = new Bulk("Oats", 100, 1000);

        productList.add(bulk1);
        productList.add(bulk2);
        productList.add(bulk3);

        Product food1 = new Food("Bread", 60, 10);
        Product food2 = new Food("Coca cola", 80, 10);
        Product food3 = new Food("Chocolate", 150, 10);

        productList.add(food1);
        productList.add(food2);
        productList.add(food3);

        Product food4 = new Food("Eggs", 13, 100);
        Food specialOffer = new SpecialOffer(food4, 20);

        Shop shop = new Shop(0, productList);

        for(Product product : shop.products){
            System.out.println(product.toString());
        }

        Buyer buyer1 = new Buyer("Marko", 500, 5);
        Buyer buyer2 = new Buyer("Milorad", 1000, 9);
        Buyer student = new Student("Uglješa", 300, 2);
        try {
            buyer1.addToWishlist(shop, new Food("Bread", food1.price), 15);

            buyer1.addToWishlist(shop, new Food("Chocolate", food3.price),1);



        }catch (NotEnoughException | BudgetException e){
            System.out.println("Error: " + e.getMessage());
        }


        try {
            buyer1.buy();
        }catch (BudgetException | NotEnoughException e){
            System.out.println("Error: " + e.getMessage());
       }
        System.out.println("\n\n");
        for(Product product : shop.products){
            System.out.println(product.toString());
        }

        System.out.println("\n\n");
        for(Product product : buyer1.wishlist){
            System.out.println(product.toString());
        }
    }
}