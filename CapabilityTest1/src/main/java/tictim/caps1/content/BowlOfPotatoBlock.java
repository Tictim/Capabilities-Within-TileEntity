package tictim.caps1.content;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class BowlOfPotatoBlock extends Block{
	private static final VoxelShape SHAPE = VoxelShapes.or(
			makeCuboidShape(4, 1, 4, 12, 3, 5),
			makeCuboidShape(4, 1, 5, 5, 3, 11),
			makeCuboidShape(4, 1, 11, 12, 3, 12),
			makeCuboidShape(11, 1, 5, 12, 3, 11),
			makeCuboidShape(5, 0, 5, 11, 2, 11),
			makeCuboidShape(6, 2, 6, 9, 5, 10),
			makeCuboidShape(9, 2, 6, 10, 4, 10)
	);

	public BowlOfPotatoBlock(Properties properties){
		super(properties);
	}

	@Override public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context){
		return SHAPE;
	}

	@Override public boolean hasTileEntity(BlockState state){
		return true;
	}

	@Override public TileEntity createTileEntity(BlockState state, IBlockReader world){
		return new HotTileEntity();
	}
}
