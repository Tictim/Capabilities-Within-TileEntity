package tictim.caps2.content;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class LegoBlock extends Block{
	public static final VoxelShape SHAPE = makeCuboidShape(6, 0, 8, 9, 1, 10);

	public LegoBlock(Properties properties){
		super(properties);
	}

	@Override public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context){
		return SHAPE;
	}

	@Override public boolean hasTileEntity(BlockState state){
		return true;
	}
	@Override public TileEntity createTileEntity(BlockState state, IBlockReader world){
		return new DangerousTileEntity();
	}
}
