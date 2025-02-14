package tfar.plantsneedsunlight;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(PlantsNeedSunlight.MOD_ID)
public class PlantsNeedSunlightForge {

    public PlantsNeedSunlightForge() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, PlantsNeedSunlightConfig.SERVER_SPEC);
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.addListener(this::onGrow);
        PlantsNeedSunlight.init();
    }

    private void onGrow(BlockEvent.CropGrowEvent.Pre event) {
        BlockPos pos = event.getPos();
        Level level = (Level) event.getLevel();
        BlockState blockState = event.getState();
        if (level.random.nextDouble() > PlantsNeedSunlightConfig.SERVER.cropGrowthChance.get()) {
            event.setResult(Event.Result.DENY);
            return;
        }

        int skyLight = level.getBrightness(LightLayer.SKY, pos);
        if (skyLight < 9 && PlantsNeedSunlightConfig.SERVER.cropsRequireSunlight.get()) {
            event.setResult(Event.Result.DENY);
        }
    }
}