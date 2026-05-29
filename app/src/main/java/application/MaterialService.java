package application;

import java.util.ArrayList;
import java.util.List;

import domain.RecyclingCategory;
import domain.RecyclingGuidance;
import domain.Material;

public class MaterialService {

    private final List<Material> materials;

    public MaterialService() {
        materials = new ArrayList<>();

        materials.add(new Material(
                "Wood", 
                0.31,
                RecyclingCategory.LOW,
                new RecyclingGuidance("Recycle at appropriate station")
        ));

        materials.add(new Material(
                "Virgin Aluminium",
                12.0,
                RecyclingCategory.HIGH,
                new RecyclingGuidance("Recycle at metal facility")
        ));

        materials.add(new Material(
                "Virgin Steel",
                2.2,
                RecyclingCategory.HIGH,
                new RecyclingGuidance("Recycle at industrial metal")
        ));

        materials.add(new Material(
                "Paper",
                0.50,
                RecyclingCategory.MEDIUM,
                new RecyclingGuidance("Reycle at paper waste")
        ));

        materials.add(new Material(
                "Cotton Fabric",
                5.5,
                RecyclingCategory.LOW,
                new RecyclingGuidance("Reuse or donate if possible")
        ));

        materials.add(new Material(
                "HDPE Plastic",
                2.0,
                RecyclingCategory.MEDIUM,
                new RecyclingGuidance("Recycle plastic correctly")
        ));
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
}