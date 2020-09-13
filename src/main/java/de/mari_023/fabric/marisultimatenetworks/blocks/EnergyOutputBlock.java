package de.mari_023.fabric.marisultimatenetworks.blocks;

import de.mari_023.fabric.marisultimatenetworks.blockentity.EnergyOutputBlockEntity;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.BlockView;

public class EnergyOutputBlock extends BlockBasic implements BlockEntityProvider {

    private final EnergyOutputBlockEntity blockEntity = new EnergyOutputBlockEntity();

    public EnergyOutputBlock() {
        super();
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return blockEntity;
    }

    public CompoundTag toTag(CompoundTag tag) {
        return blockEntity.toTag(tag);
    }
}