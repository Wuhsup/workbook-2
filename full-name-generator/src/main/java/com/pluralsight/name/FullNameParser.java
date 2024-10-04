package com.pluralsight.name;

import java.util.Scanner;

public class FullNameParser {

        public static void main(String[] args) {
            String firstName;
            String middleName;
            String lastName;

            Scanner userInput = new Scanner(System.in);

            System.out.print("Please Enter Your Name (first last or first middle last): ");
            String input = userInput.nextLine();
            String[] nameParts = input.split (" ");

            System.out.println("Parsed Name Components:");
            if (nameParts.length == 2) {
                System.out.println("First Name: " + nameParts[0]);
                System.out.println("Last Name: " + nameParts[1]);
            } else if (nameParts.length == 3) {
                System.out.println("First Name: " + nameParts[0]);
                System.out.println("Middle Name: " + nameParts[1]);
                System.out.println("Last Name: " + nameParts[2]);
            } else {
                System.out.println("Uh Oh! Please Enter The Name In The Correct Format.");
            }

            userInput.close();
        }
    }


