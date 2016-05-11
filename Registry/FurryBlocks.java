/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2016
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms.Registry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import Reika.DragonAPI.Interfaces.Registry.BlockEnum;
import Reika.DragonAPI.Libraries.Java.ReikaStringParser;
import Reika.FurryKingdoms.FurryKingdoms;
import Reika.FurryKingdoms.Blocks.BlockTE;

public enum FurryBlocks implements BlockEnum {

	TILEENTITY(BlockTE.class);

	private Class blockClass;

	public static final FurryBlocks[] blockList = FurryBlocks.values();

	private FurryBlocks(Class<? extends Block> cl) {
		blockClass = cl;
	}

	@Override
	public Class[] getConstructorParamTypes() {
		return new Class[]{Material.class};
	}

	@Override
	public Object[] getConstructorParams() {
		return new Object[]{this.getBlockMaterial()};
	}

	public Material getBlockMaterial() {
		return Material.ground;
	}

	public Block getBlockInstance() {
		return FurryKingdoms.blocks[this.ordinal()];
	}

	@Override
	public String getUnlocalizedName() {
		return ReikaStringParser.stripSpaces(this.getBasicName());
	}

	@Override
	public Class getObjectClass() {
		return blockClass;
	}

	@Override
	public String getBasicName() {
		return ReikaStringParser.capFirstChar(this.name());
	}

	@Override
	public String getMultiValuedName(int meta) {
		return null;
	}

	@Override
	public boolean hasMultiValuedName() {
		return false;
	}

	@Override
	public int getNumberMetadatas() {
		return 1;
	}

	@Override
	public Class<? extends ItemBlock> getItemBlock() {
		return null;
	}

	@Override
	public boolean hasItemBlock() {
		return false;
	}

	public boolean isDummiedOut() {
		return blockClass == null;
	}

	public String getBlockInstanceName() {
		return this.getBasicName();
	}

	public Item getItem() {
		return Item.getItemFromBlock(this.getBlockInstance());
	}

	@Override
	public ItemStack getStackOfMetadata(int meta) {
		return new ItemStack(this.getBlockInstance(), 1, meta);
	}

}
