package net.hyper_pigeon.blood_in_the_water;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.hyper_pigeon.blood_in_the_water.entity.PiranhaEntityRenderer;

public class BloodInTheWaterModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.INSTANCE.register(BloodInTheWaterMod.PIRANHA_ENTITY,
                (dispatcher, context) ->
                        new PiranhaEntityRenderer(dispatcher));

    }
}
