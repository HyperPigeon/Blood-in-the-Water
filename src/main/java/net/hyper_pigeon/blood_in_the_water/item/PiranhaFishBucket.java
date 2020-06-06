package net.hyper_pigeon.blood_in_the_water.item;

import net.hyper_pigeon.blood_in_the_water.BloodInTheWaterMod;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.FishBucketItem;

public class PiranhaFishBucket extends FishBucketItem {

    public PiranhaFishBucket(Fluid fluid, Settings settings) {
        super(BloodInTheWaterMod.PIRANHA_ENTITY,fluid,settings);
    }


}
