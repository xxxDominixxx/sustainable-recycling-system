package presentation;

import java.util.List;
import java.util.Scanner;

import application.ProductService;
import domain.Product;
import domain.ProductMaterial;

public class ProductView {

    private final Scanner scanner;

    public ProductView(Scanner scanner) {
        this.scanner = scanner;
    }

    // SESSION PRODUCTS
    public void showSessionProducts(List<Product> sessionProducts) {

        if (sessionProducts.isEmpty()) {
            System.out.println("No products in session");
            return;
        }

        System.out.println("\n--- Session Products ---");

        for (Product p : sessionProducts) {

            System.out.println(
                    p.getProductType()
                            + " | "
                            + p.getRecyclingCategory()
                            + " | "
                            + p.getEstimatedLifespan()
                            +" year"
            );
        }
    }

    // STORED PRODUCTS
    public void showStoredProducts(List<Product> products) {

        if (products.isEmpty()) {
            System.out.println("No stored products");
            return;
        }

        System.out.println("\n--- Stored Products ---");

        for (Product p : products) {

            System.out.println(
                    p.getProductType()
                            + " | "
                            + p.getRecyclingCategory()
                            + " | "
                            + p.getEstimatedLifespan()
                            + " year"
            );
        }
    }

    // OPTION 6 FULL FLOW
    public void handleProductInfo(ProductService productService) {

        System.out.println("\n--- Stored Products ---");

        for (Product p : productService.getAllProducts()) {
            System.out.println("- " + p.getProductType());
        }

        System.out.print("\nEnter product name: ");
        String name = scanner.nextLine();

        Product product =
                productService.findStoredProductByName(name);

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        displayProductInformation(product);
    }

    // FULL DETAILS
    private void displayProductInformation(Product found) {

        System.out.println("\n==== PRODUCT INFORMATION ====");

        System.out.println("Name: " + found.getProductType());
        System.out.println("Category: " + found.getRecyclingCategory());
        System.out.println("Estimated lifespan: "
                + found.getEstimatedLifespan() + " years");

        System.out.println("Environmental impact: "
                + found.getCalculatedImpact() + " Co2/kg");

        System.out.println("\nMaterials:");

        for (ProductMaterial pm : found.getMaterials()) {

            System.out.println(
                    "- "
                            + pm.getMaterial().getMaterialName()
                            + " ("
                            + pm.getPercentage()
                            + "%)"
            );
        }

        System.out.println("\nGuidance:");

        switch (found.getRecyclingCategory()) {

            case LOW:
                System.out.println("Low impact: recycle or reuse");
                break;

            case MEDIUM:
                System.out.println("Medium impact: recycle carefully");
                break;

            case HIGH:
                System.out.println("High impact: dispose responsibly");
                break;

            case MIXED:
                System.out.println("Mixed materials: separate if possible");
                break;
        }
    }
}