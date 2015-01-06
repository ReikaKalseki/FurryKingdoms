/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2015
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import Reika.FurryKingdoms.Registry.FurryBlocks;
import Reika.FurryKingdoms.Registry.FurryTiles;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabFurry extends CreativeTabs {

	public TabFurry(int position, String tabID) {
		super(position, tabID); //The constructor for your tab
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack() {
		return new ItemStack(FurryBlocks.TILEENTITY.getBlockInstance(), 1, FurryTiles.FLAG.ordinal());
	}

	@Override
	public String getTranslatedTabLabel() {
		return "Furry Kingdoms"; //The name of the tab ingame
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return null;
	}

}
