package net.thanachot.superpickaxe.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.thanachot.superpickaxe.SuperPickaxe;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        for (Item pickaxe : SuperPickaxe.PICKAXES) {
            String pickaxePath = BuiltInRegistries.ITEM.getKey(pickaxe).getPath();
            String materialName = pickaxePath.replace("_pickaxe", "");

            String superPickaxeName = "super_" + materialName + "_pickaxe";
            Identifier modelId = Identifier.fromNamespaceAndPath(SuperPickaxe.MOD_ID, "item/" + superPickaxeName);
            Identifier textureId = Identifier.fromNamespaceAndPath(SuperPickaxe.MOD_ID, "item/" + superPickaxeName);

            ModelTemplates.FLAT_HANDHELD_ITEM.create(
                    modelId,
                    TextureMapping.singleSlot(TextureSlot.LAYER0, new Material(textureId)),
                    itemModelGenerator.modelOutput);
        }
    }
}
