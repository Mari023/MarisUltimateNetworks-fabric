package de.mari_023.fabric.marisultimatenetworks.blockentity;

import de.mari_023.fabric.marisultimatenetworks.MarisUltimateNetworks;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundTag;
import team.reborn.energy.EnergySide;

public class EnergyInputBlockEntity extends BlockEntityBasic {
    public EnergyInputBlockEntity() {
        super(MarisUltimateNetworks.EnergyInputBlockEntity);
    }

    public double getStored(EnergySide energySide) {
        return 0;
    }

    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);

        return tag;
    }

    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
    }
}