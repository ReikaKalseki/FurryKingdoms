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

import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;

public abstract class EntityCharacterBase extends EntityLiving {

	public EntityCharacterBase(World par1World) {
		super(par1World);
	}

	@Override
	public int getMaxHealth() {
		return 20;
	}

}
