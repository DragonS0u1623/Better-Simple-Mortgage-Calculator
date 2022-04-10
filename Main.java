import java.text.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        final int MONTHS_IN_YEAR = 12, PERCENT = 100;
        Scanner sc = new Scanner(System.in);

        double monthlyRate, mortgage, annualRate;
        int principle, periodInYears;
        boolean shouldRepeat = false;

        do {
            shouldRepeat = false;
            System.out.print("Principle ($1K - $1M): ");
            principle = sc.nextInt();
            if (principle < 1_000 || principle > 1_000_000) {
                System.out.println("Principle must be between 1,000 and 1,000,000.");
                shouldRepeat = true;
            }
        } while (shouldRepeat);

        do {
            shouldRepeat = false;
            System.out.print("Annual Rate: ");
            annualRate = sc.nextDouble();
            if (annualRate <= 0 || annualRate > 30) {
                System.out.println("Annual rate should be between 0 and 30");
                shouldRepeat = true;
            }
        } while (shouldRepeat);

        monthlyRate = annualRate / PERCENT / MONTHS_IN_YEAR;

        do {
            shouldRepeat = false;
            System.out.print("Period (Years): ");
            periodInYears = sc.nextInt();
            if (periodInYears <= 0 || periodInYears > 30) {
                System.out.println("The period should be between 1 and 30 years");
                shouldRepeat = true;
            }
        } while (shouldRepeat);

        sc.close();

       int periodInMonths = periodInYears * MONTHS_IN_YEAR;

        mortgage = principle * 
                (monthlyRate * Math.pow(1 + monthlyRate, periodInMonths)) / 
                (Math.pow(1 + monthlyRate, periodInMonths) - 1);
        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }
}
