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

import Reika.DragonAPI.Interfaces.RenderFetcher;
import Reika.DragonAPI.Libraries.Java.ReikaJavaLibrary;
import Reika.FurryKingdoms.Base.FurryRenderBase;
import Reika.FurryKingdoms.Registry.FurryTiles;

import java.util.HashMap;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class FurryRenderList {

	private static HashMap<FurryTiles, FurryRenderBase> renders = new HashMap<FurryTiles, FurryRenderBase>();
	private static HashMap<FurryTiles, FurryTiles> overrides = new HashMap<FurryTiles, FurryTiles>();

	public static boolean addRender(FurryTiles m, FurryRenderBase r) {
		if (!renders.containsValue(r)) {
			renders.put(m, r);
			return true;
		}
		else {
			FurryTiles parent = ReikaJavaLibrary.getHashMapKeyByValue(renders, r);
			overrides.put(m, parent);
			return false;
		}
	}

	public static FurryRenderBase getRenderForMachine(FurryTiles m) {
		if (overrides.containsKey(m))
			return renders.get(overrides.get(m));
		return renders.get(m);
	}

	public static String getRenderTexture(FurryTiles m, RenderFetcher te) {
		return getRenderForMachine(m).getImageFileName(te);
	}

	public static TileEntitySpecialRenderer instantiateRenderer(FurryTiles m) {
		try {
			FurryRenderBase r = (FurryRenderBase)Class.forName(m.getRenderer()).newInstance();
			if (addRender(m, r))
				return r;
			else
				return renders.get(overrides.get(m));
		}
		catch (InstantiationException e) {
			e.printStackTrace();
			throw new RuntimeException("Tried to call nonexistent render "+m.getRenderer()+"!");
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("Tried to call illegal render "+m.getRenderer()+"!");
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("No class found for Renderer "+m.getRenderer()+"!");
		}
	}

}