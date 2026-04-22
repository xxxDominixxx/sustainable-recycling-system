import java.util.Scanner;

public class ProductMenu {

    private final Scanner scanner;

    public ProductMenu(Scanner scanner) {
        this.scanner = scanner;
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
                    System.out.println("Product creation.mp3");
                    break;

                case "2":
                    System.out.println("Product added to list");
                    break;

                case "3":
                    System.out.println("Product removed from list");
                    break;
                
                case "4":
                    System.out.println("Displaying list...");
                    break;

                case "5":
                    System.out.println("Displaying product information");
                    break;

                case "b":
                    System.out.println("Returning to main menu...");
                    break;

                default:
                    System.out.println("Invalid option");
            }

        } while (!choice.equalsIgnoreCase("b"));
    }
}