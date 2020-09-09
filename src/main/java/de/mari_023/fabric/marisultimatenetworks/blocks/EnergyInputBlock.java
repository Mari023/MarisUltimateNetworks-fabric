package de.mari_023.fabric.marisultimatenetworks.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class EnergyInputBlock extends Block {
    public EnergyInputBlock() {
        super(FabricBlockSettings.copy(Blocks.STONE));
    }
}
