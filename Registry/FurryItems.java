/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms.Registry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import Reika.DragonAPI.Interfaces.RegistryEnum;
import Reika.DragonAPI.Libraries.Java.ReikaStringParser;
import Reika.FurryKingdoms.FurryKingdoms;
import Reika.FurryKingdoms.Base.ItemFurryBasic;

public enum FurryItems implements RegistryEnum {

	FLAG(0, "", ItemFurryBasic.class);

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
		return new ItemStack(this.getShiftedItemID(), 1, 0);
	}

	public ItemStack getStackOfMetadata(int meta) {
		return new ItemStack(this.getShiftedItemID(), 1, meta);
	}

	@Override
	public Class[] getConstructorParamTypes() {
		return new Class[]{int.class};
	}

	@Override
	public Object[] getConstructorParams() {
		return new Object[]{this.getItemID()};
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

	public int getItemID() {
		return FurryKingdoms.config.getItemID(this.ordinal());
	}

	public int getShiftedItemID() {
		return FurryKingdoms.config.getItemID(this.ordinal())+256;
	}

	@Override
	public Class<? extends ItemBlock> getItemBlock() {
		return null;
	}

	@Override
	public boolean hasItemBlock() {
		return false;
	}

	@Override
	public String getConfigName() {
		return this.getBasicName();
	}

	@Override
	public int getDefaultID() {
		return 23000+this.ordinal();
	}

	@Override
	public boolean isBlock() {
		return false;
	}

	@Override
	public boolean isItem() {
		return true;
	}

	@Override
	public String getCategory() {
		return "Item IDs";
	}

	public boolean isDummiedOut() {
		return itemClass == null;
	}

	public int getID() {
		return this.getItemID();
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
