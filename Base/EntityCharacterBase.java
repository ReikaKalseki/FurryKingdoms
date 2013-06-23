package Reika.FurryKingdoms.Base;

import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;

public abstract class EntityCharacterBase extends EntityLiving {

	public EntityCharacterBase(World par1World) {
		super(par1World);
	}

	@Override
	public int getMaxHealth() {
		return 20;
	}

}
