package plus.dragons.createfarmersautomation.foundation.mixin.common;

import com.simibubi.create.content.contraptions.components.deployer.DeployerTileEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = DeployerTileEntity.class, remap = false)
public interface DeployerTileEntityAccessor {
    
    @Accessor(value = "heldItem")
    ItemStack getHeldItem();
    
}