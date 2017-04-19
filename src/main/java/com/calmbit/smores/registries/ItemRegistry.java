package com.calmbit.smores.registries;

import com.calmbit.smores.Smores;
import com.calmbit.smores.generic.IOreDict;
import com.calmbit.smores.items.ItemBase;
import com.calmbit.smores.items.ItemDust;
import com.calmbit.smores.items.ItemIngot;
import com.calmbit.smores.items.ItemPlate;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRegistry {


    public static ItemBase itemIngot;
    public static ItemBase itemDust;
    public static ItemBase itemPlate;

    public static void init()
    {
        itemIngot = registerItem(new ItemIngot()).setCreativeTab(Smores.smoresCreativeTab);
        itemDust = registerItem(new ItemDust()).setCreativeTab(Smores.smoresCreativeTab);
        itemPlate = registerItem(new ItemPlate()).setCreativeTab(Smores.smoresCreativeTab);
    }

    private static <T extends Item> T registerItem(T item)
    {
        GameRegistry.register(item);

        if(item instanceof ItemBase)
        {
            ((ItemBase)item).registerItemModel();
        }
        if(item instanceof IOreDict)
        {
            ((IOreDict)item).registerOreDict();
        }
        return item;
    }
}
