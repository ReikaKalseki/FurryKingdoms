/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms.Entities;

import net.minecraft.world.World;
import Reika.FurryKingdoms.Base.EntityCharacterBase;
import Reika.FurryKingdoms.Registry.SpeciesType;

public class EntityKazdra extends EntityCharacterBase {

	public EntityKazdra(World par1World) {
		super(par1World);
	}

	@Override
	public SpeciesType getSpecies() {
		return SpeciesType.CANINE;
	}
}
