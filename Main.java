package com.codewithkevin;

import com.sun.security.jgss.GSSUtil;
import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0;
        float monthlyInterest = 0;
        byte periodInYears = 0;
        int periodInMonths = 0;

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if(principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a value between 1000 and 1000000");
        }
        while(true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 30) {
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        while(true) {
            System.out.print("Period (Years): ");
            periodInYears = scanner.nextByte();
            if(periodInYears >=1 && periodInYears <= 30){
                periodInMonths = periodInYears * (int)MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        float total = (principal * ((monthlyInterest * (float)Math.pow(1 + monthlyInterest, periodInMonths)) / ((float)Math.pow(1 + monthlyInterest, periodInMonths) - 1)));
        String mortgage = NumberFormat.getCurrencyInstance(Locale.US).format(total);
        System.out.print("Mortgage: " + mortgage);



 }
}