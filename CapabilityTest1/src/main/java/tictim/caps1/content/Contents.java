package tictim.caps1.content;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tictim.caps1.api.HotThing;

import static tictim.caps1.Caps1Mod.MODID;

public final class Contents{
	private Contents(){}

	@CapabilityInject(HotThing.class)
	public static final Capability<HotThing> HOT_CAP = null;


	private static final ItemGroup GROUP = new ItemGroup(MODID){
		@Override public ItemStack createIcon(){
			return new ItemStack(HOT_POTATO_IN_A_BOWL_ITEM.get());
		}
	};

	private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
	private static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MODID);

	public static final RegistryObject<Block> HOT_POTATO_IN_A_BOWL = BLOCKS.register("hot_potato_in_a_bowl",
			() -> new BowlOfPotatoBlock(AbstractBlock.Properties.create(Material.ROCK).doesNotBlockMovement()));

	public static final RegistryObject<Item> HOT_SENSOR = ITEMS.register("hot_sensor",
			() -> new HotSensorItem(new Item.Properties().maxStackSize(1).group(GROUP)));
	public static final RegistryObject<Item> HOT_POTATO_IN_A_BOWL_ITEM = ITEMS.register("hot_potato_in_a_bowl",
			() -> new BlockItem(HOT_POTATO_IN_A_BOWL.get(), new Item.Properties().group(GROUP)));

	public static final RegistryObject<TileEntityType<HotTileEntity>> HOT_TE = TILE_ENTITIES.register("hot",
			() -> TileEntityType.Builder
					.create(HotTileEntity::new, HOT_POTATO_IN_A_BOWL.get())
					.build(null));

	public static void registerEventHandlers(IEventBus modEventBus){
		ITEMS.register(modEventBus);
		BLOCKS.register(modEventBus);
		TILE_ENTITIES.register(modEventBus);
	}
}
