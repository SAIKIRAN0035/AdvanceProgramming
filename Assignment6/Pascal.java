/*
Assignment 6(b)
Student Name: Saikiran Reddy Yarava
Course Name: Advanced Programming concepts (MCIS-5103)
Section Number: 031
Student Number:999903621*/

import java.util.*;
import java.io.*;
import java.util.Scanner;

//@Author:Saikiran Reddy 

class Pascal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows for Pascal's triangle: ");
        int numRows = scanner.nextInt();

        PascalGen gen= new PascalGen();
        gen.printPascalGen(numRows);
    }
}
//@Author : Saikiran Reddy
class PascalGen {

    /**
     * Generates and prints Pascal's triangle for the given number of rows.
     *
     * @param totalRows The number of rows for Pascal's triangle.
     */
    public void printPascalGen(int numRows) {
        for (int i = 0; i < numRows; i++) {
            //it  print spaces for alignment
            for (int j = 0; j < numRows - i; j++) {
                System.out.print("   ");
            }

            // it Calculate and print the number for each row
            int n = 1;
            for (int j = 0; j <= i; j++) {
                System.out.printf("%6d", n);
                n = n * (i - j) / (j + 1);
            }

            // it goes to the next line
            System.out.println();
        }
    }
}