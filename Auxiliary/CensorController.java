/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2013
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms.Auxiliary;

import java.util.ArrayList;
import java.util.HashMap;

import Reika.FurryKingdoms.Registry.EnumRating;

public class CensorController {

	private ArrayList<String> banned = new ArrayList<String>(); //Now to find a way to add swears without having Swearing.class ...
	private HashMap<String, String> replacements = new HashMap<String, String>();

	public final EnumRating rating;

	public CensorController(EnumRating level) {
		rating = level;
	}

	public boolean isStringAllowed(String sg) {
		return !banned.contains(sg);
	}

	public CensorController addBannedString(String sg, String repl) {
		banned.add(sg);
		replacements.put(sg, repl);
		return this;
	}

}
