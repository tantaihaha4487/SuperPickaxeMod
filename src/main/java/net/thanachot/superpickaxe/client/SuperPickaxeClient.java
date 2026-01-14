package net.thanachot.superpickaxe.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.thanachot.superpickaxe.SuperPickaxe;
import net.thanachot.superpickaxe.util.SuperPickaxeRegistry;

public class SuperPickaxeClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerCreativeTabItems();
    }

    private void registerCreativeTabItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            for (Item pickaxe : SuperPickaxe.PICKAXES) {
                content.addAfter(pickaxe, SuperPickaxeRegistry.createSuperPickaxeStack(pickaxe));
            }
        });
    }
}
