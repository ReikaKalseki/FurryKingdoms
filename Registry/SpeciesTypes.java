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

public enum SpeciesTypes {

	DRAGON(60, 0.5F),
	FELINE(30, 0.8F),
	CANINE(30, 0.8F),
	VULPINE(20, 0.9F),
	SHARK(50, 0.3F),
	CETACEAN(50, 0.5F),
	REPTILE(30, 0.6F),
	AVIAN(20, 0.9F),
	EQUES(40, 0.8F);

	private SpeciesTypes(int halfhearts, float dura) {
		health = halfhearts;
		damageFactor = dura;
		//name = n;
	}

	private int health;
	private float damageFactor;
	private String name;

	public String getSpeciesName() {
		return this.name().substring(0, 1)+this.name().toLowerCase().substring(1);
	}

	public int getMaxHealth() {
		return health;
	}

	public float getHurtability() {
		return damageFactor;
	}

	public boolean canBeAquatic() {
		if (this == CETACEAN)
			return true;
		if (this == SHARK)
			return true;
		if (this == DRAGON)
			return true;
		return false;
	}

	public boolean canBeTerrestrial() {
		return true;
	}

}
