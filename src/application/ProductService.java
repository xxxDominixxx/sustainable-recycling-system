package application;
import domain.Product;

public class ProductService {

    public void createProduct(String productName){
        Product product = new Product(productName, "default", 10);
        System.out.println("Product created: " + product.getProductName());

    }



}
