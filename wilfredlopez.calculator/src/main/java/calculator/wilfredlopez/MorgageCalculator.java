package calculator.wilfredlopez;

public class MorgageCalculator {
    private int principal;
    private float anualInterest;
    private byte years;
    final private byte PERCENT = 100;
    final private byte MONTHS_IN_YEAR = 12;

    public MorgageCalculator(int principal, float anualInterest, byte years) {
        this.anualInterest = anualInterest;
        this.years = years;
        this.principal = principal;
    }

    public double calculateMorgage() {
        final short numberOfPayments = getNumberOfPayments();
        final float montlyInterest = getMontlyInterest();
        final double morgage = principal * (montlyInterest * Math.pow(1 + montlyInterest, numberOfPayments))
                / (Math.pow(1 + montlyInterest, numberOfPayments) - 1);
        return morgage;
    }

    public double[] getRemainingBalances() {
        double[] balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++) {
            balances[month - 1] = this.calculateBalance(month);
        }
        return balances;
    }

    private short getNumberOfPayments() {
        return (short) (years * MONTHS_IN_YEAR);
    }

    private float getMontlyInterest() {
        return anualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    private double calculateBalance(final short numberOfPaymentsMade) {
        final float montlyInterest = getMontlyInterest();
        final short numberOfPayments = this.getNumberOfPayments();
        final double balance = principal
                * (Math.pow(1 + montlyInterest, numberOfPayments) - Math.pow(1 + montlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + montlyInterest, numberOfPayments) - 1);

        return balance;
    }

}