package de.mari_023.fabric.marisultimatenetworks;

import de.mari_023.fabric.marisultimatenetworks.blockentity.EnergyInputBlockEntity;
import de.mari_023.fabric.marisultimatenetworks.blockentity.EnergyOutputBlockEntity;
import de.mari_023.fabric.marisultimatenetworks.blocks.EnergyInputBlock;
import de.mari_023.fabric.marisultimatenetworks.blocks.EnergyOutputBlock;
import de.mari_023.fabric.marisultimatenetworks.item.WrenchItem;
import de.mari_023.fabric.mariswrenchapi.IWrench;
import de.mari_023.fabric.mariswrenchapi.IWrenchAble;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.registry.Registry;

public class MarisUltimateNetworks implements ModInitializer {

    public static final Block EnergyInputBlock = new EnergyInputBlock();
    public static BlockEntityType<EnergyInputBlockEntity> EnergyInputBlockEntity;

    public static final Block EnergyOutputBlock = new EnergyOutputBlock();
    public static BlockEntityType<EnergyOutputBlockEntity> EnergyOutputBlockEntity;

    public static final Item Wrench = new WrenchItem();

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, new Identifier("marisultimatenetworks", "energyinputblock"), EnergyInputBlock);
        Registry.register(Registry.ITEM, new Identifier("marisultimatenetworks", "energyinputblock"), new BlockItem(EnergyInputBlock, new Item.Settings().group(ItemGroup.MISC)));
        EnergyInputBlockEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE, "marisultimatenetworks:energyinputblockentity", BlockEntityType.Builder.create(EnergyInputBlockEntity::new, EnergyInputBlock).build(null));

        Registry.register(Registry.BLOCK, new Identifier("marisultimatenetworks", "energyoutputblock"), EnergyOutputBlock);
        Registry.register(Registry.ITEM, new Identifier("marisultimatenetworks", "energyoutputblock"), new BlockItem(EnergyOutputBlock, new Item.Settings().group(ItemGroup.MISC)));
        EnergyOutputBlockEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE, "marisultimatenetworks:energyoutputblockentity", BlockEntityType.Builder.create(EnergyOutputBlockEntity::new, EnergyOutputBlock).build(null));

        Registry.register(Registry.ITEM, new Identifier("marisultimatenetworks", "wrench"), Wrench);

        initializeWrench();
    }

    public void initializeWrench() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (world.isClient) return ActionResult.PASS;
            if (!(player.getStackInHand(hand).getItem() instanceof IWrench)) return ActionResult.PASS;
            if (!hitResult.getType().equals(HitResult.Type.BLOCK))
                return ((IWrench) player.getStackInHand(hand).getItem()).wrench(player, world, hand, hitResult, false, false);
            BlockEntity blockEntity = world.getBlockEntity(hitResult.getBlockPos());
            if (blockEntity == null)
                return ((IWrench) player.getStackInHand(hand).getItem()).wrench(player, world, hand, hitResult, false, false);
            if (!(blockEntity instanceof IWrenchAble))
                return ((IWrench) player.getStackInHand(hand).getItem()).wrench(player, world, hand, hitResult, true, false);
            if (!player.isSneaking() &&
                    ((IWrenchAble) blockEntity).wrench(player, world, hand, hitResult).equals(ActionResult.PASS))
                return ((IWrench) player.getStackInHand(hand).getItem()).wrench(player, world, hand, hitResult, true, true);
            return ((IWrenchAble) blockEntity).wrenchSneaking(player, world, hand, hitResult);
        });
    }
}