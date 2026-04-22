import java.util.Scanner;

public class MaterialMenu {

    private final Scanner scanner;

    public MaterialMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {

        String choice;

        do {
            System.out.println("\n==== Material Menu ====");
            System.out.println("1) Material list");
            System.out.println("2) Impact value");
            System.out.println("b) Back to main menu");

            System.out.print("Enter choice: ");
            choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    System.out.println("Displaying the list of materials");
                    break;

                case "2":
                    System.out.println("Displaying impact value of material");
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