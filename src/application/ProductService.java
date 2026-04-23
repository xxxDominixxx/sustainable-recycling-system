package application;
import domain.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products = new ArrayList<>();

    public CreateProductResult createProduct(CreateProductRequest request) {
        Product product = new Product(
            request.getProductName(),
            request.getProductCategory(),
            request.getEstimatedLifespan()
    );

    products.add(product);

    return new CreateProductResult(product.getProductName());

    }

}
