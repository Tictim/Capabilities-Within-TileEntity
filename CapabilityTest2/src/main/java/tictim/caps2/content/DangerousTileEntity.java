package tictim.caps2.content;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import tictim.caps2.api.DangerousThing;

import javax.annotation.Nullable;

public class DangerousTileEntity extends TileEntity{
	public DangerousTileEntity(){
		this(Contents.DANGEROUS_TE.get());
	}
	public DangerousTileEntity(TileEntityType<?> tileEntityTypeIn){
		super(tileEntityTypeIn);
	}

	private final LazyOptional<DangerousThing> dangerous = LazyOptional.of(() -> new DangerousThing(){});

	@Override public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side){
		return cap==Contents.DANGEROUS_CAP ? dangerous.cast() : super.getCapability(cap, side);
	}
}
