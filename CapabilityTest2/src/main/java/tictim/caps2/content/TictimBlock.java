package tictim.caps2.content;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class TictimBlock extends Block{
	public TictimBlock(Properties properties){
		super(properties);
	}

	@Override public boolean hasTileEntity(BlockState state){
		return true;
	}
	@Override public TileEntity createTileEntity(BlockState state, IBlockReader world){
		return new HotAndDangerousTileEntity();
	}
}
