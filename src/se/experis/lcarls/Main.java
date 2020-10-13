package se.experis.lcarls;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        String input = sc.nextLine();
        System.out.println("Checksum: " + (checkInput(input) ? "Valid" : "Invalid"));
        System.out.println("Digits: "+input.length() + (input.length()==16 ? " (credit card)" : ""));
    }

    public static boolean checkInput(String input) {
        if (input == null) {
            return false;
        }
        char checkDigit = input.charAt(input.length() -1);
        String digit = checkLuhn(input.substring(0, input.length()-1), checkDigit);

        return checkDigit == digit.charAt(0);
    }

    public static String checkLuhn(String input, Character checkDigit) {
        if (input == null) {
            return null;
        }
        String digit;

        int[] digits = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            digits[i] = Character.getNumericValue(input.charAt(i));
        }

        for (int i = digits.length-1; i >= 0; i -= 2) {
            digits[i] += digits[i];
            if (digits[i] > 9) {
                digits[i] = digits[i] - 9;
            }
        }
        int sum = 0;
        for (int j : digits) {
            sum += j;
        }
        sum=sum*9;
        digit = sum + "";

        System.out.println("Input: "+digit.substring(digit.length() - 1));

        System.out.println("\nChecksum: "+((sum%10) == checkDigit ? "Valid" : "Invalid"));

        return digit.substring(digit.length()-1);

    }
}
