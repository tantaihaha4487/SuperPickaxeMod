package net.thanachot.superpickaxe;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.thanachot.superpickaxe.event.SuperPickaxeUsage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SuperPickaxe implements ModInitializer {

    public static final String MOD_ID = "superpickaxe";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // NBT Key
    public static final String SUPER_PICKAXE_KEY = "SuperPickaxe";

    public static final List<Item> PICKAXES = List.of(
            Items.WOODEN_PICKAXE,
            Items.STONE_PICKAXE,
            Items.GOLDEN_PICKAXE,
            Items.IRON_PICKAXE,
            Items.DIAMOND_PICKAXE,
            Items.NETHERITE_PICKAXE
    );

    @Override
    public void onInitialize() {
        SuperPickaxeUsage.register();
    }
}
