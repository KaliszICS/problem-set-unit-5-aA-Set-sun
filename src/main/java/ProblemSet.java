/* Title: Problem Set Unit 5
Name: Angie Seto
Date Created: May 12, 2026
Date Updated: May 12, 2026 */

import java.util.Scanner;

public class ProblemSet {

	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to the Text Analyzer.");
		System.out.print("Please enter a sentence or paragraph: ");
		String sentence = "Java is fun and java is powerful."; //input.nextLine();

		System.out.println(totalCount(sentence));
	}

	public static String totalCount (String sentence) {

		int spaceCounter = 0;

		for (int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) == ' ') {
				spaceCounter++;
			}
		} //counts spaces

		String[] words = sentence.split(" "); //split by words
		String[] characters = sentence.split(""); //split by letters
	
		System.out.println("Total Characters: " + characters.length);
		System.out.println("Total words: " + words.length);
		// System.out.println("Total Vowels: ");
		System.out.println("Total Spaces: " + spaceCounter);

		return "yay";

		//hey so put stuff in brackets when it comes to replacing 
		//isBlank (works on arrays and stuff?) -> is a boolean 

	}



}
