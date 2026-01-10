package net.thanachot.superpickaxe.event;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thanachot.superpickaxe.util.SuperPickaxeHelper;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class SuperPickaxeUsage implements PlayerBlockBreakEvents.Before {

    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    public static void register() {
        PlayerBlockBreakEvents.BEFORE.register(new SuperPickaxeUsage());
    }

    @Override
    public boolean beforeBlockBreak(World world, PlayerEntity playerEntity, BlockPos blockPos, BlockState blockState, @Nullable BlockEntity blockEntity) {

        if (world.isClient()) return true; // Process on Server

        ItemStack heldItem = playerEntity.getMainHandStack();

        if (SuperPickaxeHelper.isSuperPickaxe(heldItem) && playerEntity instanceof ServerPlayerEntity serverPLayer) {
            if (HARVESTED_BLOCKS.contains(blockPos)) return true; // Prevent recursive breaking

            // Get blocks to destroy (range 1 = 3x3)
            for (BlockPos targetPos : SuperPickaxeHelper.getBlockToBeDestroy(1, blockPos, serverPLayer)) {
                if (blockPos.equals(targetPos) || !heldItem.isSuitableFor(world.getBlockState(targetPos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(targetPos);
                serverPLayer.interactionManager.tryBreakBlock(targetPos);
                HARVESTED_BLOCKS.remove(targetPos);
            }
        }

        return true;
    }
}
