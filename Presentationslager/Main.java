import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Menu menu = new Menu(scanner);
        ProductMenu menuP = new ProductMenu(scanner);
        MaterialMenu menuM = new MaterialMenu(scanner);
        RecyclingMenu menuR = new RecyclingMenu(scanner);

        String choice;

        do {
            menu.printMainMenu();
            choice = menu.getChoice();

            switch (choice) {

                case "1":
                    menuP.run();    // switch to Product menu
                    break;

                case "2":
                    menuM.run();    // switch to Material menu
                    break;

                case "3":
                    menuR.run();    // switch to Recycling menu
                    break;

                case "q":
                case "Q":
                    System.out.println("Quitting program...");
                    break;

                default:
                    System.out.println("Unknown choice. Try again.");
            }

        } while (!choice.equalsIgnoreCase("q"));

        scanner.close();
    }
}