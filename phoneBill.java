import java.text.DecimalFormat;
import java.util.Scanner;

public class phoneBill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter package name
        System.out.print("Enter your subscription package (Green/Blue/Purple): ");
        String packageChoice = scanner.nextLine().toLowerCase();

        // Prompt user to enter data usage
        System.out.print("Enter the amount of data used (in GB): ");
        double dataUsage = scanner.nextDouble();

        // Variables to store bill amount and validity of package
        double billAmount = 0.0;
        boolean validPackage = true;

        // Calculate bill amount based on package and data usage
        if (packageChoice.equals("green")) {
            System.out.print("Do you have a coupon? (yes/no): ");
            String couponChoice = scanner.next().toLowerCase();
            
            double baseCost = 49.99;
            double includedData = 2.0;
            double additionalCostPerGB = 15.0;
            double totalData = includedData + (dataUsage > includedData ? dataUsage - includedData : 0);
            billAmount = baseCost + (totalData - includedData) * additionalCostPerGB;
            if (billAmount >= 75 && couponChoice.equals("yes")) {
                billAmount -= 20;
            }
        } else if (packageChoice.equals("blue")) {
            double baseCost = 70.0;
            double includedData = 4.0;
            double additionalCostPerGB = 10.0;
            double totalData = includedData + (dataUsage > includedData ? dataUsage - includedData : 0);
            billAmount = baseCost + (totalData - includedData) * additionalCostPerGB;
        } else if (packageChoice.equals("purple")) {
            billAmount = 99.95;
        } else {
            // Invalid package choice
            System.out.println("Invalid package choice.");
            validPackage = false;
        }

        // Display bill amount if package is valid
        if (validPackage) {
            DecimalFormat df = new DecimalFormat("#.##");
            System.out.println("Your monthly bill amount is: $" + df.format(billAmount));
        }

        scanner.close();
    }
}
