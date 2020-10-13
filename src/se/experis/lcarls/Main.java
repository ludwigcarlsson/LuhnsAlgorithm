package se.experis.lcarls;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        long input = sc.nextLong();
        checkInput(input);
    }

    public static void checkInput(long input) {
        String status;
        long num = input;
        int sum = 0;
        List<Long> digits = new ArrayList<>();
        while (num>0) { // splits input into single digits
            digits.add(0, num%10);
            num=num/10;
        }
        if (digits.size() == 16) {
            status = "Valid";
        } else {
            status = "Invalid";
        }

        for (int i = 0; i < digits.size(); i++) {
            if(i%2 != 0) {
                digits.set(i, digits.get(i)*2);
            }
            if (digits.get(i) > 9) {
                digits.set(i, digits.get(i)-9);
            }
            sum += digits.get(i);
        }
        System.out.println("Input: "+input+" "+(sum*9)%10);
        System.out.println("Provided: "+(sum*9)%10);
        System.out.println("Expected: "+(sum*9)%10);

        System.out.println("Expected: "+status);
        System.out.println("Expected: "+digits.size());

    }
}
