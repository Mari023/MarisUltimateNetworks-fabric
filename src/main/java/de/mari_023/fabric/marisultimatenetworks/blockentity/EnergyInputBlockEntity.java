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
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import team.reborn.energy.EnergySide;
import team.reborn.energy.EnergyStorage;
import team.reborn.energy.EnergyTier;

import java.util.UUID;

public class EnergyInputBlockEntity extends BlockEntity implements EnergyStorage, IWrenchAble {

    public UUID owner = new UUID(0, 0);

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