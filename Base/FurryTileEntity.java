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

import Reika.DragonAPI.Base.TileEntityBase;
import Reika.DragonAPI.Libraries.ReikaAABBHelper;
import Reika.FurryKingdoms.Registry.FurryBlocks;
import Reika.FurryKingdoms.Registry.FurryTiles;

import net.minecraft.block.Block;
import net.minecraft.util.AxisAlignedBB;

public abstract class FurryTileEntity extends TileEntityBase {

	@Override
	public final boolean canUpdate() {
		return true;
	}

	@Override
	public final Block getTileEntityBlockID() {
		return FurryBlocks.TILEENTITY.getBlockInstance();
	}

	@Override
	public String getTEName() {
		return FurryTiles.TEList[this.getRealBlockMetadata()].getName();
	}

	@Override
	public boolean shouldRenderInPass(int pass) {
		return pass == 0;
	}

	@Override
	public AxisAlignedBB getRenderBoundingBox()
	{
		return ReikaAABBHelper.getBlockAABB(xCoord, yCoord, zCoord).expand(2, 0, 2);
	}

	@Override
	public int getRedstoneOverride() {
		return 0;
	}
}
