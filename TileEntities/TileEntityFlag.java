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
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import Reika.FurryKingdoms.Base.InventoriedFurryTileEntity;
import Reika.FurryKingdoms.Registry.FurryItems;

public class TileEntityFlag extends InventoriedFurryTileEntity {

	public static final float MAXANGLE = 45;

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

	public boolean hasValidFlag() {
		return inv[0] != null && inv[0].itemID == FurryItems.FLAG.getShiftedItemID();
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
