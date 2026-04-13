package presentation;
import application.ProductService;

public class Main {

    public static void main(String[] args) {

        System.out.println("Creates product");

        ProductService service = new ProductService();

        service.createProduct("Chair");

        System.out.println("Woohooo done");
    }
}