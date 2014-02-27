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

import net.minecraft.util.AxisAlignedBB;
import Reika.DragonAPI.Base.TileEntityBase;
import Reika.DragonAPI.Libraries.ReikaAABBHelper;
import Reika.FurryKingdoms.Registry.FurryBlocks;
import Reika.FurryKingdoms.Registry.FurryTiles;

public abstract class FurryTileEntity extends TileEntityBase {

	@Override
	public final boolean canUpdate() {
		return true;
	}

	@Override
	public final int getTileEntityBlockID() {
		return FurryBlocks.TILEENTITY.getBlockID();
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
}
