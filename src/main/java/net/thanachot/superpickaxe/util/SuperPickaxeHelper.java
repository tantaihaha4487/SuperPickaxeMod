package net.thanachot.superpickaxe.util;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.thanachot.superpickaxe.SuperPickaxe;

import java.util.ArrayList;
import java.util.List;

public class SuperPickaxeHelper {

    public static boolean isSuperPickaxe(ItemStack stack) {
        if (stack.isEmpty()) return false;

        NbtComponent customData = stack.get(DataComponentTypes.CUSTOM_DATA);
        if (customData == null) return false;

        return customData.copyNbt().getBoolean(SuperPickaxe.SUPER_PICKAXE_KEY).orElse(false);
    }

    /**
     * Gets the blocks to be destroyed in a range around the initial block position.
     * Uses raycast to determine the face being mined and calculates positions
     * accordingly.
     *
     * @param range        The range (1 = 3x3, 2 = 5x5, etc.)
     * @param initBlockPos The center block position
     * @param player       The server player performing the action
     * @return List of BlockPos to destroy
     */

    public static List<BlockPos> getBlockToBeDestroy(int range, BlockPos initBlockPos, ServerPlayerEntity player) {
        List<BlockPos> positions = new ArrayList<>();
        HitResult hit = player.raycast(20, 0, false);

        if (hit.getType() == HitResult.Type.BLOCK) {
            BlockHitResult hitResult = (BlockHitResult) hit;

            if (hitResult.getSide() == Direction.DOWN || hitResult.getSide() == Direction.UP) {
                for (int x = -range; x <= range; x++) {
                    for (int z = -range; z <= range; z++) {
                        positions.add(new BlockPos(
                                initBlockPos.getX() + x,
                                initBlockPos.getY(),
                                initBlockPos.getZ() + z
                        ));
                    }
                }
            }

            if (hitResult.getSide() == Direction.NORTH || hitResult.getSide() == Direction.SOUTH) {
                for (int x = -range; x <= range; x++) {
                    for (int y = -range; y <= range; y++) {
                        positions.add(new BlockPos(
                                initBlockPos.getX() + x,
                                initBlockPos.getY() + y,
                                initBlockPos.getZ()
                        ));
                    }
                }
            }

            if (hitResult.getSide() == Direction.EAST || hitResult.getSide() == Direction.WEST) {
                for (int y = -range; y <= range; y++) {
                    for (int z = -range; z <= range; z++) {
                        positions.add(new BlockPos(
                                initBlockPos.getX(),
                                initBlockPos.getY() + y,
                                initBlockPos.getZ() + z
                        ));
                    }
                }
            }

        }
        return positions;
    }

}
