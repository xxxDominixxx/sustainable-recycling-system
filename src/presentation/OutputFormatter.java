package presentation;

import application.CreateProductResult;

public class OutputFormatter {

    public void printCreateProduct(CreateProductResult result) {
        System.out.println("Product created successfully: " + result.getProductName());
    }
}