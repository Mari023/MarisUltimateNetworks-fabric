package de.mari_023.fabric.marisultimatenetworks.blockentity;

import de.mari_023.fabric.marisultimatenetworks.MarisUltimateNetworks;
import de.mari_023.fabric.mariswrenchapi.IWrenchAble;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Tickable;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import team.reborn.energy.Energy;
import team.reborn.energy.EnergySide;
import team.reborn.energy.EnergyStorage;
import team.reborn.energy.EnergyTier;

import java.util.UUID;

public class EnergyOutputBlockEntity extends BlockEntity implements EnergyStorage, Tickable, IWrenchAble {

    public UUID owner = new UUID(0, 0);

    public EnergyOutputBlockEntity() {
        super(MarisUltimateNetworks.EnergyOutputBlockEntity);
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

    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        tag.putUuid("owner", owner);
        return tag;
    }

    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        try {
            owner = tag.getUuid("owner");
        } catch (Exception ignored) {
        }
    }

    public ActionResult wrench(PlayerEntity player, World world, Hand hand, BlockHitResult hitResult) {
        if (owner.equals(new UUID(0, 0))) {
            owner = player.getUuid();
            player.sendMessage(Text.of("Set Owner to " + player.getName().asString()), false);
            return ActionResult.SUCCESS;
        } else {
            player.sendMessage(Text.of("Owner " + owner), true);
            return ActionResult.FAIL;
        }
    }

    public ActionResult wrenchSneaking(PlayerEntity player, World world, Hand hand, BlockHitResult hitResult) {
        ItemStack block = new ItemStack(world.getBlockState(hitResult.getBlockPos()).getBlock().asItem());
        CompoundTag tag = toTag(new CompoundTag()).copy();
        tag.remove("x");
        tag.remove("y");
        tag.remove("z");
        tag.remove("id");
        if (tag.getUuid("owner").equals(new UUID(0, 0))) tag.remove("owner");
        if (!tag.isEmpty()) block.setTag(tag);
        world.breakBlock(hitResult.getBlockPos(), false, player);
        world.spawnEntity(new ItemEntity(world, hitResult.getPos().getX(), hitResult.getPos().getY(), hitResult.getPos().getZ(), block));
        return ActionResult.SUCCESS;
    }
}