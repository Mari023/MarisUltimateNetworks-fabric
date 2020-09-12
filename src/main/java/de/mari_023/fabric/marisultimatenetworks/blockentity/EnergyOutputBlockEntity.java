package de.mari_023.fabric.marisultimatenetworks.blockentity;

import de.mari_023.fabric.marisultimatenetworks.MarisUltimateNetworks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.Direction;
import team.reborn.energy.Energy;
import team.reborn.energy.EnergySide;

public class EnergyOutputBlockEntity extends BlockEntityBasic implements Tickable {
    public EnergyOutputBlockEntity() {
        super(MarisUltimateNetworks.EnergyOutputBlockEntity);
    }

    @Override
    public double getStored(EnergySide energySide) {
        return Double.MAX_VALUE;
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
            Energy.of(blockEntity).set(Energy.of(blockEntity).getMaxStored());
        }
    }
}