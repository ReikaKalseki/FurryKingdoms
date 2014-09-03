/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms.Base;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import Reika.DragonAPI.Interfaces.IndexedItemSprites;
import Reika.FurryKingdoms.FurryKingdoms;

public class ItemFurryBasic extends Item implements IndexedItemSprites {

	private int texIndex;

	public ItemFurryBasic(int index) {
		super();
		this.setCreativeTab(FurryKingdoms.tab);
	}

	@Override
	public int getItemSpriteIndex(ItemStack is) {
		return texIndex;
	}

	@Override
	public String getTexture(ItemStack is) {
		return "Textures/Items/items.png";
	}

	@Override
	public Class getTextureReferenceClass() {
		return FurryKingdoms.class;
	}

}
