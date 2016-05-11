/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2016
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import Reika.FurryKingdoms.Base.ItemFurryBasic;

public class ItemFlag extends ItemFurryBasic {

	public ItemFlag(int index) {
		super(index);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer ep) {
		if (is.stackTagCompound == null)
			is.stackTagCompound = new NBTTagCompound();
		int a = ep.isSneaking() ? -1 : 1;
		int img = is.stackTagCompound.getInteger("img")+a;
		is.stackTagCompound.setInteger("img", img);
		return is;
	}

	@Override
	public void addInformation(ItemStack is, EntityPlayer ep, List li, boolean v) {
		if (is.stackTagCompound != null) {
			li.add(String.format("Design %d", is.stackTagCompound.getInteger("img")));
		}
	}

}
