package calculator.wilfredlopez;

public class App {
    public static void main(final String[] args) {
        final int principal = (int) Console.readNumber("Principal: ", 1000, 1_000_000);
        final float anualInterest = (float) Console.readNumber("Anual Interest Rate: ", 0, 100);
        final byte years = (byte) Console.readNumber("Period (Years): ", 1, 30);
        MorgageReport morgageReport = new MorgageReport(principal, anualInterest, years);
        morgageReport.printMorgage();
        morgageReport.printPaymentSchedule();

    }
}
