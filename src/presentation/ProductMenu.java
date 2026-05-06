package presentation;

import java.util.List;
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
            System.out.println("2) View session products");
            System.out.println("3) Add Product to List");
            System.out.println("4) Remove Product from List");
            System.out.println("5) Display List");
            System.out.println("6) Product Information");
            System.out.println("b) Back to main menu");

            System.out.print("Enter choice: ");
            choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    createProduct();
                    break;
                
                case "2":
                    listSessionProducts();
                    break;

                case "3":
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();

                    productService.addProductToStorage(name);
                    System.out.println("Product added to list.");
                    break;

                case "4":
                    System.out.println("Enter product name to remove: ");
                    String removeName = scanner.nextLine();

                    productService.removeProductFromStorage(removeName);
                    System.out.println("Product removed (if it existed).");
                    break;

                case "5":
                    listProducts();
                    break;

                case "6":
                    System.out.println("Displaying product information (not implemented yet)");
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

    private void listSessionProducts() {
        List<Product> sessionProducts = productService.getSessionProducts();

        if (sessionProducts.isEmpty()) {
            System.out.println("No products in session");
            return;
        }

        System.out.println("\n--- Session Products ---");

        for (Product p : sessionProducts) {
            System.out.println(
                p.getProductName() + " | " +
                p.getProductCategory() + " | " +
                p.getEstimatedLifespan()
            );
        }
    }
}