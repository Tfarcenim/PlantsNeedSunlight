package tfar.plantsneedsunlight;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class PlantsNeedSunlightConfig {

    public static final PlantsNeedSunlightConfig SERVER;
    public static final ForgeConfigSpec SERVER_SPEC;

    static {
        final Pair<PlantsNeedSunlightConfig, ForgeConfigSpec> specPair2 = new ForgeConfigSpec.Builder().configure(PlantsNeedSunlightConfig::new);
        SERVER_SPEC = specPair2.getRight();
        SERVER = specPair2.getLeft();
    }

    public final ForgeConfigSpec.DoubleValue cropGrowthChance;
    public final ForgeConfigSpec.BooleanValue cropsRequireSunlight;

    public PlantsNeedSunlightConfig(ForgeConfigSpec.Builder builder) {
        builder.push("general");

        cropGrowthChance = builder.comment("Chance for a crop growth event to succeed, default 1 (100%)").defineInRange("crop_growth_chance",1,0,1d);
        cropsRequireSunlight = builder.comment("Crops require sunlight to grow (default: true)").define("crops_require_sunlight",true);
        builder.pop();
    }

}
