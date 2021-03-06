package com.teamabnormals.abnormals_core.common.blocks.chest;

import com.teamabnormals.abnormals_core.common.tileentity.AbnormalsChestTileEntity;
import com.teamabnormals.abnormals_core.core.examples.ExampleTileEntityRegistry;
import com.teamabnormals.abnormals_core.core.library.api.IChestBlock;

import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class AbnormalsChestBlock extends ChestBlock implements IChestBlock {

	public final String modid;
	public final String type;
	
	public AbnormalsChestBlock(String modid, String type, Properties props) {
		super(props, () -> ExampleTileEntityRegistry.CHEST.get());	
		this.modid = modid;
		this.type = type;
	}
	
	@Override
	public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return new AbnormalsChestTileEntity();
	}

	@Override
	public String getChestName() {
		return type;
	}
	
	@Override
	public String getModid() {
		return modid;
	}

	@Override
	public boolean isTrapped() {
		return false;
	}
}
