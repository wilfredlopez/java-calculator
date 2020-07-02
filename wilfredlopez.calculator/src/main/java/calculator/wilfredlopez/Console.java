package calculator.wilfredlopez;

import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static double readNumber(final String prompt) {
        return scanner.nextDouble();
    }

    public static double readNumber(final String prompt, final double min, final double max) {
        double value = 0;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("Please enter a value between " + min + " and " + max);
        }

        return value;
    }

}