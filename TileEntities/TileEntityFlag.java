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

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import Reika.FurryKingdoms.Base.FurryTileEntity;

public class TileEntityFlag extends FurryTileEntity {

	public static final float MAXANGLE = 45;

	//need some variable to control internal flag type

	public float[] offsets = {0F, 0.0625F, 0.125F, 0.0625F, 0F, -0.0625F, -0.125F, -0.0625F};
	private boolean[] sides = {true, true, false, false, false, false, true, true};

	@Override
	public void updateEntity(World world, int x, int y, int z, int meta) {

	}

	@Override
	public void animateWithTick(World world, int x, int y, int z) {
		float f = 0.0625F;
		for (int i = 0; i < offsets.length; i++) {
			if (sides[i]) {
				offsets[i] += f;
				if (offsets[i] >= 0.125F)
					sides[i] = false;
			}
			else {
				offsets[i] -= f;
				if (offsets[i] <= -0.125F)
					sides[i] = true;
			}
		}
	}

	public Icon getRootTexture() {
		return Block.cloth.getIcon(0, 0);
	}

	public Icon getEndTexture() {
		return Block.bedrock.getIcon(0, 0);
	}

	@Override
	public void writeToNBT(NBTTagCompound NBT)
	{
		super.writeToNBT(NBT);

	}

	@Override
	public void readFromNBT(NBTTagCompound NBT)
	{
		super.readFromNBT(NBT);


	}
}
