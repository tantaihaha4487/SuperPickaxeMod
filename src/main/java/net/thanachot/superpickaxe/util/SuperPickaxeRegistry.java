package net.thanachot.superpickaxe.util;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.component.CustomData;
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
        return "superpickaxe_" + BuiltInRegistries.ITEM.getKey(pickaxe).getPath();
    }

    /**
     * Gets the model Identifier for a Super Pickaxe variant.
     * 
     * @param pickaxe The base pickaxe item
     * @return The model Identifier (e.g.,
     *         superpickaxe:superpickaxe_diamond_pickaxe)
     */
    public static Identifier getModel(Item pickaxe) {
        return Identifier.fromNamespaceAndPath(SuperPickaxe.MOD_ID, getItemId(pickaxe));
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
        ItemStack stack = pickaxe.getDefaultInstance();
        stack.applyComponents(createSuperPickaxeComponents(pickaxe));

        return stack;
    }

    /**
     * Creates the component-only recipe result used by 26.1 datagen.
     * ItemStack construction requires bound registry components during datagen,
     * while ItemStackTemplate can safely carry the same serialized result.
     *
     * @param pickaxe The base pickaxe item
     * @return A configured recipe result template
     */
    public static ItemStackTemplate createSuperPickaxeTemplate(Item pickaxe) {
        return new ItemStackTemplate(pickaxe, createSuperPickaxeComponents(pickaxe));
    }

    private static DataComponentPatch createSuperPickaxeComponents(Item pickaxe) {
        CompoundTag nbt = new CompoundTag();
        nbt.putBoolean(SuperPickaxe.SUPER_PICKAXE_KEY, true);

        return DataComponentPatch.builder()
                .set(DataComponents.CUSTOM_DATA, CustomData.of(nbt))
                .set(DataComponents.ITEM_MODEL, getModel(pickaxe))
                .set(DataComponents.CUSTOM_NAME,
                        Component.literal("Super " + Component.translatable(pickaxe.getDescriptionId()).getString()).setStyle(
                                Style.EMPTY
                                        .withColor(TextColor.fromRgb(0xFFD700))
                                        .withBold(true)))
                .build();
    }
}
