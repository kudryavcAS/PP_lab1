import java.util.Scanner;
import java.util.InputMismatchException;

public class TaylorRow {

    public static void main(String[] args) {
        System.out.println("This program calculate function sqrt(1+x) using Taylor row." +
                "The calculations are completed when the next term turns out to be modulo less then 10^(-k)");
        System.out.println("Enter natural k and real х ∈ (-1, 1) through a space");

        Scanner in = new Scanner(System.in);
        int k = 0;
        double x = 2;

        try {
            k = in.nextInt();
            x = in.nextDouble();
        } catch (InputMismatchException ex) {
            System.out.println("Error: " + ex.getMessage());
            main(null);
        }

        if (x > 1 || x < -1 || k < 1) {
            System.out.println("Enter a correct numbers.");
            main(null);
        }

        System.out.printf("Taylor row result: %.3f\n", calculateRow(k, x));
        System.out.printf("Standart functions result: %.3f\n", calculateFunc(x));

    }

    static double calculateRow(int k, double x) {
        double epsilon = Math.pow(10, -k), sum = 1.0, term = 1.0, multiplier;
        final double alpha = 0.5;
        int n = 1;

        while (true) {
            multiplier = (alpha - (n - 1)) / n;
            term = term * multiplier * x;

            if (Math.abs(term) < epsilon) {
                break;
            }
            sum += term;
            n++;
        }
        return sum;
    }

    static double calculateFunc(double x) {
        return Math.sqrt(x + 1);
    }
}
