package net.thanachot.superpickaxe.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.recipe.v1.ingredient.DefaultCustomIngredients;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.RecipeUnlockAdvancementBuilder;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.item.crafting.ShapedRecipePattern;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.advancements.triggers.Criterion;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import net.thanachot.superpickaxe.SuperPickaxe;
import net.thanachot.superpickaxe.util.SuperPickaxeRegistry;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricPackOutput output,
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

                    new ShapedTemplateRecipeBuilder(RecipeCategory.TOOLS,
                            SuperPickaxeRegistry.createSuperPickaxeTemplate(pickaxe))
                            .pattern("PPP")
                            .pattern(" S ")
                            .pattern(" S ")
                            .define('P', strictPickaxeInput)
                            .define('S', Items.STICK)
                            .unlockedBy(getHasName(pickaxe), has(pickaxe))
                            .save(output, ResourceKey.create(Registries.RECIPE,
                                    Identifier.fromNamespaceAndPath(SuperPickaxe.MOD_ID,
                                            SuperPickaxeRegistry.getItemId(pickaxe))));
                }
            }
        };
    }

    @Override
    public String getName() {
        return "Super Pickaxe Recipes";
    }

    /** Minecraft 26.2 exposes ItemStackTemplate only for shapeless builders. */
    private static final class ShapedTemplateRecipeBuilder implements RecipeBuilder {
        private final RecipeCategory category;
        private final net.minecraft.world.item.ItemStackTemplate result;
        private final Map<Character, Ingredient> key = new LinkedHashMap<>();
        private final List<String> rows = new java.util.ArrayList<>();
        private final RecipeUnlockAdvancementBuilder advancement = new RecipeUnlockAdvancementBuilder();
        private String group = "";

        private ShapedTemplateRecipeBuilder(RecipeCategory category,
                net.minecraft.world.item.ItemStackTemplate result) {
            this.category = category;
            this.result = result;
        }

        private ShapedTemplateRecipeBuilder pattern(String row) {
            rows.add(row);
            return this;
        }

        private ShapedTemplateRecipeBuilder define(char symbol, Ingredient ingredient) {
            key.put(symbol, ingredient);
            return this;
        }

        private ShapedTemplateRecipeBuilder define(char symbol, Item item) {
            return define(symbol, Ingredient.of(item));
        }

        @Override
        public ShapedTemplateRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
            advancement.unlockedBy(name, criterion);
            return this;
        }

        @Override
        public ShapedTemplateRecipeBuilder group(String group) {
            this.group = group;
            return this;
        }

        @Override
        public ResourceKey<Recipe<?>> defaultId() {
            return RecipeBuilder.getDefaultRecipeId(result);
        }

        @Override
        public void save(RecipeOutput output, ResourceKey<Recipe<?>> recipeId) {
            ShapedRecipePattern pattern = ShapedRecipePattern.of(key, rows);
            CraftingRecipe.CraftingBookInfo bookInfo = new CraftingRecipe.CraftingBookInfo(
                    RecipeBuilder.determineCraftingBookCategory(category), group);
            ShapedRecipe recipe = new ShapedRecipe(new Recipe.CommonInfo(true), bookInfo, pattern, result);
            output.accept(recipeId, recipe, advancement.build(output, recipeId, category));
        }
    }
}
