package tfar.plantsneedsunlight.mixin;

import tfar.plantsneedsunlight.PlantsNeedSunlight;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class MixinTitleScreen {
    
    @Inject(at = @At("HEAD"), method = "init()V")
    private void init(CallbackInfo info) {
        
        PlantsNeedSunlight.LOG.info("This line is printed by an example mod mixin from Fabric!");
        PlantsNeedSunlight.LOG.info("MC Version: {}", Minecraft.getInstance().getVersionType());
    }
}