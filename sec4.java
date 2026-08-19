import java.util.*;
public class sec4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.next();
        System.out.println("Enter your age: ");
        int age = sc.nextInt();
        System.out.println("Enter your roll no: ");
        int roll = sc.nextInt();
        System.out.println("Enter your marks : ");
        int marks = sc.nextInt();
        System.out.println(
                "Your name is " + name + ", your age is " + age + ", your roll no is " + roll + ", and your marks is " + marks);
    }
}