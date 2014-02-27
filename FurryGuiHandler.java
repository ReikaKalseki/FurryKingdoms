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

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import Reika.DragonAPI.Base.OneSlotContainer;
import Reika.FurryKingdoms.Base.FurryTileEntity;
import Reika.FurryKingdoms.Base.GuiOneSlotInv;
import Reika.FurryKingdoms.TileEntities.TileEntityFlag;
import cpw.mods.fml.common.network.IGuiHandler;

public class FurryGuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if (te instanceof TileEntityFlag) {
			return new OneSlotContainer(player, te);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if (te instanceof TileEntityFlag) {
			return new GuiOneSlotInv(player, (FurryTileEntity)te);
		}
		return null;
	}

}
