package net.thanachot.superpickaxe.event;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
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
    public boolean beforeBlockBreak(Level world, Player playerEntity, BlockPos blockPos, BlockState blockState, @Nullable BlockEntity blockEntity) {

        if (world.isClientSide()) return true; // Process on Server

        ItemStack heldItem = playerEntity.getMainHandItem();

        if (SuperPickaxeHelper.isSuperPickaxe(heldItem) && playerEntity instanceof ServerPlayer serverPLayer) {
            if (HARVESTED_BLOCKS.contains(blockPos)) return true; // Prevent recursive breaking

            // Get blocks to destroy (range 1 = 3x3)
            for (BlockPos targetPos : SuperPickaxeHelper.getBlockToBeDestroy(1, blockPos, serverPLayer)) {
                if (blockPos.equals(targetPos) || !heldItem.isCorrectToolForDrops(world.getBlockState(targetPos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(targetPos);
                serverPLayer.gameMode.destroyBlock(targetPos);
                HARVESTED_BLOCKS.remove(targetPos);
            }
        }

        return true;
    }
}
