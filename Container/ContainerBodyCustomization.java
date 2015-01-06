/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2015
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerBodyCustomization extends Container {

	private final EntityPlayer ep;

	public ContainerBodyCustomization(EntityPlayer player) {
		super();
		ep = player;
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return false;
	}

}
