/*
Adrien Abbey, CS-1180 Remake, Jan. 31, 2022
Practice Problem 8: Every Nth Item
Visual Studio Code, Windows 10, Eclipse Temurin JDK/JRE 11

Create an array of ten random integers with values between 1 and 20 using a 
loop and display the contents of the full array.  Next, ask the user to input 
a number between 1 and 10, and use this as your N value.  Print every Nth item 
in the array.

Changes/Improvements:
    - Uses UserScanner class
    - Loops use Array.length, allowing for Arrays of different lengths

Possible Future Improvements:
*/

class Practice8 {
    public static void main(String[] args) throws Exception {

        // Setup Variables:
        int[] randIntArray = new int[20];
        int n;

        // Seed the Array with random integers:
        for (int i = 0; i < randIntArray.length; i++) {
            randIntArray[i] = (int) (Math.random() * 20 + 1);
        }

        // Display the contents of the Array:
        System.out.print("The array contains ");
        for (int i = 0; i < randIntArray.length; i++) {
            System.out.print(randIntArray[i] + " ");
        }
        System.out.println();

        // Only accept a valid input for N:
        while (true) {
            // Prompt for the value of N:
            n = UserScanner.intInput("What is the value of N? ");
            if (n >= 1 && n <= 10) {
                break;
            } else {
                System.out.println("Error: the value must be between 1 and 10");
            }
        }

        // Display every Nth item in the Array:
        for (int i = 0; i < randIntArray.length; i++) {
            // if mod of index+1 = 0, then print:
            if ((i + 1) % n == 0) {
                System.out.print(randIntArray[i] + " ");
            }
        }
    }
}