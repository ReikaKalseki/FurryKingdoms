/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2013
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import Reika.FurryKingdoms.FurryKingdoms;
import Reika.FurryKingdoms.Registry.FurryTiles;

public class BlockTE extends Block {

	public BlockTE(int ID, Material mat) {
		super(ID, mat);
		this.setCreativeTab(FurryKingdoms.tab);
	}

	@Override
	public TileEntity createTileEntity(World world, int meta) {
		return FurryTiles.createTEFromMetadata(meta);
	}

	@Override
	public boolean hasTileEntity(int meta) {
		return true;
	}

}
