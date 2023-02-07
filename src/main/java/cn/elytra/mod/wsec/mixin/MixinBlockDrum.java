package cn.elytra.mod.wsec.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.rwtema.extrautils.block.BlockDrum;

@Mixin(value = BlockDrum.class)
public abstract class MixinBlockDrum extends Block {

    protected MixinBlockDrum(Material materialIn) {
        super(materialIn);
    }

    @Inject(method = "onBlockActivated", at = @At("RETURN"))
    protected void wsec$inventorySyncFix(World par1World, int par2, int par3, int par4, EntityPlayer player, int par6,
            float par7, float par8, float par9, CallbackInfoReturnable<Boolean> cir) {
        player.inventoryContainer.detectAndSendChanges();
    }

}
