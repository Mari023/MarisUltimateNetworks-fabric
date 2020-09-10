package de.mari_023.fabric.marisultimatenetworks.blockentity;

import com.zundrel.wrenchable.block.BlockWrenchable;
import de.mari_023.fabric.marisultimatenetworks.MarisUltimateNetworks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Tickable;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import team.reborn.energy.Energy;
import team.reborn.energy.EnergySide;
import team.reborn.energy.EnergyStorage;
import team.reborn.energy.EnergyTier;

public class EnergyOutputBlockEntity extends BlockEntity implements EnergyStorage, Tickable, BlockWrenchable {
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
            Energy.of(blockEntity).set(Energy.of(blockEntity).getMaxStored());
        }
    }

    @Override
    public void onWrenched(World world, PlayerEntity playerEntity, BlockHitResult blockHitResult) {
        world.breakBlock(blockHitResult.getBlockPos(), true);
    }
}