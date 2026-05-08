package presentation;

import application.CreateProductRequest;
import application.MaterialService;

import domain.Material;
import domain.ProductMaterial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputParser {

    private final Scanner scanner;
    private final MaterialService materialService;

    public InputParser(Scanner scanner,
                       MaterialService materialService) {

        this.scanner = scanner;
        this.materialService = materialService;
    }

    public CreateProductRequest readCreateProductRequest() {

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        List<ProductMaterial> selectedMaterials =
                new ArrayList<>();

        double totalPercentage = 0;

        boolean adding = true;

        while (adding) {

            System.out.println("\n--- Available Materials ---");

            List<Material> materials =
                    materialService.getAllMaterials();

            for (int i = 0; i < materials.size(); i++) {

                System.out.println(
                        (i + 1)
                        + ") "
                        + materials.get(i).getMaterialName()
                );
            }

            System.out.print("Select material number: ");

            int choice;

            try {

                choice = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");
                continue;
            }

            if (choice < 1 || choice > materials.size()) {

                System.out.println("Invalid selection.");
                continue;
            }

            Material selected =
                    materials.get(choice - 1);

            System.out.print(
                    "Enter percentage for "
                    + selected.getMaterialName()
                    + ": "
            );

            double percentage;

            try {

                String percentageInput =
                        scanner.nextLine()
                                .replace("%", "")
                                .trim();

                percentage =
                        Double.parseDouble(percentageInput);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid percentage. Please enter a number."
                );

                continue;
            }

            if (percentage <= 0 || percentage > 100) {

                System.out.println(
                        "Percentage must be between 1 and 100."
                );

                continue;
            }

            if (totalPercentage + percentage > 100) {

                System.out.println(
                        "Total percentage cannot exceed 100%."
                );

                continue;
            }

            selectedMaterials.add(
                    new ProductMaterial(selected, percentage)
            );

            totalPercentage += percentage;

            if (totalPercentage == 100) {

                System.out.println(
                        "Material composition completed (100%)."
                );

                break;
            }

            System.out.print("Add another material? (y/n): ");

            adding =
                    scanner.nextLine()
                            .equalsIgnoreCase("y");
        }

        if (totalPercentage < 100) {

            System.out.println(
                    "Warning: total percentage is less than 100%."
            );
        }

        return new CreateProductRequest(
                name,
                selectedMaterials
        );
    }
}