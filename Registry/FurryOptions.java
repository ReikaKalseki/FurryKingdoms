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

import Reika.DragonAPI.Interfaces.Configuration.BooleanConfig;
import Reika.DragonAPI.Interfaces.Configuration.IntegerConfig;
import Reika.FurryKingdoms.FurryKingdoms;

public enum FurryOptions implements IntegerConfig, BooleanConfig {

	CHATRATING("Chat Rating", EnumRating.PG13.ordinal()),
	STORYRATING("Storyline Rating", EnumRating.PG13.ordinal()),
	IMAGERATING("Image Rating", EnumRating.PG13.ordinal()),
	ENABLEPORTALS("Enable Portals", true),
	ENABLETELEPORT("Enable Teleport", true),
	COMMUNICATIONS("Enable Chat", true),
	UNPROVOKEDATTACK("Enable Unprovoked Attacks", true);

	private String label;
	private boolean defaultState;
	private int defaultValue;
	private Class type;

	public static final FurryOptions[] optionList = FurryOptions.values();

	private FurryOptions(String l, boolean d) {
		label = l;
		defaultState = d;
		type = boolean.class;
	}

	private FurryOptions(String l, int d) {
		label = l;
		defaultValue = d;
		type = int.class;
	}

	public boolean isBoolean() {
		return type == boolean.class;
	}

	public boolean isNumeric() {
		return type == int.class;
	}

	public Class getPropertyType() {
		return type;
	}

	public String getLabel() {
		return label;
	}

	public boolean getState() {
		return (Boolean)FurryKingdoms.config.getControl(this.ordinal());
	}

	public int getValue() {
		return (Integer)FurryKingdoms.config.getControl(this.ordinal());
	}

	public boolean isDummiedOut() {
		return type == null;
	}

	public static EnumRating getChatRating() {
		return EnumRating.values()[CHATRATING.getValue()];
	}

	@Override
	public boolean getDefaultState() {
		return defaultState;
	}

	@Override
	public int getDefaultValue() {
		return defaultValue;
	}

	@Override
	public boolean isEnforcingDefaults() {
		return false;
	}

	@Override
	public boolean shouldLoad() {
		return true;
	}

}
