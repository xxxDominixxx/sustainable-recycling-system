package application;

import domain.Product;
import infrastructure.ProductStorage;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    // SESSION storage (temporary)
    private final List<Product> sessionProducts = new ArrayList<>();

    // FILE storage
    private final ProductStorage storage;

    public ProductService(ProductStorage storage) {
        this.storage = storage;
    }

    // CREATE PRODUCT (session only)
    public CreateProductResult createProduct(CreateProductRequest request) {

        Product product = new Product(
            request.getProductName(),
            request.getProductCategory(),
            request.getEstimatedLifespan()
        );

        sessionProducts.add(product);

        return new CreateProductResult(product.getProductName());
    }

    // MOVE CREATED PRODUCT TO FILE
    public void addProductToStorage(String productName) {

        Product target = null;

        for (Product p : sessionProducts) {
            if (p.getProductName().equals(productName)) {
                target = p;
                break;
            }
        }

        if (target != null) {
            storage.save(target);
            sessionProducts.remove(target);
        } else {
            System.out.println("Product not found in session: " + productName);
        }
    }

    // READ from file
    public List<Product> getAllProducts() {
        return storage.findAll();
    }

    // DELETE from file
    public void removeProductFromStorage(String productName) {
        storage.deleteByName(productName);
    }

    // view session products
    public List<Product> getSessionProducts() {
        return sessionProducts;
    }
}