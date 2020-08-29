package tictim.caps1;

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
import tictim.caps1.api.HotThing;
import tictim.caps1.content.Contents;

import javax.annotation.Nullable;

@Mod(Caps1Mod.MODID)
@Mod.EventBusSubscriber(bus = Bus.MOD)
public class Caps1Mod{
	public static final String MODID = "capabilitytest1";

	public Caps1Mod(){
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		Contents.registerEventHandlers(modEventBus);
	}

	@SubscribeEvent
	public static void setup(FMLCommonSetupEvent event){
		CapabilityManager.INSTANCE.register(HotThing.class, new Capability.IStorage<HotThing>(){
			@Nullable @Override public INBT writeNBT(Capability<HotThing> capability, HotThing instance, Direction side){
				return null;
			}
			@Override public void readNBT(Capability<HotThing> capability, HotThing instance, Direction side, INBT nbt){}
		}, () -> {
			throw new UnsupportedOperationException();
		});
	}
}
