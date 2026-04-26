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
            System.out.println("1) Check if product is recyclable");
            System.out.println("2) Display recycling guidance");
            System.out.println("b) Back to main menu");

            System.out.print("Enter choice: ");
            choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    System.out.println("To recycle or not to recycle");
                    break;

                case "2":
                    System.out.println("Guidance");
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