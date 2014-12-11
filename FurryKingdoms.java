/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms;

import java.net.URL;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import Reika.DragonAPI.DragonAPICore;
import Reika.DragonAPI.Auxiliary.Trackers.BiomeCollisionTracker;
import Reika.DragonAPI.Auxiliary.Trackers.CommandableUpdateChecker;
import Reika.DragonAPI.Base.DragonAPIMod;
import Reika.DragonAPI.Instantiable.IO.ModLogger;
import Reika.DragonAPI.Libraries.ReikaRegistryHelper;
import Reika.FurryKingdoms.Registry.FurryBlocks;
import Reika.FurryKingdoms.Registry.FurryItems;
import Reika.FurryKingdoms.Registry.FurryOptions;
import Reika.FurryKingdoms.Registry.FurryTiles;
import Reika.FurryKingdoms.Registry.SpeciesType;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod( modid = "FurryKingdoms", name="Furry Kingdoms", version="beta", certificateFingerprint = "@GET_FINGERPRINT@", dependencies="required-after:DragonAPI")

//DimensionManager
public class FurryKingdoms extends DragonAPIMod {

	@Instance("FurryKingdoms")
	public static FurryKingdoms instance = new FurryKingdoms();

	public static final FurryConfig config = new FurryConfig(instance, FurryOptions.optionList, null, 1);

	public static Block[] blocks = new Block[FurryBlocks.blockList.length];
	public static Item[] items = new Item[FurryItems.itemList.length];

	public static final TabFurry tab = new TabFurry(CreativeTabs.getNextID(), instance.getDisplayName());

	public static ModLogger logger;

	@SidedProxy(clientSide="Reika.FurryKingdoms.FurryClient", serverSide="Reika.FurryKingdoms.FurryCommon")
	public static FurryCommon proxy;

	@Override
	@EventHandler
	public void preload(FMLPreInitializationEvent evt) {
		this.verifyVersions();
		config.loadSubfolderedConfigFile(evt);
		config.initProps(evt);
		logger = new ModLogger(instance, false);

		this.addBlocks();
		this.addItems();

		this.basicSetup(evt);
	}

	@Override
	@EventHandler
	public void load(FMLInitializationEvent event) {
		this.loadCities();

		proxy.registerRenderers();

		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new FurryGuiHandler());
	}

	private void loadCities() {
		for (int i = 0; i < SpeciesType.speciesList.length; i++) {
			SpeciesType species = SpeciesType.speciesList[i];
			int id = species.getCityBiomeID();
			BiomeCollisionTracker.instance.addBiomeID(instance, id, species.getBiomeClass());
			species.addBiome();
		}
	}

	private void addItems() {
		ReikaRegistryHelper.instantiateAndRegisterItems(instance, FurryItems.itemList, items);
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
		return DragonAPICore.getReikaForumPage();
	}

	@Override
	public String getWiki() {
		return null;
	}

	@Override
	public String getUpdateCheckURL() {
		return CommandableUpdateChecker.reikaURL;
	}

	@Override
	public ModLogger getModLogger() {
		return logger;
	}
}
