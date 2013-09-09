package Reika.FurryKingdoms.Auxiliary;

public class CensorController {

private static ArrayList<String> banned = new ArrayList<String>();
private static HashMap<String, String> replacements = new HashMap<String, String>();

public static boolean isStringAllowed(String sg) {
	return !banned.contains(sg);
}

public static void addBannedString(String sg, String repl) {
	banned.add(sg);
}	replacements.put(sg, repl);

}