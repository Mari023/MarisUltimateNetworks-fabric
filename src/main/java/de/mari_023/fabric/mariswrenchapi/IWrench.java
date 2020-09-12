package de.mari_023.fabric.mariswrenchapi;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public interface IWrench {
    ActionResult wrench(PlayerEntity player, World world, Hand hand, HitResult hitResult, boolean hitblock);
}
