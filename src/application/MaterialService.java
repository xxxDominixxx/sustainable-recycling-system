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

        materials.add(new Material(
                "Wood", 
                0.31,
                RecyclingCategory.LOW,
                RecyclingGuidance.RECYCLE
        ));

        materials.add(new Material(
                "Virgin Aluminium",
                12.0,
                RecyclingCategory.HIGH,
                RecyclingGuidance.RECYCLE
        ));

        materials.add(new Material(
                "Virgin Steel",
                2.2,
                RecyclingCategory.HIGH,
                RecyclingGuidance.RECYCLE
        ));

        materials.add(new Material(
                "Paper",
                0.50,
                RecyclingCategory.MEDIUM,
                RecyclingGuidance.RECYCLE  
        ));

        materials.add(new Material(
                "Cotton Fabric",
                5.5,
                RecyclingCategory.LOW,
                RecyclingGuidance.REUSE
        ));

        materials.add(new Material(
                "HDPE Plastic",
                2.0,
                RecyclingCategory.MEDIUM,
                RecyclingGuidance.RECYCLE
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