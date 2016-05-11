/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2016
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms.Base;

import Reika.DragonAPI.Base.TileEntityBase;
import Reika.DragonAPI.Base.TileEntityRenderBase;
import Reika.DragonAPI.Interfaces.TextureFetcher;
import Reika.FurryKingdoms.FurryKingdoms;

public abstract class FurryRenderBase extends TileEntityRenderBase implements TextureFetcher {

	@Override
	public final String getTextureFolder() {
		return "/Reika/FurryKingdoms/Textures/TileEntity/";
	}

	@Override
	protected Class getModClass() {
		return FurryKingdoms.class;
	}

	@Override
	protected final boolean doRenderModel(TileEntityBase te) {
		return this.isValidMachineRenderPass(te);
	}

}
