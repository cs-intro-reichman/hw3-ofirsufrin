/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
		public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		int lengthStr1 = str1.length();
		int lengthStr2 = str2.length();
		boolean ans = true;
		if (lengthStr1 != lengthStr2) {
			return false;
		} 
		for (int i = 0; i < lengthStr1; i++) {
			if ((str2.indexOf(str1.charAt(i))) != -1) {
				char x = str1.charAt(i);
				str2 = str2.substring(0, str2.indexOf(x)) + str2.substring(str2.indexOf(x) + 1);
			} else {
				return false;
			}
		}
		
		if (str2.equals("")) {
			return true;
		} else {
			return false;
		}

		} 	
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		str = str.toLowerCase();
		int lengthStr = str.length();
		String abc = "abcdefghijklmnopqrstuvwxyz";
		String newStr = ""; 
		for (int i = 0; i < lengthStr; i++) {
			if (abc.indexOf(str.charAt(i)) > -1) {
				newStr = newStr + str.charAt(i);
			}

		}
		return newStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		int lengthStr = str.length();
		String newWord = "";

		while (lengthStr > 0) {
			int randomChar = (int) (Math.random() * lengthStr);
			newWord = newWord + str.charAt(randomChar);
			str = str.substring(0, randomChar) + str.substring(randomChar + 1, lengthStr);
			lengthStr = str.length();

		}

		return newWord;
	}
}
