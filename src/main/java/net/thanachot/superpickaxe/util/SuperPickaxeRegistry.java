package net.thanachot.superpickaxe.util;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.thanachot.superpickaxe.SuperPickaxe;

/**
 * Shared utility class for creating Super Pickaxe items.
 * Used by both recipe generation and client-side Creative Tab registration.
 */
public class SuperPickaxeRegistry {

    /**
     * Gets the item ID for a Super Pickaxe variant.
     * 
     * @param pickaxe The base pickaxe item
     * @return The item ID string (e.g., "superpickaxe_diamond_pickaxe")
     */
    public static String getItemId(Item pickaxe) {
        return "superpickaxe_" + Registries.ITEM.getId(pickaxe).getPath();
    }

    /**
     * Gets the model Identifier for a Super Pickaxe variant.
     * 
     * @param pickaxe The base pickaxe item
     * @return The model Identifier (e.g.,
     *         superpickaxe:superpickaxe_diamond_pickaxe)
     */
    public static Identifier getModel(Item pickaxe) {
        return Identifier.of(SuperPickaxe.MOD_ID, getItemId(pickaxe));
    }

    /**
     * Creates a fully configured Super Pickaxe ItemStack with:
     * - NBT data marking it as a Super Pickaxe
     * - Custom model reference
     * - Styled custom name (gold, bold)
     *
     * @param pickaxe The base pickaxe item
     * @return A configured Super Pickaxe ItemStack
     */
    public static ItemStack createSuperPickaxeStack(Item pickaxe) {
        ItemStack stack = pickaxe.getDefaultStack();
        NbtCompound nbt = new NbtCompound();
        nbt.putBoolean(SuperPickaxe.SUPER_PICKAXE_KEY, true);
        stack.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(nbt));

        stack.set(DataComponentTypes.ITEM_MODEL, getModel(pickaxe));
        stack.set(DataComponentTypes.CUSTOM_NAME,
                Text.literal("Super " + pickaxe.getName().getString()).setStyle(
                        Style.EMPTY
                                .withColor(TextColor.fromRgb(0xFFD700))
                                .withBold(true)));

        return stack;
    }
}
