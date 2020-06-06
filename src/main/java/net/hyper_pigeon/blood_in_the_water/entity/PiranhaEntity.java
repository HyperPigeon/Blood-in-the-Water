package net.hyper_pigeon.blood_in_the_water.entity;

import net.hyper_pigeon.blood_in_the_water.BloodInTheWaterMod;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.FollowGroupLeaderGoal;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimAroundGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.TropicalFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class PiranhaEntity extends TropicalFishEntity implements Monster{


    public PiranhaEntity(EntityType<? extends TropicalFishEntity> type, World world) {
        super(type, world);

    }

    @Override
    protected void initGoals() {

        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.5D, true));
        this.targetSelector.add(2, new FollowTargetGoal(this, LivingEntity.class, 4, false,
                true, (livingEntity) -> {
            return livingEntity instanceof LivingEntity && !(livingEntity instanceof IronGolemEntity) ;
        }));
        this.goalSelector.add(3, new PiranhaEntity.SwimToRandomPlaceGoal(this));
        this.goalSelector.add(20, new FollowGroupLeaderGoal(this));

    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributes().register(EntityAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getAttributeInstance(EntityAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(3.0D);
    }


    @Override
    public void setTarget(LivingEntity entity_1) {

        if(entity_1 != null && !(entity_1 instanceof PiranhaEntity)) {
            if (entity_1.getHealth() < entity_1.getMaximumHealth()){
                super.setTarget(entity_1);
            }
            else if(getAttacker() == entity_1) {
                super.setTarget(entity_1);
            }
        }
    }


    protected ItemStack getFishBucketItem() {
        return new ItemStack(BloodInTheWaterMod.PIRANHA_FISH_BUCKET);
    }


    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_TROPICAL_FISH_FLOP;
    }


    static class FishMoveControl extends MoveControl {
        private final PiranhaEntity fish;

        FishMoveControl(PiranhaEntity owner) {
            super(owner);
            this.fish = owner;
        }

        public void tick() {
            if (this.fish.isInFluid(FluidTags.WATER)) {
                this.fish.setVelocity(this.fish.getVelocity().add(0.0D, 0.005D, 0.0D));
            }

            if (this.state == State.MOVE_TO && !this.fish.getNavigation().isIdle()) {
                double d = this.targetX - this.fish.getX();
                double e = this.targetY - this.fish.getY();
                double f = this.targetZ - this.fish.getZ();
                double g = (double) MathHelper.sqrt(d * d + e * e + f * f);
                e /= g;
                float h = (float)(MathHelper.atan2(f, d) * 57.2957763671875D) - 90.0F;
                this.fish.yaw = this.changeAngle(this.fish.yaw, h, 90.0F);
                this.fish.bodyYaw = this.fish.yaw;
                float i = (float)(this.speed * this.fish.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).getValue());
                this.fish.setMovementSpeed(MathHelper.lerp(0.125F, this.fish.getMovementSpeed(), i));
                this.fish.setVelocity(this.fish.getVelocity().add(0.0D, (double)this.fish.getMovementSpeed() * e * 0.1D, 0.0D));
            } else {
                this.fish.setMovementSpeed(3.0F);
            }
        }
    }

    static class SwimToRandomPlaceGoal extends SwimAroundGoal {
        private final PiranhaEntity fish;

        public SwimToRandomPlaceGoal(PiranhaEntity fish) {
            super(fish, 1.0D, 40);
            this.fish = fish;
        }

        public boolean canStart() {
            return this.fish.hasSelfControl() && super.canStart();
        }
    }

    protected boolean hasSelfControl() {
        return super.hasSelfControl();
    }



}
