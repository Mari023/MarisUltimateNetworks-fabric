package de.mari_023.fabric.marisultimatenetworks;

import de.mari_023.fabric.marisultimatenetworks.blocks.EnergyInputBlock;
import de.mari_023.fabric.marisultimatenetworks.blocks.EnergyOutputBlock;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MarisUltimateNetworks implements ModInitializer {

    public static final Block EnergyInputBlock = new EnergyInputBlock();
    public static final Block EnergyOutputBlock = new EnergyOutputBlock();

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, new Identifier("marisultimatenetworks", "energyinputblock"), EnergyInputBlock);
        Registry.register(Registry.ITEM, new Identifier("marisultimatenetworks", "energyinputblock"), new BlockItem(EnergyInputBlock, new Item.Settings().group(ItemGroup.MISC)));
        Registry.register(Registry.BLOCK, new Identifier("marisultimatenetworks", "energyoutputblock"), EnergyOutputBlock);
        Registry.register(Registry.ITEM, new Identifier("marisultimatenetworks", "energyoutputblock"), new BlockItem(EnergyOutputBlock, new Item.Settings().group(ItemGroup.MISC)));
    }
}