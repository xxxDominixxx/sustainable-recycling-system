package application;

import java.util.ArrayList;
import java.util.List;

import domain.CalculateImpact;
import domain.LifespanImpactCalculator;
import domain.Product;
import domain.ProductMaterial;
import domain.RecyclingCategory;
import domain.SimpleImpactCalculator;
import infrastructure.ProductStorage;

public class ProductService {

    private final List<Product> sessionProducts =
            new ArrayList<>();

    private final ProductStorage storage;

    private final CalculateImpact impactCalculator =
            new SimpleImpactCalculator();

    private final CalculateImpact lifespanCalculator =
            new LifespanImpactCalculator();

    public ProductService(ProductStorage storage) {
        this.storage = storage;
    }

    public CreateProductResult createProduct(
            CreateProductRequest request) {

        Product product =
                new Product(
                        request.getProductName(),
                        RecyclingCategory.MIXED,
                        0
                );

        for (ProductMaterial pm :
                request.getMaterials()) {

            product.addMaterial(pm);
        }

        double impact =
                impactCalculator.calculate(product);

        int lifespan =
                (int) lifespanCalculator.calculate(product);

        RecyclingCategory category =
                determineCategory(request.getMaterials());

        product.setCalculatedImpact(impact);
        product.setEstimatedLifespan(lifespan);
        product.setRecyclingCategory(category);

        sessionProducts.add(product);

        return new CreateProductResult(
                product.getProductType()
        );
    }

    private RecyclingCategory determineCategory(
            List<ProductMaterial> materials) {

        if (materials.isEmpty()) {
            return RecyclingCategory.MIXED;
        }

        RecyclingCategory first =
                materials.get(0)
                        .getMaterial()
                        .getCategory();

        for (ProductMaterial pm : materials) {

            if (pm.getMaterial().getCategory()
                    != first) {

                return RecyclingCategory.MIXED;
            }
        }

        return first;
    }

    public List<Product> getSessionProducts() {
        return sessionProducts;
    }

    public List<Product> getAllProducts() {
        return storage.findAll();
    }

    public Product findStoredProductByName(String name) {

        for (Product p : storage.findAll()) {

            if (p.getProductType()
                    .equalsIgnoreCase(name)) {

                return p;
            }
        }

        return null;
    }

    public void addProductToStorage(String name) {

        Product found = null;

        for (Product p : sessionProducts) {

            if (p.getProductType().equals(name)) {
                found = p;
                break;
            }
        }

        if (found != null) {

            storage.save(found);
            sessionProducts.remove(found);
        }
    }

    public void removeProductFromStorage(String name) {

        storage.deleteByName(name);
    }
}