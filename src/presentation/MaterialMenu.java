package presentation;

import application.MaterialService;
import presentation.util.InputParser;
import presentation.util.ValidateInput;
import presentation.util.OutputFormatter;
import java.util.Scanner;

public class MaterialMenu {

    private final Scanner scanner;
    private final MaterialService materialService;
    private final InputParser inputParser;
    private final ValidateInput validateInput;
    private final OutputFormatter outputFormatter;

    public MaterialMenu(
            Scanner scanner,
            MaterialService materialService,
            InputParser inputParser,
            ValidateInput validateInput,
            OutputFormatter outputFormatter) {

        this.scanner = scanner;
        this.materialService = materialService;
        this.inputParser = inputParser;
        this.validateInput = validateInput;
        this.outputFormatter = outputFormatter;
    }

    public void show() {
        boolean running = true;

        while (running) {
            printMenu();

            String input = scanner.nextLine();

            if (!validateInput.isInteger(input)) {
                outputFormatter.printError("Invalid menu choice.");
                continue;
            }

            int choice = inputParser.parseInt(input);

            switch (choice) {
                case 1 -> addMaterial();
                case 2 -> listMaterials();
                case 0 -> running = false;
                default -> outputFormatter.printError("ERROR:Choose between 0 and 2");
            }
        }
    }

    private void printMenu() {
        outputFormatter.printHeader("Material Menu");
        outputFormatter.printMessage("1. Add Material");
        outputFormatter.printMessage("2. List Materials");
        outputFormatter.printMessage("0. Back");
        outputFormatter.printPrompt("Choose option: ");
    }

    private void addMaterial() {

        outputFormatter.printPrompt("Enter material name: ");
        String name = scanner.nextLine();

        outputFormatter.printPrompt("Enter impact value: ");
        String impactInput = scanner.nextLine();

        outputFormatter.printPrompt("Enter recycling instruction: ");
        String recycling = scanner.nextLine();

        materialService.createMaterial(name, impactInput, recycling);

        outputFormatter.printSuccess("Material created.");
    }

    private void listMaterials() {
        outputFormatter.printHeader("Registered Materials");
        outputFormatter.printMaterials(materialService.getAllMaterials());
    }
}