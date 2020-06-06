package net.hyper_pigeon.blood_in_the_water;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.hyper_pigeon.blood_in_the_water.entity.PiranhaEntity;
import net.hyper_pigeon.blood_in_the_water.item.PiranhaFishBucket;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

public class BloodInTheWaterMod implements ModInitializer {

	public static final EntityType<PiranhaEntity> PIRANHA_ENTITY =
			Registry.register(
					Registry.ENTITY_TYPE,
					new Identifier("blood_in_the_water", "piranha"),
					FabricEntityTypeBuilder.create(EntityCategory.WATER_CREATURE, PiranhaEntity::new).size(EntityDimensions.fixed(1, 2)).build()

			);

	public static final PiranhaFishBucket PIRANHA_FISH_BUCKET =
			new PiranhaFishBucket(Fluids.WATER, new Item.Settings().group(ItemGroup.MISC));


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registry.ITEM, new Identifier("blood_in_the_water", "piranha_fish_bucket"), PIRANHA_FISH_BUCKET);
		Biomes.RIVER.getEntitySpawnList(EntityCategory.WATER_CREATURE).add(new Biome.SpawnEntry(PIRANHA_ENTITY,1,1,3));
	}
}
