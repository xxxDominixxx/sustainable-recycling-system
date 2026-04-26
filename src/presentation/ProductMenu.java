package presentation;

import java.util.Scanner;
import application.CreateProductRequest;
import application.CreateProductResult;
import application.ProductService;
import domain.Product;

public class ProductMenu {

    private final Scanner scanner;
    private final ProductService productService;
    private final InputParser inputParser;
    private final OutputFormatter outputFormatter;

    public ProductMenu(Scanner scanner,
                       ProductService productService,
                       InputParser inputParser,
                       OutputFormatter outputFormatter) {
        this.scanner = scanner;
        this.productService = productService;
        this.inputParser = inputParser;
        this.outputFormatter = outputFormatter;
    }

    public void run() {

        String choice;

        do {
            System.out.println("\n==== Product Menu ====");
            System.out.println("1) Create Product");
            System.out.println("2) Add Product to List");
            System.out.println("3) Remove Product from List");
            System.out.println("4) Display List");
            System.out.println("5) Product Information");
            System.out.println("b) Back to main menu");

            System.out.print("Enter choice: ");
            choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    createProduct();
                    break;

                case "2":
                    System.out.println("Product added to list"); //Not yet implemented
                    break;

                case "3":
                    System.out.println("Product removed from list"); //Not yet implemented
                    break;

                case "4":
                    listProducts();
                    break;

                case "5":
                    System.out.println("Displaying product information"); //Not yet implemented
                    break;

                case "b":
                    System.out.println("Returning to main menu...");
                    break;

                default:
                    System.out.println("Invalid option");
            }

        } while (!choice.equalsIgnoreCase("b"));
    }

    private void createProduct() {
        CreateProductRequest request = inputParser.readCreateProductRequest();
        CreateProductResult result = productService.createProduct(request);
        outputFormatter.printCreateProduct(result);
    }

    private void listProducts() {
        for (Product p : productService.getAllProducts()) {
            System.out.println(p.getProductName());
        }
    }
}