/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms.Auxiliary;

import Reika.FurryKingdoms.Registry.EnumRating;
import Reika.FurryKingdoms.Registry.FurryOptions;

import java.util.ArrayList;
import java.util.HashMap;

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

	public enum Expressions {
		NULL("", "", "", "");

		private final String gRated;
		private final String pgRated;
		private final String pg13Rated;
		private final String rRated;

		private Expressions(String G, String PG, String PG13, String R) {
			gRated = G;
			pg13Rated = PG13;
			pgRated = PG;
			rRated = R;
		}

		public String getExpression() {
			switch(FurryOptions.getChatRating()) {
			case G:
				return gRated;
			case PG:
				return pgRated;
			case PG13:
				return pg13Rated;
			case R:
				return rRated;
			}
			Thread.dumpStack();
			return "[INVALID STRING]";
		}
	}

}