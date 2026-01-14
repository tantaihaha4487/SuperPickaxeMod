package net.thanachot.superpickaxe.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.recipe.v1.ingredient.DefaultCustomIngredients;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.thanachot.superpickaxe.SuperPickaxe;
import net.thanachot.superpickaxe.util.SuperPickaxeRegistry;
import net.minecraft.item.Items;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output,
            CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup,
            RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                for (Item pickaxe : SuperPickaxe.PICKAXES) {
                    Ingredient strictPickaxeInput = DefaultCustomIngredients.components(
                            Ingredient.ofItems(pickaxe),
                            builder -> builder
                                    .add(DataComponentTypes.DAMAGE, 0)
                                    .add(DataComponentTypes.ENCHANTMENTS, ItemEnchantmentsComponent.DEFAULT));

                    createShapeless(RecipeCategory.TOOLS, SuperPickaxeRegistry.createSuperPickaxeStack(pickaxe))
                            .input(strictPickaxeInput)
                            .input(Items.NETHER_STAR)
                            .criterion(hasItem(pickaxe), conditionsFromItem(pickaxe))
                            .offerTo(exporter, SuperPickaxeRegistry.getItemId(pickaxe));
                }
            }
        };
    }

    @Override
    public String getName() {
        return "Super Pickaxe Recipes";
    }
}
