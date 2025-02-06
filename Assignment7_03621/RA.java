
/*
Assignment 7
* Author: Saikiran Reddy Yarava 
Student Name: Saikiran Reddy Yarava
Course Name: Advanced Programming concepts (MCIS-5103)
Section Number: 031
Student Number:999903621
*/

import java.util.*;
import java.io.*;
import java.util.Scanner;

/*
 * Description: Converts Roman numerals to Arabic numerals.
 *@author : Saikiran Reddy Yarava
 */
public class RA {

   //The resulting Arabic number is stored in a variable.
    static int outputAN;

    //Roman to Arabic conversion is carried out mostly using this method.
    public static void main(String[] args) {
        Scanner ob = new Scanner(System.in);

       // Request the amount of test cases from the user.
        System.out.print(" The number of test cases should be entered : ");
        int NTC = ob.nextInt();
        System.out.println("");

        while (NTC != 0) {
            outputAN = 0;

         // Request the Roman numeral from the user.
            System.out.print("Please provide the Roman numeral you wish to convert into Arabic:");
            String Roman = ob.next();
            System.out.println("");

            if (!isGRV(Roman)) {
                System.out.println("The input contains invalid characters. There are only viable ones: I, V, X, L, C, D, M.");
            } else if (SubtractionsConsecutive(Roman)) {
                System.out.println("Two consecutive subtractions were found, indicating an invalid numeral.");
            } else if (!AuxValid(Roman)) {
                System.out.println("The auxiliary symbol cannot be subtracted from an invalid numeral.");
            } else if (AddDecr(Roman)) {
                System.out.println("Numerical error: Additions do not reduce.");
            } else {
                System.out.println("Roman numerals' Arabic translation " + Roman +
                        " is: " + outputAN);
            }

            System.out.println("");
            NTC--;
        }

        ob.close();
    }
//class RomanNumeralValidator {
   /** 
* A technique to determine whether a Roman numeral is correct. 
*
* @param Roman The Roman numeral that needs to be verified. 
* @return If the Roman numeral is correct, then true; otherwise, false.
*/
    public static boolean isGRV(String Roman) {
        for (int i = 0; i < Roman.length(); i++) {
            // Check if the current character of the Roman numeral is I, V, X, L, C, D, or M.
            if ("IVXLCDM".indexOf(Roman.charAt(i)) == -1) {
                return false;
            }
            // Rule 5: Invalid repetition of V, L, or D
            if (i > 0 && "VLD".indexOf(Roman.charAt(i)) != -1 && Roman.charAt(i) == Roman.charAt(i - 1)) {
                return false;
            }

            // Rule 6: Too long repetition
            if (i > 1 && Roman.charAt(i) == Roman.charAt(i - 1) && Roman.charAt(i - 1) == Roman.charAt(i - 2)) {
                return false;
            }
        }
        return true;
    }


   /**
*Method to determine whether the Roman numeral contains a correct auxiliary subtraction. 
/** * Test to see if the Roman numeral contains a legitimate auxiliary subtraction. 
* @param Roman To be verified is the Roman number.
*@return If an auxiliary numeral is not subtracted from, the statement is true; otherwise, it is incorrect.
*/
    public static boolean AuxValid(String Roman) {
        for (int i = 0; i < Roman.length() - 1; i++) {
            int n1 = getdigit(Roman.charAt(i));
            int n2 = getdigit(Roman.charAt(i + 1));

            if (n1 < n2) {
                if (Aux(Roman.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
   
    public static boolean SubtractionsConsecutive(String Roman) {
        for (int i = 0; i < Roman.length() - 2; i++) {
            int n1 = getdigit(Roman.charAt(i));
            int n2 = getdigit(Roman.charAt(i + 1));
            int n3 = getdigit(Roman.charAt(i + 2));

            if (n1 < n2 && n2 < n3) {
                return true;
            }
        }
        return false;
    }
/** * 
*@param Roman 
* A method to determine whether additions in the Roman number are decreasing the Roman number that needs to be verified. 
* @return True in the event that additions are not diminishing, false otherwise.
*/
    public static boolean AddDecr(String Roman) {
        int priorValue = 0;

        for (int i = 0; i < Roman.length(); i++) {
            int n1 = getdigit(Roman.charAt(i));

            if (i + 1 < Roman.length()) {
                int n2 = getdigit(Roman.charAt(i + 1));

                if (n1 >= n2) {
                    outputAN += n1;

                    if (priorValue != 0 && priorValue < n1) {
                        return true;
                    }

                   priorValue = n1;
                } else {
                    outputAN += n2 - n1;

                    if (priorValue != 0 && priorValue < (n2 - n1)) {
                        return true;
                    }

                    priorValue = n2 - n1;

                    i++;
                }
            } else {
                outputAN += n1;
                i++;
            }
        }

        return false;
    }

 /** 
* @param symbol 
* Method to determine whether a given symbol is an auxiliary symbol
 * @return True in the event that the sign is an auxiliary symbol, false otherwise.
*/
    public static boolean Aux(char symbol) {
        return "VLD".indexOf(symbol) != -1;
    }

   /** 
* A method for obtaining a Roman numeral's numerical value. 
* @param symbol To obtain the numerical value, enter the Roman number. 
* @return The Roman numeral's numerical value. 
*/
    public static int getdigit(char symbol) {
        switch (symbol) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
