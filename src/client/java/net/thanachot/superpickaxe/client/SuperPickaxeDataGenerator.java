package net.thanachot.superpickaxe.client;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.thanachot.superpickaxe.datagen.ModModelProvider;
import net.thanachot.superpickaxe.datagen.ModRecipeProvider;

public class SuperPickaxeDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider((FabricDataGenerator.Pack.Factory<ModModelProvider>) ModModelProvider::new);
        pack.addProvider((FabricDataGenerator.Pack.RegistryDependentFactory<ModRecipeProvider>) ModRecipeProvider::new);
    }
}
