package presentation;

import java.util.Scanner;

import application.ProductService;
import infrastructure.MemoryStorage;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create dependencies
        ProductService productService = new ProductService(new MemoryStorage());
        InputParser inputParser = new InputParser(scanner);
        OutputFormatter outputFormatter = new OutputFormatter();

        // Menus
        Menu menu = new Menu(scanner);
        ProductMenu menuP = new ProductMenu(
                scanner,
                productService,
                inputParser,
                outputFormatter
        );
        MaterialMenu menuM = new MaterialMenu(scanner);
        RecyclingMenu menuR = new RecyclingMenu(scanner);

        String choice;

        do {
            menu.printMainMenu();
            choice = menu.getChoice();

            switch (choice) {

                case "1":
                    menuP.run();
                    break;

                case "2":
                    menuM.run();
                    break;

                case "3":
                    menuR.run();
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