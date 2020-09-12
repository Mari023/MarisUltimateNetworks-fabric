package de.mari_023.fabric.marisultimatenetworks.blocks;


import de.mari_023.fabric.marisultimatenetworks.blockentity.EnergyInputBlockEntity;
import de.mari_023.fabric.mariswrenchapi.IWrenchAble;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class EnergyInputBlock extends Block implements BlockEntityProvider, IWrenchAble {
    public EnergyInputBlock() {
        super(FabricBlockSettings.copy(Blocks.STONE));
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return new EnergyInputBlockEntity();
    }

    @Override
    public ActionResult wrench(PlayerEntity player, World world, Hand hand, HitResult hitResult) {
        player.sendMessage(Text.of("Wrenched!"), false);
        return ActionResult.SUCCESS;
    }
}