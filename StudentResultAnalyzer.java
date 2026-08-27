import java.util.Scanner;

public class StudentResultAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student's name: ");
        String name = sc.next();

        System.out.print("Enter marks in Subject 1: ");
        int marks1 = sc.nextInt();
        System.out.print("Enter marks in Subject 2: ");
        int marks2 = sc.nextInt();
        System.out.print("Enter marks in Subject 3: ");
        int marks3 = sc.nextInt();

        int total = marks1 + marks2 + marks3;
        double average = total / 3.0;

        boolean passed = marks1 >= 35 && marks2 >= 35 && marks3 >= 35;
        boolean distinction = passed && average >= 75;
        boolean specialAward = passed && average >= 90;

        System.out.println("\n----- Student Result -----");
        System.out.println("Name: " + name);
        System.out.println("Total Marks: " + total);
        System.out.println("Average: " + average);

        if (passed) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }

        if (distinction) {
            System.out.println("Distinction: YES");
        } else {
            System.out.println("Distinction: NO");
        }

        if (specialAward) {
            System.out.println("Special Award: YES - Outstanding Performance!");
        } else {
            System.out.println("Special Award: NO");
        }

        sc.close();
    }
}