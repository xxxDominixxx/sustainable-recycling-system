package presentation;
import application.CreateProductRequest;
import application.CreateProductResult;
import application.ProductService;
import domain.Product;

import java.util.Scanner;

public class ProductMenu {
    private ProductService productService;
    private InputParser inputParser;
    private OutputFormatter outputformatter;

    private Scanner scanner = new Scanner(System.in);

    public ProductMenu(ProductService productService, InputParser inputParser, OutputFormatter outputFormatter){
        this.productService = productService;
        this.inputParser = inputParser;
        this.outputformatter = outputFormatter;
    }

    public void displayMenu(){
        while (true) {
            System.out.println("\n === Product Menu ===");
            System.out.println("1. Create New Product");
            System.out.println("2. List Products");
            System.out.println("3. Back To Main Menu");
            
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1){
                createProduct();
            } else if (choice == 2){
                listProducts();
            } else if (choice == 3) {
                break;
            }else {
                System.out.println("Invalid choice, please try again!");
            }
        }
    }

    private void createProduct(){
        CreateProductRequest request = inputParser.readCreateProductRequest();

        CreateProductResult result =productService.createProduct(request);

        outputFormatter.printCreateProduct(result);
    }

    private void listProducts(){
        for (Product p : productService.getAllProducts()){
            System.out.println(p.getProductName());
        

        }    
    }

}
