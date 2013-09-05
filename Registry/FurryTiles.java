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

import net.minecraft.tileentity.TileEntity;
import Reika.DragonAPI.Exception.RegistrationException;
import Reika.FurryKingdoms.FurryKingdoms;
import Reika.FurryKingdoms.TileEntities.TileEntityFlag;

public enum FurryTiles {

	FLAG("Flag", TileEntityFlag.class);

	private Class te;
	private String name;

	public static final FurryTiles[] TEList = FurryTiles.values();

	private FurryTiles(String n, Class<? extends TileEntity> cl) {
		te = cl;
		name = n;
	}

	public static TileEntity createTEFromMetadata(int meta) {
		Class TEClass = TEList[meta].te;
		try {
			return (TileEntity)TEClass.newInstance();
		}
		catch (InstantiationException e) {
			e.printStackTrace();
			throw new RegistrationException(FurryKingdoms.instance, "Metadata "+meta+" failed to instantiate its TileEntity of "+TEClass);
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new RegistrationException(FurryKingdoms.instance, "Metadata "+meta+" failed illegally accessed its TileEntity of "+TEClass);
		}
	}

	public Class<? extends TileEntity> getTEClass() {
		return te;
	}

	public String getName() {
		return name;
	}

}
