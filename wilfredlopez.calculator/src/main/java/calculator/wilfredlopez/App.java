package calculator.wilfredlopez;

import java.text.NumberFormat;
import java.util.Scanner;

public class App {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(final String[] args) {
        final int principal = (int) readNumber("Principal: ", 1000, 1_000_000);
        final float anualInterest = (float) readNumber("Anual Interest Rate: ", 0, 100);
        final byte years = (byte) readNumber("Period (Years): ", 1, 30);

        final double morgage = App.calculateMorgage(principal, anualInterest, years);
        final String morgageFormatted = NumberFormat.getCurrencyInstance().format(morgage);
        System.out.println();
        System.out.println("MORGAGE");
        System.out.println("-------------");
        System.out.println("Monthly Payments: " + morgageFormatted);

        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-------------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(principal, anualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }

    }

    public static double readNumber(String prompt, double min, double max) {
        final Scanner scanner = new Scanner(System.in);
        double value = 0;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max) {
                break;
            }
            scanner.close();
            System.out.println("Please enter a value between " + min + " and " + max);
        }

        return value;
    }

    private static short calculateNumberOfPayments(byte years) {
        return (short) (years * MONTHS_IN_YEAR);
    }

    private static float calculateMontlyInterest(float anualInterest) {
        return anualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    public static double calculateBalance(int principal, float anualInterest, byte years, short numberOfPaymentsMade) {

        final float montlyInterest = calculateMontlyInterest(anualInterest);
        final short numberOfPayments = calculateNumberOfPayments(years);
        double balance = principal
                * (Math.pow(1 + montlyInterest, numberOfPayments) - Math.pow(1 + montlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + montlyInterest, numberOfPayments) - 1);

        return balance;
    }

    public static double calculateMorgage(int principal, float anualInterest, byte years) {
        final short numberOfPayments = calculateNumberOfPayments(years);
        final float montlyInterest = calculateMontlyInterest(anualInterest);
        final double morgage = principal * (montlyInterest * Math.pow(1 + montlyInterest, numberOfPayments))
                / (Math.pow(1 + montlyInterest, numberOfPayments) - 1);
        return morgage;
    }
}
