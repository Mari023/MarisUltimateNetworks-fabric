package de.mari_023.fabric.marisultimatenetworks.blockentity;

import de.mari_023.fabric.marisultimatenetworks.MarisUltimateNetworks;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundTag;
import team.reborn.energy.EnergySide;

import java.util.UUID;

public class EnergyInputBlockEntity extends BlockEntityBasic {

    public UUID owner;

    public EnergyInputBlockEntity() {
        super(MarisUltimateNetworks.EnergyInputBlockEntity);
    }

    public double getStored(EnergySide energySide) {
        return 0;
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