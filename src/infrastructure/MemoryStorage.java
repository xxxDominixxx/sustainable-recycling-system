package infrastructure;

import domain.Product;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MemoryStorage implements ProductStorage {

    private final File file = new File("StorageFiles/products.txt");

    @Override
    public void save(Product product) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {

            writer.write(
                product.getProductName() + "|" +
                product.getProductCategory() + "|" +
                product.getEstimatedLifespan()
            );

            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();

        if (!file.exists()) return products;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\\|");

                Product product = new Product(
                    parts[0],
                    parts[1],
                    Integer.parseInt(parts[2])
                );

                products.add(product);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public void deleteByName(String name) {
        List<Product> products = findAll();
        List<Product> updated = new ArrayList<>();

        for (Product p : products) {
            if (!p.getProductName().equals(name)) {
                updated.add(p);
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {

            for (Product p : updated) {
                writer.write(
                    p.getProductName() + "|" +
                    p.getProductCategory() + "|" +
                    p.getEstimatedLifespan()
                );
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}