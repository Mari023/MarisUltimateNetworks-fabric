package de.mari_023.fabric.marisultimatenetworks.blocks;

import de.mari_023.fabric.mariswrenchapi.IWrenchAble;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

public abstract class BlockBasic extends Block implements IWrenchAble {

    public BlockBasic() {
        super(FabricBlockSettings.copy(Blocks.STONE));
    }

    public ActionResult wrenchSneaking(PlayerEntity player, World world, Hand hand, BlockHitResult hitResult) {
        ItemStack block = new ItemStack(world.getBlockState(hitResult.getBlockPos()).getBlock().asItem());
        block.setTag(toTag(new CompoundTag()));
        world.breakBlock(hitResult.getBlockPos(), false, player);
        world.spawnEntity(new ItemEntity(world, hitResult.getPos().getX(), hitResult.getPos().getY(), hitResult.getPos().getZ(), block));
        return ActionResult.SUCCESS;
    }

    public abstract CompoundTag toTag(CompoundTag tag);

    public ActionResult wrench(PlayerEntity player, World world, Hand hand, BlockHitResult hitResult) {
        return ActionResult.PASS;
    }
}