/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2013
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms;

import java.net.URL;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import Reika.DragonAPI.DragonAPICore;
import Reika.DragonAPI.ModList;
import Reika.DragonAPI.Auxiliary.BiomeCollisionTracker;
import Reika.DragonAPI.Base.DragonAPIMod;
import Reika.DragonAPI.Instantiable.IO.ModLogger;
import Reika.DragonAPI.Libraries.ReikaRegistryHelper;
import Reika.FurryKingdoms.Registry.FurryBlocks;
import Reika.FurryKingdoms.Registry.FurryOptions;
import Reika.FurryKingdoms.Registry.FurryTiles;
import Reika.FurryKingdoms.Registry.SpeciesType;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod( modid = "FurryKingdoms", name="Furry Kingdoms", version="beta", certificateFingerprint = "@GET_FINGERPRINT@", dependencies="required-after:DragonAPI")
@NetworkMod(clientSideRequired = true, serverSideRequired = true/*,
clientPacketHandlerSpec = @SidedPacketHandler(channels = { "FurryKingData" }, packetHandler = null.class),
serverPacketHandlerSpec = @SidedPacketHandler(channels = { "FurryKingData" }, packetHandler = null.class)*/)

//DimensionManager
public class FurryKingdoms extends DragonAPIMod {

	@Instance("FurryKingdoms")
	public static FurryKingdoms instance = new FurryKingdoms();

	public static final FurryConfig config = new FurryConfig(instance, FurryOptions.optionList, FurryBlocks.blockList, null, null, 1);

	public static Block[] blocks = new Block[FurryBlocks.blockList.length];

	public static final TabFurry tab = new TabFurry(CreativeTabs.getNextID(), instance.getDisplayName());

	public static ModLogger logger;

	@Override
	@EventHandler
	public void preload(FMLPreInitializationEvent evt) {
		config.loadSubfolderedConfigFile(evt);
		config.initProps(evt);
		logger = new ModLogger(instance, FurryOptions.LOGLOADING.getState(), FurryOptions.DEBUGMODE.getState(), false);

		ReikaRegistryHelper.setupModData(instance, evt);
		ReikaRegistryHelper.setupVersionChecking(evt);
	}

	@Override
	@EventHandler
	public void load(FMLInitializationEvent event) {
		this.addBlocks();
		this.loadCities();
	}

	private void loadCities() {
		for (int i = 0; i < SpeciesType.speciesList.length; i++) {
			SpeciesType species = SpeciesType.speciesList[i];
			int id = species.getCityBiomeID();
			BiomeCollisionTracker.instance.addBiomeID(ModList.FURRYKINGDOMS, id, species.getBiomeClass());
			species.addBiome();
		}
	}

	private void addBlocks() {
		ReikaRegistryHelper.instantiateAndRegisterBlocks(instance, FurryBlocks.blockList, blocks);
		for (int i = 0; i < FurryTiles.TEList.length; i++)
			GameRegistry.registerTileEntity(FurryTiles.TEList[i].getTEClass(), "Furry"+FurryTiles.TEList[i].getName());
	}

	@Override
	@EventHandler // Like the modsLoaded thing from ModLoader
	public void postload(FMLPostInitializationEvent evt) {

	}

	@Override
	public String getDisplayName() {
		return "Furry Kingdoms";
	}

	@Override
	public String getModAuthorName() {
		return "Reika";
	}

	@Override
	public URL getDocumentationSite() {
		return DragonAPICore.getReikaForumPage(instance);
	}

	@Override
	public boolean hasWiki() {
		return false;
	}

	@Override
	public URL getWiki() {
		return null;
	}

	@Override
	public boolean hasVersion() {
		return false;
	}

	@Override
	public String getVersionName() {
		return null;
	}

	@Override
	public ModLogger getModLogger() {
		return logger;
	}
}
