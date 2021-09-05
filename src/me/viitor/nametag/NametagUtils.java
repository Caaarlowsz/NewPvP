package me.viitor.nametag;

import java.util.ArrayList;
 
public class NametagUtils {
	
	public static String formatColors(String str) {
		char[] chars = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f', 'n', 'r', 'l', 'k', 'o', 'm' }; 
        char[] array = str.toCharArray();
        for (int t = 0; t < array.length - 1; t++) {
        	if (array[t] == '&') {
        		for (char c : chars) {
        			if (c == array[(t + 1)]) {
        				array[t] = '§';
        			}
        		}
        	}
        }
        return new String(array);
	}

	public static void box(String[] paragraph, String title) {
		ArrayList<String> buffer = new ArrayList<String>();
        String at = "";
          
        int side1 = (int)Math.round(25.0D - (title.length() + 4) / 2.0D);
        int side2 = (int)(26.0D - (title.length() + 4) / 2.0D);
        at = at + '+';
        for (int t = 0; t < side1; t++) {
        	at = at + '-';
        }
        at = at + "{ ";
        at = at + title;
        at = at + " }";
        for (int t = 0; t < side2; t++) {
        	at = at + '-';
        }
        at = at + '+';
        buffer.add(at);
        at = "";
        buffer.add("|                                                   |");
        for (String s : paragraph) {
        	at = at + "| ";
        	int left = 49;
        	for (int t = 0; t < s.length(); t++) {
        		at = at + s.charAt(t);
        		left--;
        		if (left == 0) {
        			at = at + " |";
        			buffer.add(at);
        			at = "";
        			at = at + "| ";
        			left = 49;
        		}
        	}
        	while (left-- > 0) {
        		at = at + ' ';
        	}
        	at = at + " |";
        	buffer.add(at);
        	at = "";
        }
        buffer.add("|                                                   |");
        buffer.add("+---------------------------------------------------+");
          
        System.out.println(" ");
        for (String line : (String[])buffer.toArray(new String[buffer.size()])) {
        	System.out.println(line);
        }
        System.out.println(" ");
	}
	
	public static String trim(String input) {
       if (input.length() > 16) {
    	   String temp = input;
    	   input = "";
    	   for (int t = 0; t < 16; t++) {
    		   input = input + temp.charAt(t);
    	   }
       }
       return input;
	}

	public static String getValue(String rawValue) {
		
		if ((!rawValue.startsWith("\"")) || (!rawValue.endsWith("\""))) {
			return rawValue;
		}
		rawValue = rawValue.trim();
		String f1 = "";
		for (int t = 1; t < rawValue.length() - 1; t++) {
			f1 = f1 + rawValue.charAt(t);
		}
		return f1;
	}

	public static boolean compareVersion(String old, String newer) {
		ArrayList<Integer> oldValues = new ArrayList<Integer>();
		ArrayList<Integer> newValues = new ArrayList<Integer>();
		String at = "";
		for (char c : old.toCharArray()) {
			if (c != '.') {
				at = at + c;
			} else {
				try {
					oldValues.add(Integer.valueOf(Integer.parseInt(at)));
				} catch (Exception e) {
					return false;
				}
				at = "";
			}
		}
		try {
			oldValues.add(Integer.valueOf(Integer.parseInt(at)));
		} catch (Exception e) {
			return false;
		}
		at = "";
		for (char c : newer.toCharArray()) {
			if (c != '.') {
				at = at + c;
			} else {
				try {
					newValues.add(Integer.valueOf(Integer.parseInt(at)));
				} catch (Exception e) {
					return false;
				}
				at = "";
			}
		}
		try {
			newValues.add(Integer.valueOf(Integer.parseInt(at)));
		} catch (Exception e) {
			return false;
		}
       int size = oldValues.size();
       boolean defaultToOld = true;
       if (newValues.size() < size) {
    	   size = newValues.size();
    	   defaultToOld = false;
       }
       for (int t = 0; t < size; t++) {
    	   if (((Integer)oldValues.get(t)).intValue() < ((Integer)newValues.get(t)).intValue())
	        	 return true;
    	   if (((Integer)oldValues.get(t)).intValue() > ((Integer)newValues.get(t)).intValue()) {
    		   return false;
    	   }
       }
       if (oldValues.size() == newValues.size()) {
    	   return false;
       }
       if (defaultToOld) {
    	   return true;
       }
       return false;
	}
}