package me.viitor.nametag;
      
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Scanner;
import org.bukkit.plugin.java.JavaPlugin;
      
      
public class GroupLoader {
       
	@SuppressWarnings("unused")
	private static final String PREFIX = "[NAMETAG CONFIG] ";
	static final boolean DEBUG = true;
        
	public static LinkedHashMap<String, LinkedHashMap<String, String>> Carregar(JavaPlugin Plugin) {
		String folder = "plugins/" + Plugin.getName();
		File folderFile = new File(folder);
		if (!folderFile.exists()) {
			folderFile.mkdir();
		}
		String path = "plugins/" + Plugin.getName() + "/groups.txt";
		File source = new File(path);
		if (source.exists()) {
			return CarregarConfig(source);
		}
		try {
			source.createNewFile();
		} catch (IOException e) {
			Print("Failed to create config file: ");
			e.printStackTrace();
		}
		return CriarConfig(source);
	}
        
	private static LinkedHashMap<String, LinkedHashMap<String, String>> CriarConfig(File target) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(target);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		out.println("// This file declares custom permissions and ties prefixes and suffixes to them.");
		out.println("// Players who possess these permissions will have the prefix and suffix assigned to the given permission.");
		out.println("nametag.group.admin prefix = \"[&cAdmin&f] \"");
		out.println("nametag.group.mod prefix = \"[&bMod&f] \"");
		out.println("nametag.group.member prefix = \"[&eMember&f] \"");
		out.println("nametag.group.swag prefix = \"&eThe &b\"");
		out.println("nametag.group.swag suffix = \" &cSwagmaster\"");
          
		LinkedHashMap<String, LinkedHashMap<String, String>> map = new LinkedHashMap<String, LinkedHashMap<String, String>>();
          
		LinkedHashMap<String, String> admin = new LinkedHashMap<String, String>();
		admin.put("prefix", "[&cAdmin&f] ");
		map.put("nametag.group.admin", admin);
          
		LinkedHashMap<String, String> mod = new LinkedHashMap<String, String>();
		mod.put("prefix", "[&bMod&f] ");
		map.put("nametag.group.mod", mod);
          
		LinkedHashMap<String, String> member = new LinkedHashMap<String, String>();
		member.put("prefix", "[&eMember&f] ");
		map.put("nametag.group.member", member);
        
		LinkedHashMap<String, String> swag = new LinkedHashMap<String, String>();
		swag.put("prefix", "&eThe &b");
		swag.put("suffix", " &cSwagmaster");
		map.put("nametag.group.swag", swag);
          
		out.close();
	          
		return map;
	}
        
	public static LinkedHashMap<String, LinkedHashMap<String, String>> CarregarConfig(File source) {
		Scanner in = null;
		try {
			in = new Scanner(source);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
          
		LinkedHashMap<String, LinkedHashMap<String, String>> map = new LinkedHashMap<String, LinkedHashMap<String, String>>();
          
		boolean syntaxError = false;
          
		while (in.hasNext()) {
			String line = in.nextLine();
			if ((!line.trim().startsWith("//")) && (!line.isEmpty())) {
				syntaxError = CheckWords(line);
				if (syntaxError) {
					Print("Error in syntax, not enough elements on line!");
				}
				
				Scanner lineScanner = new Scanner(line);
              
				String node = lineScanner.next();
				String operation = lineScanner.next();
				String equals = lineScanner.next();
				if (!equals.trim().equals("=")) {
					Print("Error in syntax, \"=\" expected at third element, \"" + equals + "\" given.");
                
					syntaxError = true;
					break;
				}
				String rawValue = lineScanner.nextLine();
				syntaxError = CheckValue(rawValue);
				if (syntaxError) {
					Print("Error in syntax, value not encased in quotation marks!");
					break;
				}
				String value = PegarValue(rawValue);
					
				LinkedHashMap<String, String> entry = new LinkedHashMap<String, String>();
				
				if (map.get(node) != null) {
					entry = (LinkedHashMap<String, String>)map.get(node);
				}
              
				entry.put(operation.toLowerCase(), value);
				
				if (map.get(node) == null) {
					map.put(node, entry);
				}
				lineScanner.close();
			}
		}	
		in.close();
          
		if (syntaxError) {
			return new LinkedHashMap<String, LinkedHashMap<String, String>>();
		}
		return map;
	}
      
	private static void Print(String Jogador) {
		System.out.println("[NAMETAG CONFIG] " + Jogador);
	}

	@SuppressWarnings("unused")
	private static void PrintDebug(String Jogador) {
		System.out.println("[NAMETAG CONFIG] " + Jogador);
	}
        
	private static boolean CheckWords(String line) {
		int count = 0;
		Scanner reader = new Scanner(line);
		while (reader.hasNext()) {
			count++;
			reader.next();
		}
		reader.close();
		if (count >= 4) {
			return false;
		}
		return true;
	}
        
	private static boolean CheckValue(String rawValue) {
		rawValue = rawValue.trim();
		if (!rawValue.startsWith("\"")) {
			return true;
		}
		if (!rawValue.endsWith("\"")) {
			return true;
		}
		return false;
	}
        
	private static String PegarValue(String rawValue) {
		rawValue = rawValue.trim();
		String f1 = "";
		String f2 = "";
		for (int t = 1; t < rawValue.length() - 1; t++) {
			f1 = f1 + rawValue.charAt(t);
		}
		for (int t = 0; (t < f1.length()) && (t < 16); t++) {
			f2 = f2 + f1.charAt(t);
		}
		return f2;
	}
}