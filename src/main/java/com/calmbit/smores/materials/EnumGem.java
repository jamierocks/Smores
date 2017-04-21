package com.calmbit.smores.materials;

import net.minecraft.util.IStringSerializable;

import java.util.Locale;

public enum EnumGem implements IStringSerializable {
    RUBY("Ruby", 0),
    SAPPHIRE("Sapphire", 1),
    PERIDOT("Peridot", 2);

    private String materialName;
    private int id;

    EnumGem(String materialName, int id) {
        this.materialName = materialName;
        this.id = id;
    }

    public String getName() {
        return this.materialName.toLowerCase(Locale.ROOT);
    }

    public String getMaterialName() {
        return this.materialName;
    }


    public int getId() {
        return id;
    }

    public EnumItem[] getTypes() {
        return new EnumItem[]{EnumItem.GEM, EnumItem.ORE};
    }
}