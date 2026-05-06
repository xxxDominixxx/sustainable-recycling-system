package application;

import domain.Product;
import infrastructure.ProductStorage;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    // SESSION (temporary products, not yet saved to file)
    private final List<Product> sessionProducts = new ArrayList<>();

    // PERSISTENCE (file storage via abstraction)
    private final ProductStorage storage;

    public ProductService(ProductStorage storage) {
        this.storage = storage;
    }

    // 1) CREATE PRODUCT (only stored in session)
    public CreateProductResult createProduct(CreateProductRequest request) {

        Product product = new Product(
            request.getProductName(),
            request.getProductCategory(),
            request.getEstimatedLifespan()
        );

        sessionProducts.add(product);

        return new CreateProductResult(product.getProductName());
    }

    // 2) MOVE PRODUCT FROM SESSION → FILE STORAGE
    public void addProductToStorage(String productName) {

        Product target = null;

        for (Product product : sessionProducts) {
            if (product.getProductName().equals(productName)) {
                target = product;
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

    // 3) GET ALL STORED PRODUCTS (FROM FILE)
    public List<Product> getAllProducts() {
        return storage.findAll();
    }

    // OPTIONAL: view session products (useful for debugging / menu option 5)
    public List<Product> getSessionProducts() {
        return sessionProducts;
    }
}