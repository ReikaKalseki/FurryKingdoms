/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2013
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms.Entities;

import net.minecraft.world.World;
import Reika.FurryKingdoms.Base.EntityCharacterBase;
import Reika.FurryKingdoms.Registry.SpeciesTypes;

public class EntityHexerade extends EntityCharacterBase {

	public EntityHexerade(World par1World) {
		super(par1World);
	}

	@Override
	public SpeciesTypes getSpecies() {
		return SpeciesTypes.FELINE;
	}
}
