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
        return (length==16 ? "(credit card)" : "");
    }

    public static String calCheckDigit(String input, char checkDigit) {
        if (input == null) {
            return null;
        }

        String digit;

        int sum = calculateDigits(input);

        String luhn = checkLuhn(sum+Character.getNumericValue(checkDigit));
        sum=sum*9;
        digit = sum + "";

        return digit.substring(digit.length()-1) + luhn;
    }

    public static int calculateDigits(String input) {
        int[] digits = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            digits[i] = Character.getNumericValue(input.charAt(i));
        }

        for (int i = digits.length-1; i >= 0; i -= 2) {
            digits[i] += digits[i];
            if (digits[i] >= 10) {
                digits[i] = digits[i] - 9;
            }
        }
        int sum = 0;
        for (int j = 0; j < digits.length; j++) {
            sum += digits[j];
        }
        return sum;
    }

    public static String checkLuhn(int sum) {
        return (sum%10 == 0) ? "Valid": "Invalid";
    }
}
