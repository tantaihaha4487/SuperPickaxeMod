package net.thanachot.superpickaxe.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
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
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(content -> {
            for (Item pickaxe : SuperPickaxe.PICKAXES) {
                content.insertAfter(pickaxe, SuperPickaxeRegistry.createSuperPickaxeStack(pickaxe));
            }
        });
    }
}
