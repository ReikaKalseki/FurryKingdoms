/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms.Base;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;

import org.lwjgl.opengl.GL11;

import Reika.DragonAPI.Base.OneSlotContainer;
import Reika.DragonAPI.Libraries.IO.ReikaTextureHelper;
import Reika.FurryKingdoms.FurryKingdoms;

public class GuiOneSlotInv extends GuiContainer {

	protected IInventory iinv;
	EntityPlayer ep;
	public GuiOneSlotInv(EntityPlayer pl, FurryTileEntity te) {
		super(new OneSlotContainer(pl, te));
		iinv = (IInventory)te;
		xSize = 176;
		ySize = 166;
		ep = pl;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		int j = (width - xSize) / 2;
		int k = (height - ySize) / 2;

		String i = "/Reika/FurryKingdoms/Textures/GUI/oneslotgui.png";
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		ReikaTextureHelper.bindTexture(FurryKingdoms.class, i);
		this.drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
	}

}
