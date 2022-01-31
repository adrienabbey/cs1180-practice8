/*
User Scanner Class written by Adrien Abbey
Version 1.3, January 20, 2022

Version History:
    1.1: Inform the user when an invalid input is given.
    1.2: Renamed methods, added String and trueFalse prompt types.
    1.3: Added charInput method.

Goal: Reusable library to provide a way to gracefully handle grabbing user 
input with the Scanner object.

Goal achieved?  Yep!  Room for improvement to be sure, but it's already a 
massive improvement over what I was doing before, and it works too!

ToDo: 
    - Add additional input types.  
    - Improved error handling.  
    - I'm sure there's a proper automated method to import classes and handle 
      versioning, but for now I'll just copy/paste this file by hand each time.
*/

import java.util.Scanner;

public class UserScanner {
    // Public static Scanner object, available to all classes:
    public static Scanner userScanner = new Scanner(System.in);

    // Class: prompt the user for a string input:
    public static String stringInput(String prompt) throws Exception {
        // No need to loop here, all inputs are valid.
        System.out.print(prompt);
        return userScanner.nextLine();
    }

    // Class: prompt user for integer input:
    public static int intInput(String prompt) throws Exception {
        // Loop until a valid answer is given
        while (true) {
            System.out.print(prompt);
            try {
                int userInt = userScanner.nextInt();
                // Clear the Scanner input before returning. Grabbing just an int typically
                // leaves a line return in the buffer.
                userScanner.nextLine();
                return userInt;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input.  Try again.");
                userScanner.nextLine();
            }
        }
    }

    // Class: prompt the user for a character input:
    public static char charInput(String prompt) throws Exception {
        // Grab the entire input as a String, then return the first character.
        // If the length of the string is greater than 1, complain.
        // Loop until a valid input is given:
        while (true) {
            System.out.print(prompt);
            String inputString = userScanner.nextLine();
            if (inputString.trim().length() == 1) {
                return (char) inputString.trim().charAt(0);
            } else {
                System.out.println("Invalid input.  Try again.");
            }
        }
    }

    // Class: prompt user for a yes/no input:
    public static boolean yesNoInput(String prompt) throws Exception {
        // Loop until a valid answer is given:
        while (true) {
            System.out.print(prompt);
            String userInput = userScanner.nextLine();
            if (userInput.trim().equalsIgnoreCase("yes")) {
                return true;
            } else if (userInput.trim().equalsIgnoreCase("no")) {
                return false;
            } else {
                System.out.println("Invalid input.  Try again.");
            }
        }
    }

    // Class: prompt for a true/false input:
    public static boolean trueFalseInput(String prompt) throws Exception {
        // Loop until a valid answer is given:
        while (true) {
            System.out.print(prompt);
            String userInput = userScanner.nextLine();
            if (userInput.trim().equalsIgnoreCase("true")) {
                return true;
            } else if (userInput.trim().equalsIgnoreCase("false")) {
                return false;
            } else {
                System.out.println("Invalid input.  Try again.");
            }
        }
    }
}
