package application.repository;

import domain.Material;
import java.util.List;
import java.util.Optional;

public interface MaterialRepository {
    void save(Material material);
    List<Material> findAll();
    Optional<Material> findByName(String name);
}