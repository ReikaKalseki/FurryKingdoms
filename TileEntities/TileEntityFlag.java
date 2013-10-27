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

import net.minecraft.world.World;
import Reika.FurryKingdoms.Base.FurryTileEntity;

public class TileEntityFlag extends FurryTileEntity {

	public static final float MAXANGLE = 45;

	private float phi1;
	private float phi2;
	private int dir1 = 1;
	private int dir2 = -1;

	@Override
	public void updateEntity(World world, int x, int y, int z, int meta) {

	}

	@Override
	public void animateWithTick(World world, int x, int y, int z) {
		int mult = 1;
		phi1 += rand.nextFloat()*dir1*mult;
		phi2 += rand.nextFloat()*dir2*mult;
		if (phi1 >= MAXANGLE) {
			dir1 = -1;
		}
		if (phi1 <= -MAXANGLE) {
			dir1 = 1;
		}
		if (phi2 >= MAXANGLE) {
			dir2 = -1;
		}
		if (phi2 <= -MAXANGLE) {
			dir2 = 1;
		}
	}
}
