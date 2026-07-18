package net.thanachot.superpickaxe.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.thanachot.superpickaxe.SuperPickaxe;

import java.util.ArrayList;
import java.util.List;

public class SuperPickaxeHelper {

    public static boolean isSuperPickaxe(ItemStack stack) {
        if (stack.isEmpty()) return false;

        CustomData customData = stack.get(DataComponents.CUSTOM_DATA);
        if (customData == null) return false;

        return customData.copyTag().getBoolean(SuperPickaxe.SUPER_PICKAXE_KEY).orElse(false);
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

    public static List<BlockPos> getBlockToBeDestroy(int range, BlockPos initBlockPos, ServerPlayer player) {
        List<BlockPos> positions = new ArrayList<>();
        HitResult hit = player.pick(20, 0, false);

        if (hit.getType() == HitResult.Type.BLOCK) {
            BlockHitResult hitResult = (BlockHitResult) hit;

            if (hitResult.getDirection() == Direction.DOWN || hitResult.getDirection() == Direction.UP) {
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

            if (hitResult.getDirection() == Direction.NORTH || hitResult.getDirection() == Direction.SOUTH) {
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

            if (hitResult.getDirection() == Direction.EAST || hitResult.getDirection() == Direction.WEST) {
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
