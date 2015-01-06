/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2015
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms.Registry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import Reika.DragonAPI.Interfaces.ItemEnum;
import Reika.DragonAPI.Libraries.Java.ReikaStringParser;
import Reika.FurryKingdoms.FurryKingdoms;
import Reika.FurryKingdoms.ItemFlag;

public enum FurryItems implements ItemEnum {

	FLAG(0, "Items.furryflag", ItemFlag.class);

	private String name;
	private Class itemClass;
	private int index;

	public static final FurryItems[] itemList = FurryItems.values();

	private FurryItems(int index, String n, Class<? extends Item> cl) {
		name = n;
		itemClass = cl;
		this.index = index;
	}

	public ItemStack getStackOf() {
		return new ItemStack(this.getItemInstance(), 1, 0);
	}

	public ItemStack getStackOfMetadata(int meta) {
		return new ItemStack(this.getItemInstance(), 1, meta);
	}

	@Override
	public Class[] getConstructorParamTypes() {
		return new Class[]{int.class};
	}

	@Override
	public Object[] getConstructorParams() {
		return new Object[]{this.getSpriteIndex()};
	}

	@Override
	public String getUnlocalizedName() {
		return ReikaStringParser.stripSpaces(name);
	}

	@Override
	public Class getObjectClass() {
		return itemClass;
	}

	@Override
	public String getBasicName() {
		return name;
	}

	@Override
	public String getMultiValuedName(int meta) {
		return this.getBasicName();
	}

	@Override
	public boolean hasMultiValuedName() {
		return false;
	}

	@Override
	public int getNumberMetadatas() {
		return 1;
	}

	public Item getItemInstance() {
		return FurryKingdoms.items[this.ordinal()];
	}

	public boolean isDummiedOut() {
		return itemClass == null;
	}

	@Override
	public boolean overwritingItem() {
		return false;
	}

	public int getSpriteIndex() {
		return index;
	}

	public int getSpriteSheet() {
		return index/256;
	}

}
