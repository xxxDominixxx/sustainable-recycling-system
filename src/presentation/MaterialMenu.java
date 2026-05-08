package presentation;

import java.util.Scanner;

import application.MaterialService;
import domain.Material;

public class MaterialMenu {

    private final Scanner scanner;
    private final MaterialService materialService;

    public MaterialMenu(Scanner scanner,
                        MaterialService materialService) {

        this.scanner = scanner;
        this.materialService = materialService;
    }

    public void run() {

        String choice;

        do {

            System.out.println("\n==== Material Menu ====");
            System.out.println("1) Material list");
            System.out.println("b) Back to main menu");

            System.out.print("Enter choice: ");
            choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    showMaterials();
                    break;

                case "b":
                    System.out.println("Returning to main menu...");
                    break;

                default:
                    System.out.println("Invalid option");
            }

        } while (!choice.equalsIgnoreCase("b"));
    }

    private void showMaterials() {

        System.out.println("\n--- Materials ---");

        for (Material m :
                materialService.getAllMaterials()) {

            System.out.println(
                    m.getMaterialName()
                            + " | Impact: "
                            + m.getImpact()
                            + " | "
                            + m.getCategory()
                            .getDescription()
            );
        }
    }
}