package task;

import java.util.Scanner;

class ArithmeticOperations {
    public static int power(int a, int b) throws IllegalArgumentException {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Numbers a or b should not be negative");
        }

        if (a == 0 && b == 0) {
            throw new IllegalArgumentException("Numbers a and b should not be zero");
        }

        return (int) Math.pow(a, b);
    }

    public static double division(int a, int b) throws ArithmeticException {
        if (b == 0 ) {
            throw new ArithmeticException("Invalid input b should not be zero.");
        }
        if(a > Integer.MAX_VALUE || a < Integer.MIN_VALUE || b > Integer.MAX_VALUE || b < Integer.MIN_VALUE) {
        	throw new ArithmeticException("Invalid input. Check constraints: a and b should be 32-bit signed integers");
        	
        }

        return (double) a / b;
    }
}

public class ArithematicOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter integer a: ");
        int a = scanner.nextInt();

        System.out.print("Enter integer b: ");
        int b = scanner.nextInt();

        try {
            int resultPower = ArithmeticOperations.power(a, b);
            System.out.println("a^b: " + resultPower);
        } catch (IllegalArgumentException e) {
            System.out.println("Error in power method: " + e.getMessage());
        }

        try {
            double resultDivision = ArithmeticOperations.division(a, b);
            System.out.println("a/b: " + resultDivision);
        } catch (ArithmeticException e) {
            System.out.println("Error in division method: " + e.getMessage());
        }
    }
}
