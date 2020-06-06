package net.hyper_pigeon.blood_in_the_water.entity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.CompositeEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class PiranhaEntityModel extends EntityModel<PiranhaEntity> {
    private final ModelPart body;
    private final ModelPart bone2;
    private final ModelPart body_sub_1;
    private final ModelPart bone;
    private final ModelPart body_sub_3;
    private final ModelPart tail;
    private final ModelPart fin_right;
    private final ModelPart fin_left;
    private final ModelPart fin_top;
    private final ModelPart fin_bottom;
    private final ModelPart fin_bottom2;
    private final ModelPart fin_bottom3;

    public PiranhaEntityModel() {
        textureWidth = 32;
        textureHeight = 32;

        body = new ModelPart(this);
        body.setPivot(0.0F, 21.0F, 3.0F);
        body.setTextureOffset(0, 0).addCuboid(-3.0F, -6.0F, -9.0F, 6.0F, 6.0F, 8.0F, 0.0F, false);
        body.setTextureOffset(20, 0).addCuboid(-1.0F, -4.0F, -3.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
        body.setTextureOffset(0, 14).addCuboid(-4.0F, -3.0F, -10.0F, 8.0F, 4.0F, 5.0F, 0.0F, false);

        bone2 = new ModelPart(this);
        bone2.setPivot(-1.0F, 3.0F, 0.0F);
        body.addChild(bone2);
        setRotationAngle(bone2, 0.0F, 0.7854F, 0.0F);


        body_sub_1 = new ModelPart(this);
        body_sub_1.setPivot(0.0F, 0.0F, 0.0F);
        bone2.addChild(body_sub_1);
        body_sub_1.setTextureOffset(4, 0).addCuboid(1.5355F, -5.0F, -3.5355F, 2.0F, 2.0F, 0.0F, 0.0F, false);

        bone = new ModelPart(this);
        bone.setPivot(1.0F, 3.0F, 0.0F);
        body.addChild(bone);
        this.setRotationAngle(bone, 0.0F, -0.7854F, 0.0F);


        body_sub_3 = new ModelPart(this);
        body_sub_3.setPivot(0.0F, 0.0F, 0.0F);
        bone.addChild(body_sub_3);
        body_sub_3.setTextureOffset(0, 0).addCuboid(-3.5355F, -5.0F, -3.5355F, 2.0F, 2.0F, 0.0F, 0.0F, false);

        tail = new ModelPart(this);
        tail.setPivot(0.0F, 21.0F, 7.0F);
        tail.setTextureOffset(0, 14).addCuboid(0.0F, -5.0F, -3.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
        tail.setTextureOffset(0, 12).addCuboid(0.0F, -3.0F, -3.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
        tail.setTextureOffset(10, 20).addCuboid(0.0F, -7.0F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        tail.setTextureOffset(6, 20).addCuboid(0.0F, -3.0F, -4.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
        tail.setTextureOffset(6, 20).addCuboid(0.0F, -4.0F, -4.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
        tail.setTextureOffset(0, 19).addCuboid(0.0F, -1.0F, -2.0F, 0.0F, 1.0F, 3.0F, 0.0F, false);
        tail.setTextureOffset(0, 0).addCuboid(0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
        tail.setTextureOffset(0, 4).addCuboid(0.0F, -6.0F, -2.0F, 0.0F, 1.0F, 3.0F, 0.0F, false);
        tail.setTextureOffset(4, 0).addCuboid(0.0F, -2.0F, -4.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
        tail.setTextureOffset(4, 0).addCuboid(0.0F, -5.0F, -4.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);

        fin_right = new ModelPart(this);
        fin_right.setPivot(-0.5F, 21.0F, -1.0F);
        setRotationAngle(fin_right, 0.0F, 0.6109F, 0.0F);
        fin_right.setTextureOffset(0, 2).addCuboid(3.3679F, -3.0F, 0.9042F, 0.0F, 2.0F, 3.0F, 0.0F, false);

        fin_left = new ModelPart(this);
        fin_left.setPivot(0.5F, 28.0F, 0.0F);
        setRotationAngle(fin_left, 0.0F, -0.6109F, 0.0F);
        fin_left.setTextureOffset(0, 0).addCuboid(-3.981F, -10.0F, 0.3121F, 0.0F, 2.0F, 3.0F, 0.0F, false);

        fin_top = new ModelPart(this);
        fin_top.setPivot(0.0F, 18.0F, 0.0F);
        fin_top.setTextureOffset(16, 21).addCuboid(0.0F, -4.0F, -4.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
        fin_top.setTextureOffset(20, 15).addCuboid(0.0F, -4.0F, -5.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
        fin_top.setTextureOffset(20, 13).addCuboid(0.0F, -5.0F, -3.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
        fin_top.setTextureOffset(20, 4).addCuboid(0.0F, -6.0F, -2.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
        fin_top.setTextureOffset(20, 0).addCuboid(0.0F, -5.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
        fin_top.setTextureOffset(20, 16).addCuboid(0.0F, -4.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);

        fin_bottom = new ModelPart(this);
        fin_bottom.setPivot(0.0F, 24.0F, 0.0F);
        fin_bottom.setTextureOffset(14, 21).addCuboid(0.0F, -3.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);

        fin_bottom2 = new ModelPart(this);
        fin_bottom2.setPivot(0.0F, 24.0F, 1.0F);
        fin_bottom2.setTextureOffset(6, 5).addCuboid(0.0F, -3.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);

        fin_bottom3 = new ModelPart(this);
        fin_bottom3.setPivot(0.0F, 24.0F, 1.0F);
        fin_bottom3.setTextureOffset(6, 2).addCuboid(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setAngles(PiranhaEntity entity, float limbAngle, float limbDistance, float customAngle, float headYaw, float headPitch) {

    }


    public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
        modelRenderer.pitch = x;
        modelRenderer.yaw = y;
        modelRenderer.roll = z;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        body.render(matrices, vertexConsumer, light, overlay);
        tail.render(matrices, vertexConsumer, light, overlay);
        fin_right.render(matrices, vertexConsumer, light, overlay);
        fin_left.render(matrices, vertexConsumer, light, overlay);
        fin_top.render(matrices, vertexConsumer, light, overlay);
        fin_bottom.render(matrices, vertexConsumer, light, overlay);
        fin_bottom2.render(matrices, vertexConsumer, light, overlay);
        fin_bottom3.render(matrices, vertexConsumer, light, overlay);
    }
}
