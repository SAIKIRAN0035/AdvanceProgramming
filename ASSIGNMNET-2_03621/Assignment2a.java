/*
Assignment 2(a)
Student Name: Saikiran Reddy Yarava
Course Name: Advanced Programming concepts (MCIS-5103)
Section Number: 031
Student Number:999903621*/

import java.util.*;
import java.io.*;

public class Assignment2a
 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n;

        // Validate input (between 11 and 1900)
        do{
            System.out.println("Enter a number between 11 and 1900.");
             n = sc.nextInt();
            if (n < 11 || n > 1900) {
               System.out.println("ERROR.So,Please enter a number which is between 11 and 1900"); 
            }
        }while(n<11 || n>1900);
        
        sc.close();
        System.out.print(n + "=");
            

        // Find and print the  prime factors between 11 and 1900
        for (int i = 2; n > 1; i++) {
            while (n % i == 0) {
                System.out.print(i);
                n = n/i;

                if (n > 1) {
                    System.out.print("*");
                }
            }
        }

        System.out.println();
    }
}
