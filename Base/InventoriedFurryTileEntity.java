/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2013
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms.Base;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import Reika.DragonAPI.Libraries.ReikaInventoryHelper;

public abstract class InventoriedFurryTileEntity extends FurryTileEntity implements ISidedInventory {

	protected ItemStack[] inv = new ItemStack[this.getSizeInventory()];

	public final ItemStack getStackInSlot(int i) {
		return inv[i];
	}

	public final void setInventorySlotContents(int i, ItemStack is) {
		inv[i] = is;
	}

	@Override
	public final ItemStack decrStackSize(int i, int j) {
		return ReikaInventoryHelper.decrStackSize(this, i, j);
	}

	@Override
	public final ItemStack getStackInSlotOnClosing(int i) {
		return ReikaInventoryHelper.getStackInSlotOnClosing(this, i);
	}

	@Override
	public final String getInvName() {
		return this.getTEName();
	}

	@Override
	public final boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer ep) {
		return this.isStandard8mReach(ep, this);
	}

	@Override
	public void openChest() {

	}

	@Override
	public void closeChest() {

	}

	@Override
	public final int[] getAccessibleSlotsFromSide(int var1) {
		return ReikaInventoryHelper.getWholeInventoryForISided(this);
	}

	@Override
	public final boolean canInsertItem(int i, ItemStack is, int j) {
		return ((IInventory)this).isItemValidForSlot(i, is);
	}

	@Override
	public void readFromNBT(NBTTagCompound NBT)
	{
		super.readFromNBT(NBT);
		NBTTagList nbttaglist = NBT.getTagList("Items");
		inv = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); i++)
		{
			NBTTagCompound nbttagcompound = (NBTTagCompound)nbttaglist.tagAt(i);
			byte byte0 = nbttagcompound.getByte("Slot");

			if (byte0 >= 0 && byte0 < inv.length)
			{
				inv[byte0] = ItemStack.loadItemStackFromNBT(nbttagcompound);
			}
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound NBT)
	{
		super.writeToNBT(NBT);
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < inv.length; i++)
		{
			if (inv[i] != null)
			{
				NBTTagCompound nbttagcompound = new NBTTagCompound();
				nbttagcompound.setByte("Slot", (byte)i);
				inv[i].writeToNBT(nbttagcompound);
				nbttaglist.appendTag(nbttagcompound);
			}
		}

		NBT.setTag("Items", nbttaglist);
	}


}
