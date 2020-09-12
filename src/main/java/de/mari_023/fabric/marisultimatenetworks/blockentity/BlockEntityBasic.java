package de.mari_023.fabric.marisultimatenetworks.blockentity;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import team.reborn.energy.EnergyStorage;
import team.reborn.energy.EnergyTier;

public abstract class BlockEntityBasic extends BlockEntity implements EnergyStorage {
    public BlockEntityBasic(BlockEntityType<?> type) {
        super(type);
    }

    @Override
    public void setStored(double v) {
    }

    @Override
    public double getMaxStoredPower() {
        return Double.MAX_VALUE;
    }

    @Override
    public EnergyTier getTier() {
        return EnergyTier.INFINITE;
    }
}
