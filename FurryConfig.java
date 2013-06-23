/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2013
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.FurryKingdoms;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import net.minecraftforge.common.Configuration;
import Reika.DragonAPI.Libraries.ReikaJavaLibrary;
import Reika.FurryKingdoms.Registry.FurryOptions;
import Reika.RealBiomes.Registry.OptionRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class FurryConfig {

	public static Configuration config;

	/** Change this to cause auto-deletion of users' config files to load new copies */
	private static final int CURRENT_CONFIG_ID = 1;
	private static int readID;
	private static File configFile;
	/*
	public static EnumRating chatRating;
	public static EnumRating storyRating;
	public static EnumRating imageRating;*/

	public static Object[] controls = new Object[OptionRegistry.optionList.length];

	public static void initProps(FMLPreInitializationEvent event) {

		//allocate the file to the config
		configFile = event.getSuggestedConfigurationFile();
		config = new Configuration(configFile);

		//load data
		config.load();

		if (checkReset(config)) {
			ReikaJavaLibrary.pConsole("FURRY KINGDOMS: Config File Format Changed. Resetting...");
			resetConfigFile();
			initProps(event);
			return;
		}

		for (int i = 0; i < FurryOptions.optionList.length; i++) {
			String label = FurryOptions.optionList[i].getLabel();
			if (FurryOptions.optionList[i].isBoolean())
				controls[i] = FurryOptions.optionList[i].setState(config);
			if (FurryOptions.optionList[i].isNumeric())
				controls[i] = FurryOptions.optionList[i].setValue(config);
		}

		/*******************************/
		//save the data
		config.save();
	}

	private static boolean checkReset(Configuration config) {
		readID = config.get("Control", "Config ID - Edit to have your config auto-deleted", CURRENT_CONFIG_ID).getInt();
		return readID != CURRENT_CONFIG_ID;
	}

	private static void resetConfigFile() {
		String path = configFile.getAbsolutePath().substring(0, configFile.getAbsolutePath().length()-4)+"_Old_Config_Backup.txt";
		File backup = new File(path);
		if (backup.exists())
			backup.delete();
		try {
			ReikaJavaLibrary.pConsole("FURRY KINGDOMS: Writing Backup File to "+path);
			ReikaJavaLibrary.pConsole("FURRY KINGDOMS: Use this to restore custom IDs if necessary.");
			backup.createNewFile();
			if (!backup.exists())
				ReikaJavaLibrary.pConsole("FURRY KINGDOMS: Could not create backup file at "+path+"!");
			else {
				PrintWriter p = new PrintWriter(backup);
				p.println("#####----------THESE ARE ALL THE OLD CONFIG SETTINGS YOU WERE USING----------#####");
				p.println("#####---IF THEY DIFFER FROM THE DEFAULTS, YOU MUST RE-EDIT THE CONFIG FILE---#####");



				p.close();
			}
		}
		catch (IOException e) {
			ReikaJavaLibrary.pConsole("FURRY KINGDOMS: Could not create backup file due to IOException!");
			e.printStackTrace();
		}
		configFile.delete();
	}

}
