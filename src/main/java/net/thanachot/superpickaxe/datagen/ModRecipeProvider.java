package net.thanachot.superpickaxe.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.recipe.v1.ingredient.DefaultCustomIngredients;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.thanachot.superpickaxe.SuperPickaxe;

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
                    var recipeHelper = new SuperPickaxeRecipeHelper(pickaxe);

                    Ingredient strictPickaxeInput = DefaultCustomIngredients.components(
                            Ingredient.ofItems(pickaxe),
                            builder -> builder
                                    .add(DataComponentTypes.DAMAGE, 0)
                                    .add(DataComponentTypes.ENCHANTMENTS, ItemEnchantmentsComponent.DEFAULT)
                    );

                    createShapeless(RecipeCategory.TOOLS, recipeHelper.getResultStack())
                            .input(strictPickaxeInput) // <--- USE THE STRICT INGREDIENT HERE
                            .input(Items.NETHER_STAR)
                            .criterion(hasItem(pickaxe), conditionsFromItem(pickaxe))
                            .offerTo(exporter, recipeHelper.getItemID());
                }
            }
        };
    }

    @Override
    public String getName() {
        return "Super Pickaxe Recipes";
    }

    static class SuperPickaxeRecipeHelper {

        private final Item pickaxe;
        private final String itemID;

        SuperPickaxeRecipeHelper(Item pickaxe) {
            this.pickaxe = pickaxe;
            this.itemID = "superpickaxe_" + Registries.ITEM.getId(pickaxe).getPath();
        }

        public ItemStack getResultStack() {

            NbtCompound nbt = new NbtCompound();
            nbt.putBoolean("SuperPickaxe", true);

            ItemStack resultStack = pickaxe.getDefaultStack();
            resultStack.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(nbt));
            resultStack.set(DataComponentTypes.ITEM_MODEL, Identifier.of(SuperPickaxe.MOD_ID, itemID));
            resultStack.set(DataComponentTypes.CUSTOM_NAME,
                    Text.literal("Super " + pickaxe.getName().getString()).setStyle(
                            Style.EMPTY
                                    .withColor(TextColor.fromRgb(0xFFD700))
                                    .withBold(true)));

            return resultStack;
        }

        public String getItemID() {
            return itemID;
        }
    }
}
