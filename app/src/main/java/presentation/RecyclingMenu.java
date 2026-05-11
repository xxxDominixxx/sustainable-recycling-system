package presentation;

import java.util.Scanner;

public class RecyclingMenu {

    private final Scanner scanner;

    public RecyclingMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {

        String choice;

        do {
            System.out.println("\n==== Recycling Menu ====");
            System.out.println("1) Choose product by name"); //display list from product storage?
            System.out.println("2) Provide guidance"); //based on product category
            System.out.println("b) Back to main menu");

            System.out.print("Enter choice: ");
            choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    System.out.println("Your product is:");
                    break;

                case "2":
                    System.out.println("Provide guidance");
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