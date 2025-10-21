import java.util.*;

public class test2 {
    public static void main(String[] args) {
        String details;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter roll");
        details = sc.nextLine();
        System.out.println("Enter marks");
        details = details + " Phys " + sc.nextLine();
        System.out.println("Enter marks");
        details = details + " Chem " + sc.nextLine();
        System.out.println("Enter marks");
        details = details + " Math " + sc.nextLine();
        System.out.println("Enter name");
        details = details + " " + sc.nextLine();

        System.out.println(details);
        int posPhysSpace = details.indexOf(' ', details.indexOf("Phys") + 5);
        int phys = Integer.parseInt(details.substring(details.indexOf("Phys") + 5, posPhysSpace));

        // Chemistry marks
        int posChemSpace = details.indexOf(' ', details.indexOf("Chem") + 5);
        int chem = Integer.parseInt(details.substring(details.indexOf("Chem") + 5, posChemSpace));

        // Maths marks
        int posMathSpace = details.indexOf(' ', details.indexOf("Math") + 5);
        if (posMathSpace == -1)
            posMathSpace = details.length(); // in case name follows without space
        int math = Integer.parseInt(details.substring(details.indexOf("Math") + 5, posMathSpace));

        // Average
        double average = (phys + chem + math) / 3.0;

        System.out.println("Physics: " + phys);
        System.out.println("Chemistry: " + chem);
        System.out.println("Maths: " + math);
        System.out.println("Average: " + average);
    }
}
