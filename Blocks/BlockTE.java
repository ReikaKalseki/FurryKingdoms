/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms.Blocks;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import Reika.DragonAPI.Libraries.ReikaAABBHelper;
import Reika.DragonAPI.Libraries.Registry.ReikaItemHelper;
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

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer ep, int par6, float par7, float par8, float par9) {
		ep.openGui(FurryKingdoms.instance, 0, world, x, y, z);
		return super.onBlockActivated(world, x, y, z, ep, par6, par7, par8, par9);
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition vec, World world, int x, int y, int z) {
		return super.getPickBlock(vec, world, x, y, z);
	}

	@Override
	public final void breakBlock(World world, int x, int y, int z, int par5, int par6) {
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if (te instanceof IInventory)
			ReikaItemHelper.dropInventory(world, x, y, z);
		super.breakBlock(world, x, y, z, par5, par6);
	}

	@Override
	public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int meta, int fortune) {
		return super.getBlockDropped(world, x, y, z, meta, fortune);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		if (world.getBlockMetadata(x, y, z) == 0)
			return ReikaAABBHelper.getBlockAABB(x, y, z).contract(0.4375, 0, 0.4375);
		return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}

	@Override
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
		if (world.getBlockMetadata(x, y, z) == 0)
			return ReikaAABBHelper.getBlockAABB(x, y, z).contract(0.4375, 0, 0.4375);
		return super.getSelectedBoundingBoxFromPool(world, x, y, z);
	}


}
