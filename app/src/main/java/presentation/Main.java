package presentation;

import java.util.Scanner;

import application.MaterialService;
import application.ProductService;
import infrastructure.MemoryStorage;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ===== APPLICATION / INFRASTRUCTURE SETUP =====
        ProductService productService =
                new ProductService(new MemoryStorage());

        MaterialService materialService =
                new MaterialService();

        // ===== PRESENTATION HELPERS =====
        InputParser inputParser =
                new InputParser(scanner, materialService);

        OutputFormatter outputFormatter =
                new OutputFormatter();

        ProductView productView =
                new ProductView(scanner);

        // ===== MENUS =====
        Menu menu = new Menu(scanner);

        ProductMenu menuP = new ProductMenu(
                scanner,
                productService,
                inputParser,
                outputFormatter,
                productView
        );

        MaterialMenu menuM = new MaterialMenu(
                scanner,
                materialService
        );

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