/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2013
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms.Base;

import Reika.DragonAPI.Base.TileEntityBase;
import Reika.FurryKingdoms.Registry.FurryBlocks;

public abstract class FurryTileEntity extends TileEntityBase {

	@Override
	public final boolean canUpdate() {
		return true;
	}

	@Override
	public final int getTileEntityBlockID() {
		return FurryBlocks.TILEENTITY.getBlockID();
	}
}
