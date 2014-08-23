/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms.Base;

import Reika.FurryKingdoms.Registry.SpeciesType;

import net.minecraft.world.biome.BiomeGenBase;

public class CityBiome extends BiomeGenBase {

	private final SpeciesType species;

	public CityBiome(int ID, SpeciesType type) {
		super(ID);
		species = type;
	}

}
