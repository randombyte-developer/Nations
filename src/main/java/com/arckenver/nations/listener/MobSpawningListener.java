package com.arckenver.nations.listener;


import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.EntityTypes;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.SpawnEntityEvent;

import com.arckenver.nations.DataHandler;
import com.google.common.collect.ImmutableList;


public class MobSpawningListener
{
	ImmutableList<EntityType> agressiveMobs = new ImmutableList.Builder<EntityType>()
			.add(EntityTypes.BLAZE)
			.add(EntityTypes.CAVE_SPIDER)
			.add(EntityTypes.CREEPER)
			.add(EntityTypes.ENDER_DRAGON)
			.add(EntityTypes.ENDERMAN)
			.add(EntityTypes.GHAST)
			.add(EntityTypes.GIANT)
			.add(EntityTypes.GUARDIAN)
			.add(EntityTypes.MAGMA_CUBE)
			.add(EntityTypes.PIG_ZOMBIE)
			.add(EntityTypes.SKELETON)
			.add(EntityTypes.SILVERFISH)
			.add(EntityTypes.SLIME)
			.add(EntityTypes.SPIDER)
			.add(EntityTypes.ZOMBIE)
			.add(EntityTypes.WITHER)
			.build();
	
	@Listener
	public void onPlayerRightClick(SpawnEntityEvent event)
	{
		event.filterEntities(e -> !agressiveMobs.contains(e.getType()) || DataHandler.getFlag("mobs", e.getLocation()));
	}
}