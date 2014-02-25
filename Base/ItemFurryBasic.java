package Reika.FurryKingdoms.Base;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import Reika.DragonAPI.Interfaces.IndexedItemSprites;

public class ItemFurryBasic extends Item implements IndexedItemSprites {

	public ItemFurryBasic(int par1) {
		super(par1);
	}

	@Override
	public int getItemSpriteIndex(ItemStack is) {
		return 0;
	}

	@Override
	public String getTexture(ItemStack is) {
		return null;
	}

	@Override
	public Class getTextureReferenceClass() {
		return null;
	}

}
