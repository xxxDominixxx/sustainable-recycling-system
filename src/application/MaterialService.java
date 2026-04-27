package application;

import domain.Material;
import java.util.ArrayList;
import java.util.List;

public class MaterialService {

    private List<Material> materials;

    public MaterialService() {
        materials = new ArrayList<>();
    }

    public void createMaterial(String materialName, String materialCategory, double impactValue, String recyclingCategory) {

        Material newMaterial = new Material(
                materialName,
                materialCategory,
                impactValue,
                recyclingCategory
        );

        materials.add(newMaterial);
    }

    public List<Material> getAllMaterials() {
        return materials;
    }

    public Material findMaterialByName(String materialName) {

        for (int i = 0; i < materials.size(); i++) {

            Material currentMaterial = materials.get(i);

            if (currentMaterial.getMaterialName()
                    .equalsIgnoreCase(materialName)) {

                return currentMaterial;
            }
        }

        return null;
    }

    public boolean materialExists(String materialName) {

        for (int i = 0; i < materials.size(); i++) {

            Material currentMaterial = materials.get(i);

            if (currentMaterial.getMaterialName()
                    .equalsIgnoreCase(materialName)) {

                return true;
            }
        }

        return false;
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