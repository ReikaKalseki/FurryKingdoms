/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2013
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms.TileEntities;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityFlag extends TileEntity {

	@Override
	public boolean canUpdate() {
		return true;
	}

	@Override
	public void updateEntity() {
		World world = worldObj;
		int x = xCoord;
		int y = yCoord;
		int z = zCoord;
		int meta = this.getBlockMetadata();

		this.animate();
	}

	private void animate() {

	}

}
