package de.mari_023.fabric.marisultimatenetworks.item;

import de.mari_023.fabric.mariswrenchapi.IWrench;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class WrenchItem extends Item implements IWrench {
    public WrenchItem() {
        super(new Settings().group(ItemGroup.MISC));
    }

    @Override
    public ActionResult wrench(PlayerEntity player, World world, Hand hand, HitResult hitResult, boolean hitblock, boolean isWrenchable) {
        player.sendMessage(Text.of("Wrenchmode"), true);
        return ActionResult.PASS;
    }
}