package presentation;

import java.util.Scanner;

import application.CreateProductRequest;
import application.CreateProductResult;
import application.ProductService;

public class ProductMenu {

    private final Scanner scanner;
    private final ProductService productService;
    private final InputParser inputParser;
    private final OutputFormatter outputFormatter;
    private final ProductView productView;

    public ProductMenu(Scanner scanner,
                       ProductService productService,
                       InputParser inputParser,
                       OutputFormatter outputFormatter,
                       ProductView productView) {

        this.scanner = scanner;
        this.productService = productService;
        this.inputParser = inputParser;
        this.outputFormatter = outputFormatter;
        this.productView = productView;
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
                    productView.showSessionProducts(
                            productService.getSessionProducts()
                    );
                    break;

                case "3":
                    System.out.print("Enter product name: ");
                    productService.addProductToStorage(scanner.nextLine());
                    System.out.println("Product added to storage.");
                    break;

                case "4":
                    System.out.print("Enter product name to remove: ");
                    productService.removeProductFromStorage(scanner.nextLine());
                    System.out.println("Product removed (if it existed).");
                    break;

                case "5":
                    productView.showStoredProducts(
                            productService.getAllProducts()
                    );
                    break;

                case "6":
                    productView.handleProductInfo(productService);
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

        CreateProductRequest request =
                inputParser.readCreateProductRequest();

        CreateProductResult result =
                productService.createProduct(request);

        outputFormatter.printCreateProduct(result);
    }
}