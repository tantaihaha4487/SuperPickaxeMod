package net.thanachot.superpickaxe.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.thanachot.superpickaxe.SuperPickaxe;
import net.thanachot.superpickaxe.util.SuperPickaxeRegistry;

public class SuperPickaxeClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerCreativeTabItems();
    }

    private void registerCreativeTabItems() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(content -> {
            for (Item pickaxe : SuperPickaxe.PICKAXES) {
                content.addAfter(pickaxe, SuperPickaxeRegistry.createSuperPickaxeStack(pickaxe));
            }
        });
    }
}
