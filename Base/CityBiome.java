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

import net.minecraft.world.biome.BiomeGenBase;
import Reika.FurryKingdoms.Registry.SpeciesType;

public class CityBiome extends BiomeGenBase {

	private final SpeciesType species;

	public CityBiome(int ID, SpeciesType type) {
		super(ID);
		species = type;
	}

}
