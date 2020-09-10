package de.mari_023.fabric.marisultimatenetworks.blockentity;

import de.mari_023.fabric.marisultimatenetworks.MarisUltimateNetworks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.Direction;
import team.reborn.energy.Energy;
import team.reborn.energy.EnergySide;
import team.reborn.energy.EnergyStorage;
import team.reborn.energy.EnergyTier;

public class EnergyOutputBlockEntity extends BlockEntity implements EnergyStorage, Tickable {
    public EnergyOutputBlockEntity() {
        super(MarisUltimateNetworks.EnergyOutputBlockEntity);
    }

    @Override
    public double getStored(EnergySide energySide) {
        return 0;
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

    public void tick() {
        if (getWorld() == null || getWorld().isClient) {
            return;
        }
        for (Direction side : Direction.values()) {
            BlockEntity blockEntity = getWorld().getBlockEntity(getPos().offset(side));
            if (blockEntity == null || !Energy.valid(blockEntity)) {
                continue;
            }
            Energy.of(this)
                    .side(side)
                    .into(
                            Energy.of(blockEntity).side(side.getOpposite())
                    )
                    .move();
        }
    }
}