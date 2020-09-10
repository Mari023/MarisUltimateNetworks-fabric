package de.mari_023.fabric.marisultimatenetworks.blockentity;

import com.zundrel.wrenchable.block.BlockWrenchable;
import de.mari_023.fabric.marisultimatenetworks.MarisUltimateNetworks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import team.reborn.energy.EnergySide;
import team.reborn.energy.EnergyStorage;
import team.reborn.energy.EnergyTier;

public class EnergyInputBlockEntity extends BlockEntity implements EnergyStorage, BlockWrenchable {
    public EnergyInputBlockEntity() {
        super(MarisUltimateNetworks.EnergyInputBlockEntity);
    }

    @Override
    public double getStored(EnergySide energySide) {
        return Double.MAX_VALUE;
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

    @Override
    public void onWrenched(World world, PlayerEntity playerEntity, BlockHitResult blockHitResult) {
        world.breakBlock(blockHitResult.getBlockPos(), true);
    }
}
