/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms.GUI;

import Reika.FurryKingdoms.Container.ContainerBodyCustomization;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;

public class GuiBodyCustomization extends GuiContainer {

	public GuiBodyCustomization(EntityPlayer ep) {
		super(new ContainerBodyCustomization(ep));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {

	}

}
