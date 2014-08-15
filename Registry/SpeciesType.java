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

import Reika.DragonAPI.Exception.RegistrationException;
import Reika.FurryKingdoms.FurryKingdoms;
import Reika.FurryKingdoms.Base.CityBiome;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;

import net.minecraft.world.biome.BiomeGenBase;

public enum SpeciesType {

	DRAGON(60, 0.5F),
	FELINE(30, 0.8F),
	CANINE(30, 0.8F),
	VULPINE(20, 0.9F),
	SHARK(50, 0.3F),
	CETACEAN(50, 0.5F),
	REPTILE(30, 0.6F),
	AVIAN(20, 0.9F),
	EQUES(40, 0.8F);

	private int health;
	private float damageFactor;
	private String name;

	public static final SpeciesType[] speciesList = values();

	private static final HashMap<SpeciesType, BiomeGenBase> cities = new HashMap();

	private SpeciesType(int halfhearts, float dura) {
		health = halfhearts;
		damageFactor = dura;
	}

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

	public int getCityBiomeID() {
		return FurryKingdoms.config.getCityID(this.ordinal());
	}

	public Class getBiomeClass() {
		switch(this) {
		default:
			return CityBiome.class;
		}
	}

	public void addBiome() {
		cities.put(this, this.createBiomeInstance());
	}

	private CityBiome createBiomeInstance() {
		Class b = this.getBiomeClass();
		int id = this.getCityBiomeID();
		Class[] cs = new Class[]{int.class, SpeciesType.class};
		Object[] o = new Object[]{id, this};
		try {
			Constructor c = b.getConstructor(cs);
			return (CityBiome)c.newInstance(o);
		}
		catch (NoSuchMethodException e) {
			throw new RegistrationException(FurryKingdoms.instance, "City biome constructor "+Arrays.toString(cs)+" not found!");
		}
		catch (SecurityException e) {
			throw new RegistrationException(FurryKingdoms.instance, "Security Exception!");
		}
		catch (InstantiationException e) {
			throw new RegistrationException(FurryKingdoms.instance, "Non-Instantiable Class!");
		}
		catch (IllegalAccessException e) {
			throw new RegistrationException(FurryKingdoms.instance, "Private/Protected Constructor!");
		}
		catch (IllegalArgumentException e) {
			throw new RegistrationException(FurryKingdoms.instance, "Invalid Args!");
		}
		catch (InvocationTargetException e) {
			throw new RegistrationException(FurryKingdoms.instance, "Other!");
		}
	}

}