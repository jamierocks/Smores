/*
 * The MIT License (MIT)
 * =====================
 *
 * Copyright © 2017:
 *  Ethan Brooks (CalmBit),
 *  Isaac Ellingson (Falkreon),
 *  and contributors
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the “Software”), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

package com.elytradev.smores.items;

import com.elytradev.smores.Smores;
import com.elytradev.smores.generic.IOreDict;
import com.elytradev.smores.materials.EnumGem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Locale;


public class ItemGem extends ItemBase implements IOreDict {
    private static ArrayList<String> materials;

    public ItemGem() {
        super("gem");
        this.setMaxDamage(0);
        this.setHasSubtypes(true);

        if(materials == null) {
            materials = new ArrayList<String>();
            for(EnumGem gem : EnumGem.values()) {
                materials.add(gem.getMaterialName());
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems) {
        for(String material : materials) {
            subItems.add(new ItemStack(this, 1, materials.indexOf(material)));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName(stack) + "_" + materials.get(stack.getItemDamage()).toLowerCase(Locale.ROOT);
    }

    @Override
    public void registerOreDict() {
        for(String material : materials) {
            OreDictionary.registerOre("gem"+material, new ItemStack(this, 1, materials.indexOf(material)));
        }
    }

    @Override
    public void registerItemModel()
    {
        for(String material : materials) {
            Smores.proxy.registerItemRenderer(this, materials.indexOf(material), "gem_" + material.toLowerCase(Locale.ROOT));
        }
    }
}
