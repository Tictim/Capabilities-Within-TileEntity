package tictim.caps1.content;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import static tictim.caps1.content.Contents.HOT_CAP;

public class HotSensorItem extends Item{
	public HotSensorItem(Properties properties){
		super(properties);
	}

	@Override public ActionResultType onItemUse(ItemUseContext context){
		PlayerEntity player = context.getPlayer();
		if(player!=null){
			World world = context.getWorld();
			if(!world.isRemote){
				TileEntity te = world.getTileEntity(context.getPos());
				if(te!=null&&te.getCapability(HOT_CAP).isPresent())
					player.sendStatusMessage(new StringTextComponent("This is hot!"), true);
			}
			return ActionResultType.SUCCESS;
		}else return ActionResultType.PASS;
	}
}
