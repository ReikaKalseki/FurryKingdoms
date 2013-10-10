/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2013
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms.Registry;

import java.util.HashMap;

import Reika.DragonAPI.Auxiliary.ModList;

public class SpeciesSpecializations {

	//each species specializes in certain fields (eg redstone/farming...) and possibly certain mods (eg thaum/bc/...)

	private static final HashMap<SpeciesTypes, Specialization> speciesFields = new HashMap();
	private static final HashMap<SpeciesTypes, ModList> speciesMods = new HashMap();

	class Specialization {

	}

	public static Specialization getSpeciesSpecialization(SpeciesTypes species) {
		return speciesFields.get(species);
	}

	public static ModList getSpeciesMod(SpeciesTypes species) {
		return speciesMods.get(species);
	}

}
