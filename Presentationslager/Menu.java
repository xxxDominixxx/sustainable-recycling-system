import java.util.Scanner;

public class Menu {

    private final Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printMainMenu() {
        System.out.println("\n=================");
        System.out.println(" MAIN MENU");
        System.out.println("=================");
        System.out.println("1) Go to Product menu");
        System.out.println("2) Go to Material menu");
        System.out.println("3) Go to Recycling menu");
        System.out.println("q) Quit");
        System.out.println("=================");
    }

    public String getChoice() {
        System.out.print("Enter choice: ");
        return scanner.nextLine();
    }
}