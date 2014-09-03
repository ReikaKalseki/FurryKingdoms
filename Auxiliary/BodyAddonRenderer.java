/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms.Auxiliary;

import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import Reika.FurryKingdoms.Registry.BodyParts;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BodyAddonRenderer {

	public static final BodyAddonRenderer instance = new BodyAddonRenderer();

	private BodyAddonRenderer() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void addPlayerPieces(RenderPlayerEvent.Pre evt) {
		EntityPlayer ep = evt.entityPlayer;
		RenderPlayer render = evt.renderer;
		for (int i = 0; i < BodyParts.partList.length; i++) {
			if (this.hasAddon(ep, BodyParts.partList[i]))
				this.renderAddon(BodyParts.partList[i]);
		}
	}

	private void renderAddon(BodyParts part) {

	}

	public boolean hasAddons(EntityPlayer ep) {
		for (int i = 0; i < BodyParts.partList.length; i++) {
			if (this.hasAddon(ep, BodyParts.partList[i]))
				return true;
		}
		return false;
	}

	// need a special inventory like other mods do
	public boolean hasAddon(EntityPlayer ep, BodyParts part) {
		return false;
	}

}
