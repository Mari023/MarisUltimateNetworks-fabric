package de.mari_023.fabric.mariswrenchapi;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

public interface IWrenchAble {
    ActionResult wrenchSneaking(PlayerEntity player, World world, Hand hand, BlockHitResult hitResult);

    ActionResult wrench(PlayerEntity player, World world, Hand hand, BlockHitResult hitResult);
}
