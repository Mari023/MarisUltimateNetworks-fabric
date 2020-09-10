package de.mari_023.fabric.marisultimatenetworks;

import de.mari_023.fabric.marisultimatenetworks.blockentity.EnergyInputBlockEntity;
import de.mari_023.fabric.marisultimatenetworks.blockentity.EnergyOutputBlockEntity;
import de.mari_023.fabric.marisultimatenetworks.blocks.EnergyInputBlock;
import de.mari_023.fabric.marisultimatenetworks.blocks.EnergyOutputBlock;
import de.mari_023.fabric.marisultimatenetworks.item.WrenchItem;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
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
    }
}