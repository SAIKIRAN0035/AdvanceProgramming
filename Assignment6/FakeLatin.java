/*
Assignment 6(b)
Student Name: Saikiran Reddy Yarava
Course Name: Advanced Programming concepts (MCIS-5103)
Section Number: 031
Student Number:999903621*/

import java.util.*;
import java.io.*;
import java.util.Scanner;

/**
 * A simple program for translating text to Fake Latin and back.
 * It includes methods to translate to and from Fake Latin.
 *
 * @author Saikiran Reddy 
 */
 class FakeLatinTranslator {

/**
* Translates a given text to Fake Latin.
*
* @param text The input text to be translated.
* @return The translated Fake Latin text.
*/
public String toFakeLatin(String text) {
// Split the input text into words
String[] alpha = text.split(" ");
StringBuilder fvalue = new StringBuilder();

// Iterate through each word
for (String word : alpha) {
// Move the first letter to the end and add 'ay' to create Fake Latin word
String tWord = word.substring(1) + word.charAt(0) + "ay";
fvalue.append(tWord).append(" ");
}

String temp= fvalue.toString(); // Remove trailing space and return the Fake Latin text
String lowercaseString = temp.toLowerCase();

// Make the first character uppercase
String fnl = lowercaseString.substring(0, 1).toUpperCase() + lowercaseString.substring(1);
return fnl;
}

/**
* Translates a given Fake Latin text back to English.
*
* @param text The Fake Latin text to be translated.
* @return The translated English text.
*/
public String fromFakeLatin(String text) {
// Split the Fake Latin text into words
String[] alpha = text.split(" ");
StringBuilder fvalue = new StringBuilder();

// Iterate through each Fake Latin word
for (String word : alpha) {
// Remove 'ay', then move the last letter to the beginning to revert to English
String originalWord = word.charAt(word.length() - 3) + word.substring(0, word.length() - 3);
fvalue.append(originalWord).append(" ");
}

return fvalue.toString().trim(); // Remove trailing space and return the original English text
}
}

/**
 * The main application class for the Fake Latin Translator.
 * It handles user input and interaction.
 *
 * @author Saikiran Reddy
 */
class FakeLatin{

/**
     * Main method that takes user input, performs translations, and prompts for additional input.
     *
     * @param args Command line arguments (not used).
     */
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

// Get input from the user
System.out.print("Enter a text: ");
String iText = scanner.nextLine();

// Create a FakeLatinTranslator object
FakeLatinTranslator translator = new FakeLatinTranslator();

// Translate to Fake Latin
String fLatinText = translator.toFakeLatin(iText);
System.out.println("Fake Latin: " + fLatinText);

// Translate back from Fake Latin
String originalText = translator.fromFakeLatin(fLatinText);
System.out.println("Back to English: " + iText);

// Prompt for entering Fake Latin sentence
System.out.print("Enter any Fake Latin sentence: ");
String fLatinInput = scanner.nextLine();

// Translate back from Fake Latin
String originalTextFromFakeLatin = translator.fromFakeLatin(fLatinInput);
System.out.println("Back to English: " + originalTextFromFakeLatin);
}
}