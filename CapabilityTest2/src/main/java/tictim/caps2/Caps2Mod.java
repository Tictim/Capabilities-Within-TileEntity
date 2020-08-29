package tictim.caps2;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import tictim.caps2.api.DangerousThing;
import tictim.caps2.content.Contents;

import javax.annotation.Nullable;

@Mod(Caps2Mod.MODID)
@Mod.EventBusSubscriber(bus = Bus.MOD)
public class Caps2Mod{
	public static final String MODID = "capabilitytest2";


	public Caps2Mod(){
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		Contents.registerEventHandlers(modEventBus);
	}

	@SubscribeEvent
	public static void setup(FMLCommonSetupEvent event){
		CapabilityManager.INSTANCE.register(DangerousThing.class, new Capability.IStorage<DangerousThing>(){
			@Nullable @Override public INBT writeNBT(Capability<DangerousThing> capability, DangerousThing instance, Direction side){
				return null;
			}
			@Override public void readNBT(Capability<DangerousThing> capability, DangerousThing instance, Direction side, INBT nbt){}
		}, () -> {
			throw new UnsupportedOperationException();
		});
	}
}
