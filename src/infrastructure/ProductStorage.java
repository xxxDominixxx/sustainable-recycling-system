package infrastructure;

import domain.Product;
import java.util.List;

public interface ProductStorage {
    void save(Product product);
    List<Product> findAll();
    void deleteByName(String name);
}