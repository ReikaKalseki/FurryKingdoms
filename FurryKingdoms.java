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

import Reika.DragonAPI.Interfaces.DragonAPIMod;
import Reika.RotaryCraft.ClientPackets;
import Reika.RotaryCraft.ServerPackets;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;

@Mod( modid = "FurryKingdoms", name="Furry Kingdoms", version="beta", certificateFingerprint = "@GET_FINGERPRINT@")
@NetworkMod(clientSideRequired = true, serverSideRequired = true,
clientPacketHandlerSpec = @SidedPacketHandler(channels = { "FurryKingData" }, packetHandler = ClientPackets.class),
serverPacketHandlerSpec = @SidedPacketHandler(channels = { "FurryKingData" }, packetHandler = ServerPackets.class))

public class FurryKingdoms implements DragonAPIMod {

	@Instance("FurryKingdoms")
	public static FurryKingdoms instance = new FurryKingdoms();

	@PreInit
	public void preload(FMLPreInitializationEvent evt) {
		FurryConfig.initProps(evt);

	}

	@Init
	public void load(FMLInitializationEvent event) {

	}

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
