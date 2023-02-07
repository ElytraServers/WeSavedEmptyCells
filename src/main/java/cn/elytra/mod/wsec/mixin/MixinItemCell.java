package cn.elytra.mod.wsec.mixin;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import ic2.core.Ic2Items;
import ic2.core.init.InternalName;
import ic2.core.item.resources.ItemCell;
import ic2.core.util.StackUtil;

@Mixin(value = ItemCell.class)
public abstract class MixinItemCell extends Item {

    /**
     * Simply add the cell as its container item.
     */
    @Inject(method = "<init>", at = @At("RETURN"))
    protected void wsec$setContainerOfCells(InternalName internalName, CallbackInfo ci) {
        this.setContainerItem(this);
    }

    /**
     * Returns an empty cell when a fluid is placed.
     */
    @Inject(method = "onItemUse", at = @At(value = "RETURN", ordinal = 5))
    protected void wsec$returnEmptyCellOnFluidPlacements(ItemStack stack, EntityPlayer player, World world, int x,
            int y, int z, int side, float xOffset, float yOffset, float zOffset, CallbackInfoReturnable<Boolean> cir) {
        // here, we save the empty cells
        StackUtil.storeInventoryItem(Ic2Items.cell.copy(), player, false);
    }
}
