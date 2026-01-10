package net.thanachot.superpickaxe.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.client.data.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.thanachot.superpickaxe.SuperPickaxe;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        for (Item pickaxe : SuperPickaxe.PICKAXES) {
            String pickaxePath = Registries.ITEM.getId(pickaxe).getPath();
            String materialName = pickaxePath.replace("_pickaxe", "");

            String superPickaxeName = "super_" + materialName + "_pickaxe";
            Identifier modelId = Identifier.of(SuperPickaxe.MOD_ID, "item/" + superPickaxeName);
            Identifier textureId = Identifier.of(SuperPickaxe.MOD_ID, "item/" + superPickaxeName);

            Models.HANDHELD.upload(
                    modelId,
                    TextureMap.layer0(textureId),
                    itemModelGenerator.modelCollector);
        }
    }
}
