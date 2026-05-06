package presentation;

import java.util.Scanner;

import application.CreateProductRequest;

public class InputParser {

    private final Scanner scanner;

    public InputParser(Scanner scanner) {
        this.scanner = scanner;
    }

    public CreateProductRequest readCreateProductRequest() {

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter product category: ");
        String category = scanner.nextLine();

        System.out.print("Enter estimated lifespan: ");
        int lifespan = Integer.parseInt(scanner.nextLine());

        return new CreateProductRequest(name, category, lifespan);
    }
}