package com.codewithkevin;

import com.sun.security.jgss.GSSUtil;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Period (Years): ");
        byte periodInYears = scanner.nextByte();
        int periodInMonths = periodInYears * (int)MONTHS_IN_YEAR;

        float total = (principal * ((monthlyInterest * (float)Math.pow(1 + monthlyInterest, periodInMonths)) / ((float)Math.pow(1 + monthlyInterest, periodInMonths) - 1)));
        String mortgage = NumberFormat.getCurrencyInstance(Locale.US).format(total);
        System.out.print("Mortgage: " + mortgage);


 }
}