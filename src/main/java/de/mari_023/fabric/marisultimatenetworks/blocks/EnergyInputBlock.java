package de.mari_023.fabric.marisultimatenetworks.blocks;

import de.mari_023.fabric.marisultimatenetworks.blockentity.EnergyInputBlockEntity;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class EnergyInputBlock extends BlockBasic implements BlockEntityProvider {

    private final EnergyInputBlockEntity blockEntity = new EnergyInputBlockEntity();

    public EnergyInputBlock() {
        super();
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return blockEntity;
    }

    public ActionResult wrench(PlayerEntity player, World world, Hand hand, BlockHitResult hitResult) {
        if (blockEntity.owner == null) {
            blockEntity.owner = player.getUuid();
            player.sendMessage(Text.of("Set Owner to " + player.getName()), true);
            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;
    }
}