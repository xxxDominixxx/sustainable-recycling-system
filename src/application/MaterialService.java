package application;

import domain.Material;
import domain.RecyclingCategory;
import domain.RecyclingGuidance;
import java.util.ArrayList;
import java.util.List;

public class MaterialService {

    private final List<Material> materials;

    public MaterialService() {
        materials = new ArrayList<>();
    }

    public void createMaterial(String materialName,
                               double impact,
                               RecyclingCategory category,
                               RecyclingGuidance guidance) {

        Material newMaterial = new Material(
                materialName,
                impact,
                category,
                guidance
                );

        materials.add(newMaterial);
    }

    public List<Material> getAllMaterials() {
        return materials;
    }

    public Material findMaterialByName(String materialName) {

        for (Material currentMaterial : materials) {
            if (currentMaterial.getMaterialName()
                    .equalsIgnoreCase(materialName)) {
                return currentMaterial;
            }
        }

        return null;
    }

    public boolean materialExists(String materialName) {
        return findMaterialByName(materialName) != null;
    }

    public boolean removeMaterialByName(String materialName) {

        for (int i = 0; i < materials.size(); i++) {
            Material currentMaterial = materials.get(i);

            if (currentMaterial.getMaterialName()
                    .equalsIgnoreCase(materialName)) {

                materials.remove(i);
                return true;
            }
        }

        return false;
    }
}