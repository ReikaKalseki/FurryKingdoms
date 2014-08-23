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

import Reika.DragonAPI.ModList;

import java.util.HashMap;

public class SpeciesSpecializations {

	//each species specializes in certain fields (eg redstone/farming...) and possibly certain mods (eg thaum/bc/...)

	private static final HashMap<SpeciesType, Specialization> speciesFields = new HashMap();
	private static final HashMap<SpeciesType, ModList> speciesMods = new HashMap();

	class Specialization {

	}

	public static Specialization getSpeciesSpecialization(SpeciesType species) {
		return speciesFields.get(species);
	}

	public static ModList getSpeciesMod(SpeciesType species) {
		return speciesMods.get(species);
	}

}
