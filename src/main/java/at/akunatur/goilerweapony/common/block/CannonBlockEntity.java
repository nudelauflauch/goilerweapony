package at.akunatur.goilerweapony.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CannonBlockEntity extends BlockEntity{

	public CannonBlockEntity(BlockEntityType<?> pType, BlockPos pWorldPosition,
			BlockState pBlockState) {
		super(pType, pWorldPosition, pBlockState);
	}

}
