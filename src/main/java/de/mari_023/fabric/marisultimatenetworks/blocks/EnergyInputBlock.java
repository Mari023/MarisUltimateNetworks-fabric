package de.mari_023.fabric.marisultimatenetworks.blocks;

import de.mari_023.fabric.marisultimatenetworks.blockentity.EnergyInputBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;

public class EnergyInputBlock extends Block implements BlockEntityProvider {
    public EnergyInputBlock() {
        super(FabricBlockSettings.copy(Blocks.STONE));
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new EnergyInputBlockEntity();
    }
}