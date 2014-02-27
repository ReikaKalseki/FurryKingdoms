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

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import Reika.DragonAPI.Interfaces.RegistryEnum;
import Reika.DragonAPI.Libraries.Java.ReikaStringParser;
import Reika.FurryKingdoms.FurryKingdoms;
import Reika.FurryKingdoms.Blocks.BlockTE;

public enum FurryBlocks implements RegistryEnum {

	TILEENTITY(BlockTE.class);

	private Class blockClass;

	public static final FurryBlocks[] blockList = FurryBlocks.values();

	private FurryBlocks(Class<? extends Block> cl) {
		blockClass = cl;
	}

	@Override
	public String getConfigName() {
		return this.getBasicName();
	}

	@Override
	public int getDefaultID() {
		return 2000+this.ordinal();
	}

	@Override
	public boolean isBlock() {
		return true;
	}

	@Override
	public boolean isItem() {
		return false;
	}

	@Override
	public String getCategory() {
		return "Block IDs";
	}

	@Override
	public Class[] getConstructorParamTypes() {
		return new Class[]{int.class, Material.class};
	}

	@Override
	public Object[] getConstructorParams() {
		return new Object[]{this.getBlockID(), this.getBlockMaterial()};
	}

	public Material getBlockMaterial() {
		return Material.ground;
	}

	public int getBlockID() {
		return FurryKingdoms.config.getBlockID(this.ordinal());
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

	public int getID() {
		return this.getBlockID();
	}

	@Override
	public boolean overwritingItem() {
		return false;
	}

	public String getBlockVariableName() {
		return this.getBasicName();
	}

}
