package de.mari_023.fabric.marisultimatenetworks.blockentity;

import de.mari_023.fabric.marisultimatenetworks.MarisUltimateNetworks;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;
import team.reborn.energy.EnergySide;
import team.reborn.energy.EnergyStorage;
import team.reborn.energy.EnergyTier;

import java.util.UUID;

public class EnergyInputBlockEntity extends BlockEntity implements EnergyStorage {

    public UUID owner;

    public EnergyInputBlockEntity() {
        super(MarisUltimateNetworks.EnergyInputBlockEntity);
    }

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

    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        tag.putUuid("owner", owner);
        return tag;
    }

    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        owner = tag.getUuid("owner");
    }
}