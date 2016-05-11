/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2016
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms;

import net.minecraft.world.World;
import Reika.DragonAPI.Instantiable.Rendering.ItemSpriteSheetRenderer;
import Reika.FurryKingdoms.Auxiliary.FurryRenderList;
import Reika.FurryKingdoms.Registry.FurryItems;
import Reika.FurryKingdoms.Registry.FurryTiles;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;

public class FurryClient extends FurryCommon {

	public static final ItemSpriteSheetRenderer[] items = {
		new ItemSpriteSheetRenderer(FurryKingdoms.instance, FurryKingdoms.class, "Textures/Items/items1.png"),
	};


	@Override
	public void registerSounds() {
		//MinecraftForge.EVENT_BUS.register(new SoundLoader(FurryKingdoms.instance, FurrySounds.soundList, FurrySounds.SOUND_FOLDER));
	}

	@Override
	public void registerRenderers() {
		this.loadModels();

		this.registerSpriteSheets();
	}

	private void registerSpriteSheets() {

		for (int i = 0; i < FurryItems.itemList.length; i++) {
			if (FurryItems.itemList[i].getSpriteIndex() > -1)
				;//MinecraftForgeClient.registerItemRenderer(FurryItems.itemList[i].getItemInstance(), items[FurryItems.itemList[i].getSpriteSheet()]);
		}
	}

	public void loadModels() {
		for (int i = 0; i < FurryTiles.TEList.length; i++) {
			FurryTiles m = FurryTiles.TEList[i];
			if (m.hasRender()) {
				ClientRegistry.bindTileEntitySpecialRenderer(m.getTEClass(), FurryRenderList.instantiateRenderer(m));
			}
		}
	}

	@Override
	public World getClientWorld()
	{
		return FMLClientHandler.instance().getClient().theWorld;
	}

}
