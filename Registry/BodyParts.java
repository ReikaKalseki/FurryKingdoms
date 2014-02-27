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
import Reika.FurryKingdoms.Base.BodyAddonBase;
import Reika.FurryKingdoms.Models.BodyAddons.ArticulatedTail;
import Reika.FurryKingdoms.Models.BodyAddons.AvianWings;
import Reika.FurryKingdoms.Models.BodyAddons.BushTail;
import Reika.FurryKingdoms.Models.BodyAddons.Claws;
import Reika.FurryKingdoms.Models.BodyAddons.DragonWings;
import Reika.FurryKingdoms.Models.BodyAddons.HeadFin;
import Reika.FurryKingdoms.Models.BodyAddons.SmallEars;
import Reika.FurryKingdoms.Models.BodyAddons.SpikeHorns;
import Reika.FurryKingdoms.Models.BodyAddons.StubHorns;
import Reika.FurryKingdoms.Models.BodyAddons.TallEars;

public enum BodyParts {

	TAIL(ArticulatedTail.class),
	TAILBUSH(BushTail.class),
	TALLEARS(TallEars.class),
	EARS(SmallEars.class),
	CLAWS(Claws.class),
	DRAGONWING(DragonWings.class),
	BIRDWING(AvianWings.class),
	HEADFIN(HeadFin.class),
	STUBHORN(StubHorns.class),
	SPIKEHORN(SpikeHorns.class);

	private Class modelClass;
	private BodyAddonBase model;

	public static final BodyParts[] partList = values();

	private BodyParts(Class<? extends BodyAddonBase> model) {
		modelClass = model;

		try {
			this.model = (BodyAddonBase)modelClass.newInstance();
		}
		catch (InstantiationException e) {
			throw new RegistrationException(FurryKingdoms.instance, "Non-Instantiable Model Class!");
		}
		catch (IllegalAccessException e) {
			throw new RegistrationException(FurryKingdoms.instance, "Private/Protected Model Constructor!");
		}
	}

	public BodyAddonBase getModel() {
		return model;
	}

}
