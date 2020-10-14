package se.experis.lcarls;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        String input = sc.nextLine();
        System.out.println("Checksum: " + checkInput(input));
        System.out.println("Digits: "+input.length()+" "+checkCreditCard(input.length()));
    }

    public static String checkInput(String input) {
        if (input == null || !input.matches("\\d+")) { // Ensures that input only contains numbers
            return null;
        }
        char checkDigit = input.charAt(input.length() -1); // Gets last digit of input
        System.out.println("Input: "+input.substring(0, input.length()-1) +" "+ checkDigit);
        System.out.println("Provided: "+checkDigit);
        String digit = calCheckDigit(input.substring(0, input.length()-1), checkDigit);
        System.out.println("Expected: "+digit.charAt(0)+"\n");
        return digit.substring(1); // returns a string starting at the second character
    }

    public static String checkCreditCard(int length) {
        return (length==16 ? "(credit card)" : ""); // checks if input is equal to 16 digits or not
    }

    public static String calCheckDigit(String input, char checkDigit) {
        if (input == null) { // returns early if input somehow is empty
            return null;
        }

        String digit;

        int sum = calculateDigits(input);

        String luhn = checkLuhn(sum+Character.getNumericValue(checkDigit));
        sum=sum*9;
        digit = sum + ""; // creates a string from the sum given

        return digit.substring(digit.length()-1) + luhn; // returns the last digit from the sum and the string value of the luhn-check
    }

    public static int calculateDigits(String input) {
        if (input == null) { // returns early if input somehow is empty
            return 0;
        }

        int[] digits = new int[input.length()]; // Creates an array with the length of the amount of characters in passed argument "input"

        for (int i = 0; i < input.length(); i++) {
            digits[i] = Character.getNumericValue(input.charAt(i)); // Adds the numeric value of each character in input into the array
        }

        for (int i = digits.length-1; i >= 0; i -= 2) { // Multiplies the value by 2, starting from the back and decrementing by 2
            digits[i] += digits[i];
            if (digits[i] >= 10) { // if the value times two equals more 10, subtract 9 from the value
                digits[i] = digits[i] - 9;
            }
        }
        int sum = 0;
        for (int j = 0; j < digits.length; j++) { // for each digit, add to sum
            sum += digits[j];
        }
        return sum;
    }

    public static String checkLuhn(int sum) {
        return (sum%10 == 0) ? "Valid": "Invalid"; // if the sum modulus 10 equals a rest of anything else than 0, return invalid, else return valid
    }
}
