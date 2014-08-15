/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms.TileEntities;

import Reika.FurryKingdoms.Base.InventoriedFurryTileEntity;
import Reika.FurryKingdoms.Registry.FurryItems;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TileEntityFlag extends InventoriedFurryTileEntity {

	public static final float MAXANGLE = 45;

	public float[] offsets = {0F, 0.0625F, 0.125F, 0.0625F, 0F, -0.0625F, -0.125F, -0.0625F};
	private boolean[] sides = {true, true, false, false, false, false, true, true};

	@Override
	public void updateEntity(World world, int x, int y, int z, int meta) {

	}

	@Override
	protected void animateWithTick(World world, int x, int y, int z) {
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

	public String getFlagTexture() {
		return "Textures/Misc/flag_"+inv[0].stackTagCompound.getInteger("img")+".png";
	}

	public boolean isFlagWhite() {
		return inv[0].stackTagCompound == null || !inv[0].stackTagCompound.hasKey("img");
	}

	public boolean hasValidFlag() {
		return inv[0] != null && inv[0].getItem() == FurryItems.FLAG.getItemInstance();
	}

	@Override
	public boolean canExtractItem(int i, ItemStack is, int j) {
		return false;
	}

	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack is) {
		return false;
	}
}