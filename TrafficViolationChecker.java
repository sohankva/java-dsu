import java.util.Scanner;

public class TrafficViolationChecker {

    static final double FINE_OVERSPEED_BASE = 500.0;
    static final double FINE_OVERSPEED_PER_KMPH = 50.0; 
    static final double FINE_NO_LICENSE = 1000.0;
    static final double FINE_UNDERAGE = 2000.0;
    static final double FINE_NO_SEATBELT = 300.0;
    static final int MIN_DRIVING_AGE = 18;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Vehicle Number: ");
        String vehicleNumber = sc.nextLine().trim();

        System.out.print("Enter Vehicle Speed (km/h): ");
        double speed = sc.nextDouble();

        System.out.print("Enter Speed Limit (km/h): ");
        double speedLimit = sc.nextDouble();

        System.out.print("Enter Driver's Age: ");
        int age = sc.nextInt();

        System.out.print("Does driver have a valid license? (yes/no): ");
        boolean validLicense = sc.next().trim().equalsIgnoreCase("yes");

        System.out.print("Is seatbelt worn? (yes/no): ");
        boolean seatbeltWorn = sc.next().trim().equalsIgnoreCase("yes");

        System.out.print("Is this an emergency vehicle? (yes/no): ");
        boolean isEmergencyVehicle = sc.next().trim().equalsIgnoreCase("yes");

        sc.close();

        double totalFine = 0.0;
        StringBuilder violations = new StringBuilder();

        if (!isEmergencyVehicle && speed > speedLimit) {
            double excess = speed - speedLimit;
            double speedFine = FINE_OVERSPEED_BASE + (excess * FINE_OVERSPEED_PER_KMPH);
            totalFine += speedFine;
            violations.append(String.format(
                "- Overspeeding by %.1f km/h -> Fine: %.2f%n", excess, speedFine));
        }

        if (age < MIN_DRIVING_AGE) {
            totalFine += FINE_UNDERAGE;
            violations.append(String.format(
                "- Underage driving (age %d, minimum is %d) -> Fine: %.2f%n",
                age, MIN_DRIVING_AGE, FINE_UNDERAGE));
        }

        if (!validLicense) {
            totalFine += FINE_NO_LICENSE;
            violations.append(String.format(
                "- No valid license -> Fine: %.2f%n", FINE_NO_LICENSE));
        }

        if (!seatbeltWorn) {
            totalFine += FINE_NO_SEATBELT;
            violations.append(String.format(
                "- Seatbelt not worn -> Fine: %.2f%n", FINE_NO_SEATBELT));
        }

        System.out.println("\n===== TRAFFIC VIOLATION REPORT =====");
        System.out.println("Vehicle Number   : " + vehicleNumber);
        System.out.println("Emergency Vehicle: " + (isEmergencyVehicle ? "Yes" : "No"));
        System.out.println("Speed / Limit    : " + speed + " / " + speedLimit + " km/h");
        System.out.println("Driver Age       : " + age);
        System.out.println("Valid License    : " + (validLicense ? "Yes" : "No"));
        System.out.println("Seatbelt Worn    : " + (seatbeltWorn ? "Yes" : "No"));
        System.out.println("-------------------------------------");

        if (totalFine == 0.0) {
            System.out.println("No violations found. Drive safe!");
        } else {
            System.out.println("Violations Found:");
            System.out.print(violations);
            System.out.printf("TOTAL FINE: %.2f%n", totalFine);
        }
        System.out.println("=====================================");
    }
}