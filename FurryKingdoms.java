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
import Reika.DragonAPI.Base.DragonAPIMod;
import Reika.DragonAPI.Instantiable.ControlledConfig;
import Reika.DragonAPI.Libraries.ReikaRegistryHelper;
import Reika.FurryKingdoms.Registry.FurryBlocks;
import Reika.FurryKingdoms.Registry.FurryOptions;
import Reika.FurryKingdoms.TileEntities.TileEntityFlag;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod( modid = "FurryKingdoms", name="Furry Kingdoms", version="beta", certificateFingerprint = "@GET_FINGERPRINT@")
@NetworkMod(clientSideRequired = true, serverSideRequired = true/*,
clientPacketHandlerSpec = @SidedPacketHandler(channels = { "FurryKingData" }, packetHandler = null.class),
serverPacketHandlerSpec = @SidedPacketHandler(channels = { "FurryKingData" }, packetHandler = null.class)*/)

public class FurryKingdoms extends DragonAPIMod {

	@Instance("FurryKingdoms")
	public static FurryKingdoms instance = new FurryKingdoms();

	public static final ControlledConfig config = new ControlledConfig(instance, FurryOptions.optionList, FurryBlocks.blockList, null, null, 1);

	public static Block[] blocks = new Block[FurryBlocks.blockList.length];

	public static final TabFurry tab = new TabFurry(CreativeTabs.getNextID(), instance.getDisplayName());

	@Override
	@PreInit
	public void preload(FMLPreInitializationEvent evt) {
		config.initProps(evt);

	}

	@Override
	@Init
	public void load(FMLInitializationEvent event) {
		this.addBlocks();
	}

	private static void addBlocks() {
		ReikaRegistryHelper.instantiateAndRegisterBlocks(instance, FurryBlocks.blockList, blocks, true);
		GameRegistry.registerTileEntity(TileEntityFlag.class, "FurryFlag");
	}

	@Override
	@PostInit // Like the modsLoaded thing from ModLoader
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
		return null;
	}

	@Override
	public boolean hasWiki() {
		return false;
	}

	@Override
	public URL getWiki() {
		return null;
	}
}
