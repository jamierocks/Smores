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

package com.elytradev.smores.imc;

import com.elytradev.smores.Smores;
import net.minecraft.item.crafting.IRecipe;

import java.util.HashMap;

public class RecipeVoteCandidate {
    private static HashMap<String, RecipeVoteCandidate> RECIPE_CANDIDATES = new HashMap<>();

    public String recipeName;
    public IRecipe recipeImpl;

    public RecipeVoteCandidate(String recipeName, IRecipe recipeImpl) {
        this.recipeName = recipeName;
        this.recipeImpl = recipeImpl;
    }

    public static void registerRecipeCandidate(RecipeVoteCandidate candidate) {
        RECIPE_CANDIDATES.put(candidate.recipeName, candidate);
    }

    public static RecipeVoteCandidate getRecipeCandidate(String recipeName) {
        if(!RECIPE_CANDIDATES.containsKey(recipeName)) {
            Smores.LOG.error("RecipeVoteCandidate error - cannot find candidate with name " + recipeName);
            return null;
        }

        return RECIPE_CANDIDATES.get(recipeName);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof  RecipeVoteCandidate) {
            return ((RecipeVoteCandidate)obj).recipeName == this.recipeName;
        }
        return false;
    }
}
