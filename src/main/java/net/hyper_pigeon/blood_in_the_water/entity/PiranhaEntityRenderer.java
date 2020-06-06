package net.hyper_pigeon.blood_in_the_water.entity;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class PiranhaEntityRenderer extends MobEntityRenderer<PiranhaEntity, PiranhaEntityModel> {


    public PiranhaEntityRenderer(EntityRenderDispatcher renderManager) {
        super(renderManager, new PiranhaEntityModel(), 1);
    }

    @Override
    public Identifier getTexture(PiranhaEntity entity) {
        return new Identifier("blood_in_the_water","textures/entity/piranha/piranha_texture.png");
    }
}
