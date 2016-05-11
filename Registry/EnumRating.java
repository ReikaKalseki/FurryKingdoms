/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2016
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms.Registry;

public enum EnumRating {

	G(),
	PG(),
	PG13(),
	R();

	private static final EnumRating[] ratingList = EnumRating.values();

	public static EnumRating getRatingFromIndex(int i) {
		if (i >= ratingList.length)
			return R;
		if (i < 0)
			return G;
		return ratingList[i];
	}
}
