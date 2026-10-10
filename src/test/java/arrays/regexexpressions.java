package arrays;

public class regexexpressions {

	public static void main(String[] args) {
		
		String a = "bscwbcb21313$^%$wdbbsbGAYHGSG%^*&%%&*&";
		
		String b = a.replaceAll("[^a-zA-Z]", "");
		
		System.out.println(b);

		// 1. Keep only English letters: ^ inside [] means NOT.
		String text = "Hello123@World!";
		System.out.println("Only letters: " + text.replaceAll("[^a-zA-Z]", ""));
		// Expected: Only letters: HelloWorld

		// 2. Keep only digits.
		text = "Price: Rs.1500!";
		System.out.println("Only digits: " + text.replaceAll("[^0-9]", ""));
		// Expected: Only digits: 1500

		// 3. Keep letters and digits.
		text = "Java@123#Code!";
		System.out.println("Letters and digits: " + text.replaceAll("[^a-zA-Z0-9]", ""));
		// Expected: Letters and digits: Java123Code

		// 4. Keep letters and spaces; both original spaces remain.
		text = "Hello 123 World@!";
		System.out.println("Letters and spaces: " + text.replaceAll("[^a-zA-Z ]", ""));
		// Expected: Letters and spaces: Hello  World

		// 5. Keep only lowercase letters.
		text = "HelloWORLD123!";
		System.out.println("Lowercase letters: " + text.replaceAll("[^a-z]", ""));
		// Expected: Lowercase letters: ello

		// 6. Keep only uppercase letters.
		System.out.println("Uppercase letters: " + text.replaceAll("[^A-Z]", ""));
		// Expected: Uppercase letters: HWORLD

		// 7. Without ^, remove the listed characters (English letters).
		text = "Hello123@World!";
		System.out.println("Remove letters: " + text.replaceAll("[a-zA-Z]", ""));
		// Expected: Remove letters: 123@!

		// 8. Replace each non-letter with an underscore.
		text = "Java123@Code";
		System.out.println("Replace each non-letter: " + text.replaceAll("[^a-zA-Z]", "_"));
		// Expected: Replace each non-letter: Java____Code

		// 9. The + groups one or more consecutive non-letters.
		System.out.println("Replace non-letter groups: " + text.replaceAll("[^a-zA-Z]+", "_"));
		// Expected: Replace non-letter groups: Java_Code

		// 10. Keep Unicode letters and combining marks from any language.
		// Java regex backslashes must be doubled inside string literals.
		text = "Caf\u00e9123 \u0928\u092e\u0938\u094d\u0924\u0947!";
		System.out.println("Unicode letters: " + text.replaceAll("[^\\p{L}\\p{M}]", ""));
		// Expected: Unicode letters: Caf\u00e9\u0928\u092e\u0938\u094d\u0924\u0947
	}

}
