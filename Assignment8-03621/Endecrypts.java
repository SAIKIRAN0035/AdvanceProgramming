/*
Assignment 8(b)
* Author: Saikiran Reddy Yarava 
Student Name: Saikiran Reddy Yarava
Course Name: Advanced Programming concepts (MCIS-5103)
Section Number: 031
Student Number:999903621
*/

import java.io.*;
import java.util.Scanner;

/**
 * Endecrypts - A program for encrypting and decrypting text using XOR encryption.
 *
 * @author Saikiran Reddy Yarava

 */
public class Endecrypts {
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);

        //Ask the user to provide a password.
        System.out.println("Enter a passcode to ask permission next time when you access:");
        String passcode = ob.nextLine();

        //   user the  desired operation
        System.out.println("Enter the operation number you wish to carry out:\n 1. Save the encrypted name\n 2. Load the name and decode it.");
        int op = ob.nextInt();
        ob.nextLine();

        switch (op) {
            case 1:
                // Encrypted and save a name
                System.out.println("Please enter your name:");
                String name = ob.nextLine();
                System.out.println("Please enter a filename to save the encrypted name:");
                String sFile = ob.nextLine();
                try {
                    encryptAndSave(name, passcode, sFile);
                } catch (IOException e) {
                    System.out.println("An error occurred while saving the encrypted name.");
                }
                break;
            case 2:
                // Decrypt & load an encrypted name 
                System.out.println("Please enter a filename to load the encrypted name:");
                String lFile =ob.nextLine();
                try {
                    String decryptedName = decryptAndLoad(passcode, lFile);
                    System.out.println("Decrypted name: " + decryptedName);
                } catch (IOException e) {
                    System.out.println("An error occurred while loading the encrypted name.");
                }
                break;
            default:
                System.out.println("Invalid operation number.");
                break;
        }
    }

    /**
     * Encrypts and saves a string using XOR encryption.
     *
     * @param name     The text to be encrypted.
     * @param passcode The encryption key.
     * @param fileName The name of the file where the encrypted text will be saved.
     * @return The encrypted text.
     * @throws IOException if there is an error while saving the encrypted text.
     * @author Saikiran Reddy Yarava
     */
    public static void encryptAndSave(String name, String passcode, String fileName) throws IOException {
        StringBuilder encryptedName = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            char letter = name.charAt(i);
            char pwChar = passcode.charAt(i % passcode.length());
            char encryptedLetter = (char) (letter ^ pwChar);
            encryptedName.append(encryptedLetter);
        }

        try (FileWriter fileWriter = new FileWriter(fileName);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.print(encryptedName);
        }
    }

    /**
     * 
     * @param passcode The encryption key.
     * @param fileName The name of the file from which the encrypted text will be loaded.
     * @return The decrypted text.
     * @throws IOException if there is an error while loading the encrypted text.
     *@author Saikiran Reddy Yarava
     */
    public static String decryptAndLoad(String passcode, String fileName) throws IOException {
        StringBuilder decryptedName = new StringBuilder();

        try (BufferedReader bReader = new BufferedReader(new FileReader(fileName))) {
            String encryptedName = bReader.readLine();
            for (int i = 0; i < encryptedName.length(); i++) {
                char encryptedLetter = encryptedName.charAt(i);
                char pwChar = passcode.charAt(i % passcode.length());
                char decryptedLetter = (char) (encryptedLetter ^ pwChar);
                decryptedName.append(decryptedLetter);
            }
        }

        return decryptedName.toString();
    }

    //  second class with an object instantiation
    public static class MyClass {
        private String data;

        public MyClass(String data) {
            this.data = data;
        }

        public void printData() {
            System.out.println("Data: " + data);
        }
    }
}
