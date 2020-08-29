package tictim.caps2.content;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import tictim.caps1.api.HotThing;
import tictim.caps2.api.DangerousThing;
import tictim.caps2.integration.SimpleHotThing;

import javax.annotation.Nullable;

public class HotAndDangerousTileEntity extends TileEntity{
	public HotAndDangerousTileEntity(){
		this(Contents.HOT_AND_DANGEROUS_TE.get());
	}
	public HotAndDangerousTileEntity(TileEntityType<?> tileEntityTypeIn){
		super(tileEntityTypeIn);
	}

	private LazyOptional<HotThing> hot;
	private final LazyOptional<DangerousThing> dangerous = LazyOptional.of(() -> new DangerousThing(){});

	@Override public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side){
		if(Contents.HOT_CAP!=null&&Contents.HOT_CAP==cap){
			if(hot==null) hot = LazyOptional.of(SimpleHotThing::new);
			return hot.cast();
		}else if(Contents.DANGEROUS_CAP==cap) return dangerous.cast();
		else return super.getCapability(cap, side);
	}
}
