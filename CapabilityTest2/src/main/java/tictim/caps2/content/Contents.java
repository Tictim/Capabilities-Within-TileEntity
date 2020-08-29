package tictim.caps2.content;

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
import tictim.caps2.api.DangerousThing;

import static tictim.caps2.Caps2Mod.MODID;

public class Contents{
	private Contents(){}

	@CapabilityInject(HotThing.class)
	public static final Capability<HotThing> HOT_CAP = null;
	@CapabilityInject(DangerousThing.class)
	public static final Capability<DangerousThing> DANGEROUS_CAP = null;


	private static final ItemGroup GROUP = new ItemGroup(MODID){
		@Override public ItemStack createIcon(){
			return new ItemStack(LEGO_ITEM.get());
		}
	};

	private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
	private static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MODID);


	public static final RegistryObject<Block> LEGO = BLOCKS.register("lego",
			() -> new LegoBlock(AbstractBlock.Properties.create(Material.ROCK).doesNotBlockMovement()));
	public static final RegistryObject<Block> TICTIM = BLOCKS.register("tictim",
			() -> new TictimBlock(AbstractBlock.Properties.create(Material.ROCK)));

	public static final RegistryObject<Item> LEGO_ITEM = ITEMS.register("lego",
			() -> new BlockItem(LEGO.get(), new Item.Properties().group(GROUP)));
	public static final RegistryObject<Item> TICTIM_ITEM = ITEMS.register("tictim",
			() -> new BlockItem(TICTIM.get(), new Item.Properties().group(GROUP)));

	public static final RegistryObject<TileEntityType<DangerousTileEntity>> DANGEROUS_TE = TILE_ENTITIES.register("dangerous",
			() -> TileEntityType.Builder
					.create(DangerousTileEntity::new, LEGO.get())
					.build(null));
	public static final RegistryObject<TileEntityType<HotAndDangerousTileEntity>> HOT_AND_DANGEROUS_TE = TILE_ENTITIES.register("hot_and_dangerous",
			() -> TileEntityType.Builder
					.create(HotAndDangerousTileEntity::new, TICTIM.get())
					.build(null));


	public static final RegistryObject<Item> DANGER_SENSOR = ITEMS.register("danger_sensor",
			() -> new DangerSensorItem(new Item.Properties().maxStackSize(1).group(GROUP)));

	public static void registerEventHandlers(IEventBus modEventBus){
		ITEMS.register(modEventBus);
		BLOCKS.register(modEventBus);
		TILE_ENTITIES.register(modEventBus);
	}
}
