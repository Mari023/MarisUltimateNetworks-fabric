package de.mari_023.fabric.marisultimatenetworks.blocks;

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

public abstract class BlockBasic extends Block implements BlockEntityProvider, IWrenchAble {
    private final BlockEntity blockEntity;

    public BlockBasic(BlockEntity blockEntity) {
        super(FabricBlockSettings.copy(Blocks.STONE));
        this.blockEntity = blockEntity;
    }

    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return blockEntity;
    }

    @Override
    public ActionResult wrench(PlayerEntity player, World world, Hand hand, HitResult hitResult) {
        player.sendMessage(Text.of("Wrenched!"), false);
        return ActionResult.SUCCESS;
    }
}
