package de.mari_023.fabric.marisultimatenetworks.blocks;

import de.mari_023.fabric.marisultimatenetworks.blockentity.EnergyInputBlockEntity;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.world.BlockView;

public class EnergyInputBlock extends BlockBasic implements BlockEntityProvider {
    public EnergyInputBlock() {
        super();
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new EnergyInputBlockEntity();
    }
}