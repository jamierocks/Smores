package com.calmbit.smores.materials;

public enum EnumAlloyType{

    ELECTRUM("Electrum"),
    INVAR("Invar"),
    STEEL("Steel"),
    BRONZE("Bronze"),
    BRASS("Brass");

    private String materialName;

    EnumAlloyType(String materialName) {
       this.materialName = materialName;
    }

    public String getName() {
        return this.materialName;
    }



}
