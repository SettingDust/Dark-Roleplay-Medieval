package net.dark_roleplay.medieval.mess.common;

import java.io.File;

import com.typesafe.config.ConfigSyntax;

import net.dark_roleplay.medieval.mess.client.events.Event_GuiOpen;
import net.dark_roleplay.medieval.mess.client.events.config.Event_ConfigChange;
import net.dark_roleplay.medieval.mess.common.config.Client;
import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalAchievements;
import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalBlocks;
import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalCapabilities;
import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalItems;
import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalMappings;
import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalPackets;
import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalSkills;
import net.dark_roleplay.medieval.mess.common.handler.DRPMedievalVillagers;
import net.dark_roleplay.medieval.mess.common.objects.events.blocks.Event_BlockBreak;
import net.dark_roleplay.medieval.mess.common.objects.events.capabilities.Event_CapabilityTileEntity;
import net.dark_roleplay.medieval.mess.common.objects.gui.GuiHandler;
import net.dark_roleplay.medieval.mess.common.world_generation.WorldLoot;
import net.dark_roleplay.medieval.mess.common.world_generation.feature.DryClayGenerator;
import net.dark_roleplay.medieval.mess.common.world_generation.feature.OreGen;
import net.dark_roleplay.medieval.mess.work_in_progress_2.Carpenter;
import net.dark_roleplay.medieval.mess.work_in_progress_2.VillageHandlerCarpenter;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = References.MODID, version = References.VERSION, name = References.NAME, acceptedMinecraftVersions = References.ACCEPTEDVERSIONS, dependencies = References.DEPENDECIES, updateJSON = References.UPDATECHECK)
public class DarkRoleplayMedieval {

	
	public static boolean isOnServer = false;
	
	@SidedProxy(serverSide = "net.dark_roleplay.medieval.common.CommonProxy", clientSide = "net.dark_roleplay.medieval.client.ClientProxy")
	public static CommonProxy proxy;

	@net.minecraftforge.fml.common.Mod.Instance(References.MODID)
	public static DarkRoleplayMedieval instance;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		References.SIDE = event.getSide();
		DarkRoleplayMedieval.isOnServer = event.getSide().isServer();

		DRPMedievalCapabilities.register();
		DRPMedievalVillagers.init(event);
		DRPMedievalSkills.init(event);
		DRPMedievalAchievements.init(event);
		DarkRoleplayMedieval.proxy.init(event);
		
		NetworkRegistry.INSTANCE.registerGuiHandler(DarkRoleplayMedieval.instance, new GuiHandler());

		VillageHandlerCarpenter villageHandler = new VillageHandlerCarpenter();
		VillagerRegistry.instance().registerVillageCreationHandler(villageHandler);
		MapGenStructureIO.registerStructureComponent(Carpenter.class, References.MODID+":carpenter_house_small");
		
		if(Client.MAARG_VERSION < References.MAARG_VERSION) {
			File drp = new File(net.dark_roleplay.core_modules.maarg.References.FOLDER_ARG, "drpmedieval");
			if(drp.exists()) deleteFolder(drp);
			Client.MAARG_VERSION = References.MAARG_VERSION;

			ConfigManager.sync(References.MODID, Config.Type.INSTANCE);
		}
		
		
		String path = References.MODID + ":arg/textures/wood/";
		String path_t = References.MODID + ":arg/lang/wood/";
	}
	
	private static void deleteFolder(File folder) {
	    File[] files = folder.listFiles();
	    if(files!=null) {
	        for(File f: files) {
	            if(f.isDirectory()) {
	                deleteFolder(f);
	            } else {
	                f.delete();
	            }
	        }
	    }
	    folder.delete();
	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {
		
		DRPMedievalVillagers.init(event);
		DRPMedievalSkills.init(event);
		DRPMedievalAchievements.init(event);
		DarkRoleplayMedieval.proxy.init(event);
		WorldLoot.registerChestLoot();
		WorldLoot.registerFishingLoot();
		WorldLoot.registerGrassLoot();


		GameRegistry.registerWorldGenerator(new OreGen(), 0);
		GameRegistry.registerWorldGenerator(new DryClayGenerator(), 500);
//		GameRegistry.registerWorldGenerator(new GenerateStructure(), 0);

		DRPMedievalPackets.init();
		
		if(event.getSide() == Side.CLIENT){
			MinecraftForge.EVENT_BUS.register(new Event_GuiOpen());
			MinecraftForge.EVENT_BUS.register(new Event_ConfigChange());
//			RenderPlayer steve = ((RenderPlayer)Minecraft.getMinecraft().getRenderManager().getSkinMap().get("default"));
//			RenderPlayer alex = ((RenderPlayer)Minecraft.getMinecraft().getRenderManager().getSkinMap().get("slim"));
//			steve.addLayer(new RenderLayerPremium());
//			alex.addLayer(new RenderLayerPremium());
//			steve.addLayer(new RenderLayer_Guild());
//			alex.addLayer(new RenderLayer_Guild());
		}

		DRPMedievalMappings.init(event);

		MinecraftForge.EVENT_BUS.register(new Event_BlockBreak());
		
		registerFurnaceRecipes();

//		GameRegistry.registerWorldGenerator(new GenHandler_Trees(), 0);
		
		MinecraftForge.EVENT_BUS.register(new Event_CapabilityTileEntity());
		

		DRPMedievalBlocks.CANDLE_HOLDER_UNLIT.init(DRPMedievalBlocks.CANDLE_HOLDER_LIT, Item.getItemFromBlock(DRPMedievalBlocks.BEESWAX_CANDLE));;
		DRPMedievalBlocks.CANDLE_HOLDER_LIT.init(DRPMedievalBlocks.CANDLE_HOLDER_UNLIT, Item.getItemFromBlock(DRPMedievalBlocks.BEESWAX_CANDLE));
		DRPMedievalBlocks.TORCH_HOLDER_UNLIT.init(DRPMedievalBlocks.TORCH_HOLDER_LIT, Item.getItemFromBlock(Blocks.TORCH));
		DRPMedievalBlocks.TORCH_HOLDER_LIT.init(DRPMedievalBlocks.TORCH_HOLDER_UNLIT, Item.getItemFromBlock(Blocks.TORCH));
		DRPMedievalBlocks.CANDLE_HOLDER_EMPTY.init(DRPMedievalBlocks.CANDLE_HOLDER_UNLIT, Item.getItemFromBlock(DRPMedievalBlocks.BEESWAX_CANDLE));
		DRPMedievalBlocks.TORCH_HOLDER_EMPTY.init(DRPMedievalBlocks.TORCH_HOLDER_UNLIT, Item.getItemFromBlock(Blocks.TORCH));
		
		DRPMedievalBlocks.SALPETER_ORE.init(DRPMedievalItems.ORE_CHUNK_SALPETER);
		DRPMedievalBlocks.SILVER_ORE.init(DRPMedievalItems.ORE_CHUNK_SILVER);
		DRPMedievalBlocks.TIN_ORE.init(DRPMedievalItems.ORE_CHUNK_TIN);
		DRPMedievalBlocks.COPPER_ORE.init(DRPMedievalItems.ORE_CHUNK_COPPER);
		DRPMedievalBlocks.SULFUR_ORE.init(DRPMedievalItems.ORE_CHUNK_SULFUR);
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		DRPMedievalVillagers.init(event);
		DRPMedievalAchievements.init(event);
		DRPMedievalSkills.init(event);
		DarkRoleplayMedieval.proxy.init(event);
		
		ModContainer mod = Loader.instance().activeModContainer();
		if(mod.getModId().equals(References.MODID)){
			References.VERSION_STATUS = ForgeVersion.getResult(mod);
		}
		
		MinecraftForge.addGrassSeed(new ItemStack(DRPMedievalItems.BARLEY_SEED, 1), 1);
	}

	public static void registerFurnaceRecipes() {

		GameRegistry.addSmelting(DRPMedievalItems.DOUGH, new ItemStack(Items.BREAD), 0.1f);
		GameRegistry.addSmelting(DRPMedievalItems.RAW_WOLF, new ItemStack(DRPMedievalItems.COOKED_WOLF), 0.1f);
		GameRegistry.addSmelting(DRPMedievalItems.RAW_CATFISH, new ItemStack(DRPMedievalItems.COOKED_CATFISH), 0.1f);
		GameRegistry.addSmelting(DRPMedievalItems.PUMPKIN_DOUGH, new ItemStack(DRPMedievalItems.PUMPKIN_BREAD), 0.1f);
		GameRegistry.addSmelting(Item.getItemFromBlock(Blocks.OBSIDIAN), new ItemStack(DRPMedievalBlocks.OBSIDIAN_GLASS), 0.1f);		
		GameRegistry.addSmelting(Item.getItemFromBlock(DRPMedievalBlocks.UNFIRED_VASE), new ItemStack(DRPMedievalBlocks.FIRED_VASE), 0.1f);

	}
}