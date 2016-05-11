/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2016
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms.Renders;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import Reika.DragonAPI.Interfaces.TileEntity.RenderFetcher;
import Reika.DragonAPI.Libraries.IO.ReikaTextureHelper;
import Reika.FurryKingdoms.FurryKingdoms;
import Reika.FurryKingdoms.Base.FurryRenderBase;
import Reika.FurryKingdoms.TileEntities.TileEntityFlag;

public class RenderFlag extends FurryRenderBase {

	@Override
	public void renderTileEntityAt(TileEntity tile, double par2, double par4, double par6, float par8) {
		TileEntityFlag te = (TileEntityFlag)tile;

		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glTranslatef((float)par2, (float)par4 + 2.0F, (float)par6 + 1.0F);
		GL11.glScalef(1.0F, -1.0F, -1.0F);
		GL11.glTranslatef(0.5F, 1F, 0.5F);
		Tessellator v5 = Tessellator.instance;
		v5.startDrawingQuads();
		v5.setNormal(0, -1, 0);
		v5.setColorOpaque(255, 255, 255);

		if (te.hasValidFlag()) {
			float u = 0;
			float v = 0;
			float du = 0.5F;
			float dv = 1;
			float dd = du-u;
			if (te.isFlagWhite()) {
				ReikaTextureHelper.bindTerrainTexture();
				IIcon ico = Blocks.wool.getIcon(0, 0);
				u = ico.getMinU();
				v = ico.getMinV();
				du = ico.getMaxU();
				dv = ico.getMaxV();
				dd = du-u;
				du = u;
			}
			else {
				ReikaTextureHelper.bindTexture(FurryKingdoms.class, te.getFlagTexture());
			}

			for (int i = 0; i < 4; i++) {
				float d = i*0.25F;
				float d1 = (i+1)*0.25F;
				float t = d*dd;
				float t1 = d1*dd;
				double f = i == 0 ? 0 : te.offsets[i];
				double f1 = te.offsets[i+1];

				v5.addVertexWithUV(d, 0, f, u+t, v);
				v5.addVertexWithUV(d1, 0, f1, u+t1, v);
				v5.addVertexWithUV(d1, 1, f1, u+t1, dv);
				v5.addVertexWithUV(d, 1, f, u+t, dv);

				v5.addVertexWithUV(d, 1, f, u+t, dv);
				v5.addVertexWithUV(d1, 1, f1, u+t1, dv);
				v5.addVertexWithUV(d1, 0, f1, u+t1, v);
				v5.addVertexWithUV(d, 0, f, u+t, v);

				f = te.offsets[4+i];
				f1 = i == 3 ? te.offsets[0] : te.offsets[4+i+1];

				v5.addVertexWithUV(d+1, 0, f, du+t, v);
				v5.addVertexWithUV(d1+1, 0, f1, du+t1, v);
				v5.addVertexWithUV(d1+1, 1, f1, du+t1, dv);
				v5.addVertexWithUV(d+1, 1, f, du+t, dv);

				v5.addVertexWithUV(d+1, 1, f, du+t, dv);
				v5.addVertexWithUV(d1+1, 1, f1, du+t1, dv);
				v5.addVertexWithUV(d1+1, 0, f1, du+t1, v);
				v5.addVertexWithUV(d+1, 0, f, du+t, v);
			}
		}

		v5.draw();
		v5.startDrawingQuads();
		v5.setNormal(0, -1, 0);
		v5.setColorOpaque(255, 255, 255);
		ReikaTextureHelper.bindTerrainTexture();
		IIcon ico = Blocks.iron_block.getIcon(0, 0);
		float u = ico.getMinU();
		float v = ico.getMinV();
		float du = ico.getMaxU();
		float dv = ico.getMaxV();

		double s = 0.0625;

		v5.setColorOpaque(255, 255, 255);
		v5.addVertexWithUV(-s, 0, -s, u, v);
		v5.addVertexWithUV(s, 0, -s, du, v);
		v5.addVertexWithUV(s, 0, s, du, dv);
		v5.addVertexWithUV(-s, 0, s, u, dv);

		v5.setColorOpaque(127, 127, 127);
		v5.addVertexWithUV(-s, 1, s, u, dv);
		v5.addVertexWithUV(s, 1, s, du, dv);
		v5.addVertexWithUV(s, 1, -s, du, v);
		v5.addVertexWithUV(-s, 1, -s, u, v);

		v5.setColorOpaque(192, 192, 192);
		v5.addVertexWithUV(-s, 1, -s, u, dv);
		v5.addVertexWithUV(s, 1, -s, du, dv);
		v5.addVertexWithUV(s, 0, -s, du, v);
		v5.addVertexWithUV(-s, 0, -s, u, v);

		v5.addVertexWithUV(-s, 0, s, u, v);
		v5.addVertexWithUV(s, 0, s, du, v);
		v5.addVertexWithUV(s, 1, s, du, dv);
		v5.addVertexWithUV(-s, 1, s, u, dv);

		v5.setColorOpaque(222, 222, 222);
		v5.addVertexWithUV(s, 1, -s, u, dv);
		v5.addVertexWithUV(s, 1, s, du, dv);
		v5.addVertexWithUV(s, 0, s, du, v);
		v5.addVertexWithUV(s, 0, -s, u, v);

		v5.addVertexWithUV(-s, 0, -s, u, v);
		v5.addVertexWithUV(-s, 0, s, du, v);
		v5.addVertexWithUV(-s, 1, s, du, dv);
		v5.addVertexWithUV(-s, 1, -s, u, dv);

		v5.draw();
		GL11.glPopMatrix();
	}

	@Override
	public String getImageFileName(RenderFetcher te) {
		return "";
	}

}
