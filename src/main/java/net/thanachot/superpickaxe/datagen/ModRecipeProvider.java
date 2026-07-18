package net.thanachot.superpickaxe.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.recipe.v1.ingredient.DefaultCustomIngredients;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.thanachot.superpickaxe.SuperPickaxe;
import net.thanachot.superpickaxe.util.SuperPickaxeRegistry;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output,
            CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider wrapperLookup,
            RecipeOutput recipeExporter) {
        return new RecipeProvider(wrapperLookup, recipeExporter) {
            @Override
            public void buildRecipes() {
                for (Item pickaxe : SuperPickaxe.PICKAXES) {
                    Ingredient strictPickaxeInput = DefaultCustomIngredients.components(
                            Ingredient.of(pickaxe),
                            builder -> builder
                                    .set(DataComponents.DAMAGE, 0)
                                    .set(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY));

                    shapeless(RecipeCategory.TOOLS, SuperPickaxeRegistry.createSuperPickaxeStack(pickaxe))
                            .requires(strictPickaxeInput)
                            .requires(Items.NETHER_STAR)
                            .unlockedBy(getHasName(pickaxe), has(pickaxe))
                            .save(output, SuperPickaxeRegistry.getItemId(pickaxe));
                }
            }
        };
    }

    @Override
    public String getName() {
        return "Super Pickaxe Recipes";
    }
}
