package com.teamabnormals.abnormals_core.core.library.endimator;

import com.teamabnormals.abnormals_core.core.library.endimator.entity.IEndimatedEntity;
import com.teamabnormals.abnormals_core.core.utils.NetworkUtil;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.goal.Goal;

/**
 * A Goal that makes Goals with Endimations simpler
 * @author SmellyModder(Luke Tonon)
 * @param <E> - The entity for the Goal
 */
public abstract class EndimatedGoal<E extends Entity & IEndimatedEntity> extends Goal {
	protected final E entity;
	
	public EndimatedGoal(E entity) {
		this.entity = entity;
	}
	
	protected boolean isEndimationPlaying() {
		return this.entity.isEndimationPlaying(this.getEndimation());
	}
	
	protected boolean isEndimationAtTick(int tick) {
		return this.entity.getAnimationTick() == tick;
	}
	
	protected boolean isEndimationPastOrAtTick(int tick) {
		return this.entity.getAnimationTick() >= tick;
	}
	
	protected void playEndimation() {
		NetworkUtil.setPlayingAnimationMessage(this.entity, this.getEndimation());
	}

	protected abstract Endimation getEndimation();
}