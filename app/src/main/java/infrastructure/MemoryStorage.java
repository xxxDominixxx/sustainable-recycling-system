package infrastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import domain.Material;
import domain.Product;
import domain.ProductMaterial;
import domain.RecyclingCategory;
import application.MaterialService;

public class MemoryStorage implements ProductStorage {

    private final File file =
            new File("StorageFiles/products.txt");

    private final MaterialService materialService =
            new MaterialService();

    @Override
    public void save(Product product) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(file, true))) {

            StringBuilder sb = new StringBuilder();

            sb.append(product.getProductName()).append("|");
            sb.append(product.getRecyclingCategory()).append("|");
            sb.append(product.getEstimatedLifespan()).append("|");
            sb.append(product.getCalculatedImpact()).append("|");

            // materials: name:percentage;name:percentage
            for (ProductMaterial pm : product.getMaterials()) {

                sb.append(pm.getMaterial().getMaterialName())
                  .append(":")
                  .append(pm.getPercentage())
                  .append(";");
            }

            writer.write(sb.toString());
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {

        List<Product> products = new ArrayList<>();

        if (!file.exists()) return products;

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\\|");

                String name = parts[0];

                RecyclingCategory category =
                        RecyclingCategory.valueOf(parts[1]);

                int lifespan =
                        Integer.parseInt(parts[2]);

                double impact =
                        Double.parseDouble(parts[3]);

                Product product =
                        new Product(name, category, lifespan);

                product.setCalculatedImpact(impact);

                // MATERIALS
                if (parts.length > 4 && !parts[4].isEmpty()) {

                    String[] mats =
                            parts[4].split(";");

                    for (String m : mats) {

                        if (m.isEmpty()) continue;

                        String[] mParts = m.split(":");

                        String matName = mParts[0];
                        double percentage =
                                Double.parseDouble(mParts[1]);

                        Material material =
                                materialService.findMaterialByName(matName);

                        if (material != null) {

                            product.addMaterial(
                                    new ProductMaterial(
                                            material,
                                            percentage
                                    )
                            );
                        }
                    }
                }

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

            if (!p.getProductName().equalsIgnoreCase(name)) {
                updated.add(p);
            }
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(file, false))) {

            for (Product p : updated) {

                save(p); // reuse save logic indirectly
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}