package infrastructure;

import java.util.List;

import domain.Product;

public interface ProductStorage {
    void save(Product product);
    List<Product> findAll();
    void deleteByName(String name);
}