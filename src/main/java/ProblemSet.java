/* Title: Problem Set Unit 5
Name: Angie Seto
Date Created: May 12, 2026
Date Updated: May 19, 2026 */

import java.util.Scanner;
//import java.util.ArrayList;
import java.util.HashMap;

public class ProblemSet {

	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to the Text Analyzer.");
		System.out.print("\n" + "Please enter a sentence or paragraph: ");
		String sentence = input.nextLine();

		System.out.println(totalCount(sentence));
	}

	public static String totalCount (String sentence) {

		int spaceCounter = 0;		
		int vowelCounter = 0;

		for (int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) == ' ') {
				spaceCounter++;
			}
			if (sentence.charAt(i) == 'a' || sentence.charAt(i) == 'e' || sentence.charAt(i) == 'i' || sentence.charAt(i) == 'o' || sentence.charAt(i) == 'u') {
				vowelCounter++;
			} 
		} //counts spaces + vowels

		String[] words = sentence.split(" "); //split by words
		String[] characters = sentence.split(""); //split by letters
	
		System.out.println("\n" + "Total Characters: " + characters.length);
		System.out.println("Total words: " + words.length);
		System.out.println("Total Vowels: " + vowelCounter);
		System.out.println("Total Spaces: " + spaceCounter);

		/*WORD FREQUENCY********************************************************/
		System.out.println("\n" + "Word Frequency:");
		
		String sentenceWithout = sentence.replaceAll("[.,!]", "").toLowerCase();
		String[] words2 = sentenceWithout.split(" "); //split by words, without punctuation

		HashMap<String, Integer> wordFreq = new HashMap<String, Integer>();

		int uniqueWordCounter = 0;

		for (String word : words2) { //every time word shows up in the sentence
			
			if (wordFreq.containsKey(word)) { //if it's the word again, add one to key
                wordFreq.put(word, wordFreq.get(word) + 1);
			} else { //first time appearance
                wordFreq.put(word, 1); 
				uniqueWordCounter++;
			} //any time it shows up for the first time = unique  word
			
			if (wordFreq.containsKey("the") || wordFreq.containsKey("a") || wordFreq.containsKey("an") || wordFreq.containsKey("and") || wordFreq.containsKey("is")) {
				wordFreq.remove(word);
			} //takes out words before it prints 
		
		} //word frequency + unique counter

		String wordFreqPrint = wordFreq.toString();
		wordFreqPrint = wordFreqPrint.replaceAll("[,{}}]", "\n");
		wordFreqPrint = wordFreqPrint.replaceAll(" ", "");
		wordFreqPrint = wordFreqPrint.replaceAll("=", " - ");

		System.out.println(wordFreqPrint);

		/*OPTION 3 THINGS*******************************************************/
		
		String longWord = "";
		String longWords = ""; //more than one
		int longestLength;
		
		for (int c = 0; c < words2.length; c++) { 			
			longestLength = longWord.length();

			if (!(words2[c].equals("")) && words2[c].length() >= longestLength && !(words2[c].equals("the") || words2[c].equals("a") || words2[c].equals("a") || words2[c].equals("an") || words2[c].equals("and") || words2[c].equals("is"))) {
				if (words2[c].length() == longestLength) {
					longWord = longWord + ", " + words2[c];
					longWords =  longWord;
					longWord = words2[c]; //clears it back to checking only one word
				}
				else {
					longWord = words2[c];
					longWords = words2[c];
				}
			}
		} //longest word

		String shortWord = longWord;
		String shortWords = ""; //more than one
		int shortestLength;
		
		for (int e = 0; e < words2.length; e++) { 			
			shortestLength = shortWord.length();

			if (!(words2[e].equals("")) && words2[e].length() <= shortestLength && !(words2[e].equals("the") || words2[e].equals("a") || words2[e].equals("a") || words2[e].equals("an") || words2[e].equals("and") || words2[e].equals("is"))) {
				if (words2[e].length() == shortestLength) {
					shortWord = shortWord + ", " + words2[e];
					shortWords =  shortWord;
					shortWord = words2[e]; //clears it back to checking only one word
				}
				else {
					shortWord = words2[e];
					shortWords = words2[e];
				}
			}
		} //shortest word

		
		// int totalWords = 0;

		// for (int f = 0; f < sentenceWithout.length(); f++) {
		// 	if (characters[f].matches(" ")) {
		// 		totalWords++;
		// 	}
		// } //total words 
		// totalWords = totalWords + 1; 

		double wordLengths = 0;
		for (int g = 0; g < words2.length; g++) {
			wordLengths = wordLengths + words2[g].length();
		} //word lengths

		double averageLength = wordLengths/ (double) words2.length;

		int sentenceCounter = 0;
		for (int d = 0; d < characters.length; d++) {
			if (characters[d].equals(".")) {
				if (characters[d-1].matches("[a-zA-Z0-9]")) {
				sentenceCounter++;
				}
			}
		} //sentence counter

		System.out.println("Longest Word: " + longWords);
		System.out.println("Shortest Word: " + shortWords);
		System.out.println("Average Word Length: " + averageLength);
		System.out.println("Number of Sentences: " + sentenceCounter);
		return "Unique Words: " + uniqueWordCounter;

	}

}
