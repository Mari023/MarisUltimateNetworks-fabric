package de.mari_023.fabric.marisultimatenetworks.blocks;

import com.zundrel.wrenchable.block.BlockWrenchable;
import de.mari_023.fabric.marisultimatenetworks.blockentity.EnergyOutputBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class EnergyOutputBlock extends Block implements BlockEntityProvider, BlockWrenchable {
    public EnergyOutputBlock() {
        super(FabricBlockSettings.copy(Blocks.STONE));
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return new EnergyOutputBlockEntity();
    }

    @Override
    public void onWrenched(World world, PlayerEntity playerEntity, BlockHitResult blockHitResult) {
        world.breakBlock(blockHitResult.getBlockPos(), true);
    }
}