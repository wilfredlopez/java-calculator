package calculator.wilfredlopez;

import java.text.NumberFormat;

public class MorgageReport {

    private MorgageCalculator calculator;
    private NumberFormat currency;

    public MorgageReport(final int principal, final float anualInterest, final byte years) {
        this.calculator = new MorgageCalculator(principal, anualInterest, years);
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-------------");
        for (double balance : calculator.getRemainingBalances()) {
            System.out.println(currency.format(balance));
        }
    }

    public void printMorgage() {
        final double morgage = calculator.calculateMorgage();
        final String morgageFormatted = currency.format(morgage);
        System.out.println();
        System.out.println("MORGAGE");
        System.out.println("-------------");
        System.out.println("Monthly Payments: " + morgageFormatted);
    }

}