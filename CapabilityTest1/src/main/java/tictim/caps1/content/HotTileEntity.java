package tictim.caps1.content;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import tictim.caps1.api.HotThing;

import javax.annotation.Nullable;

import static tictim.caps1.content.Contents.HOT_CAP;

public class HotTileEntity extends TileEntity{
	public HotTileEntity(){
		this(Contents.HOT_TE.get());
	}
	protected HotTileEntity(TileEntityType<?> tileEntityTypeIn){
		super(tileEntityTypeIn);
	}

	private final LazyOptional<HotThing> alice = LazyOptional.of(() -> new HotThing(){});

	@Override public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side){
		return cap==HOT_CAP ? alice.cast() : super.getCapability(cap, side);
	}

	@Override public void remove(){
		super.remove();
		alice.invalidate();
	}
}
