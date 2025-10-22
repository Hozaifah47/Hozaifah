import java.io.*;
import java.util.*;

public class StudentList {

    static String fileName = "Students.txt";
    static String fileTemp = "Temp.txt";
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);

    public static void main(String[] args) {
        int ch;
        Scanner sc = new Scanner(System.in);
        StudentList ob = new StudentList();
        do {
            System.out.println("Enter 0 to Terminate");
            System.out.println("Enter 1 to Add");
            System.out.println("Enter 2 to Edit");
            System.out.println("Enter 3 to Delete");
            System.out.println("Enter 4 to Display");
            System.out.println("Enter 5 to Display merit list");
            System.out.println("Enter 6 to Display all records");
            ch = sc.nextInt();
            switch (ch) {
                case 0:
                    break;
                case 1:
                    ob.add();
                    break;
                case 2:
                    ob.edit();
                    break;
                case 3:
                    ob.delete();
                    break;
                case 4:
                    ob.display();
                    break;

                case 5:
                    ob.meritList();
                    break;
                case 6:
                    ob.displayAll();
                    break;
                default:
                    System.out.println("Invalid input!");
                    return;

            }
        } while (ch != 0);

    }

    public void add() {
        String current;
        try {
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter outFile = new PrintWriter(bw);

            System.out.println("Enter roll (format AA1234):");
            current = br.readLine();

            if (!isValidRoll(current)) {
                System.out.println("Invalid roll number");
                return;
            }
            if (isRepeatRoll(current)) {
                System.out.println("Invalid Input!");
                return;

            }
            System.out.println("Enter marks of physics");
            current = current + " Phys " + br.readLine();

            if (isValidMarks(current)) {
                System.out.println("Invalid Input!");
                return;
            }

            System.out.println("Enter marks of chemistry");
            current = current + " Chem " + br.readLine();

            if (isValidMarks(current)) {
                System.out.println("Invalid Input!");
                return;
            }

            System.out.println("Enter marks of maths");
            current = current + " Math " + br.readLine();

            if (isValidMarks(current)) {
                System.out.println("Invalid Input!");
            }

            System.out.println("Enter name");
            current = current + " " + br.readLine();

            outFile.println(getAverage(current));

            outFile.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void edit() {
        String current, text;
        Scanner sc = new Scanner(System.in);
        try {

            FileReader frMain = new FileReader(fileName);
            BufferedReader brMain = new BufferedReader(frMain);

            FileWriter fwTemp = new FileWriter(fileTemp);
            BufferedWriter bwTemp = new BufferedWriter(fwTemp);
            PrintWriter outFileT = new PrintWriter(bwTemp);

            System.out.println("Enter roll number to edit (format AA1234):");
            String roll = sc.nextLine();
            if (!isValidRoll(roll)) {
                System.out.println("Invalid roll number");
                return;
            }
            boolean found = false;

            while ((current = brMain.readLine()) != null) {

                text = current.substring(0, 6);

                if (!text.equals(roll)) {
                    outFileT.println(current);
                } else {
                    found = true;
                    current = roll;

                    System.out.println("Enter marks of physics:");
                    current = current + " Phys " + br.readLine();

                    if (isValidMarks(current)) {
                        System.out.println("Invalid Input!");
                        return;
                    }

                    System.out.println("Enter marks of chemistry:");
                    current = current + " Chem " + br.readLine();

                    if (isValidMarks(current)) {
                        System.out.println("Invalid Input!");
                        return;
                    }

                    System.out.println("Enter marks of maths:");
                    current = current + " Math " + br.readLine();

                    if (isValidMarks(current)) {
                        System.out.println("Invalid Input!");
                        return;
                    }

                    System.out.println("Enter name:");
                    current = current + " " + br.readLine();

                    outFileT.println(getAverage(current));
                }
            }

            brMain.close();
            outFileT.close();

            FileReader frTemp = new FileReader(fileTemp);
            BufferedReader brTemp = new BufferedReader(frTemp);

            FileWriter fwMain = new FileWriter(fileName);
            BufferedWriter bwMain = new BufferedWriter(fwMain);
            PrintWriter mainWriter = new PrintWriter(bwMain);

            while ((current = brTemp.readLine()) != null) {
                mainWriter.println(current);
            }

            brTemp.close();
            mainWriter.close();

            if (found)
                System.out.println("Record updated successfully!");
            else
                System.out.println("Roll number not found!");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete() {
        String text, current;
        Scanner sc = new Scanner(System.in);
        try {

            FileReader frMain = new FileReader(fileName);
            BufferedReader brMain = new BufferedReader(frMain);

            FileWriter fwTemp = new FileWriter(fileTemp);
            BufferedWriter bwTemp = new BufferedWriter(fwTemp);
            PrintWriter outFileT = new PrintWriter(bwTemp);

            System.out.println("Enter roll number to edit (format AA1234):");
            String roll = sc.nextLine();
            if (!isValidRoll(roll)) {
                System.out.println("Invalid roll number");
                return;
            }
            boolean found = false;

            while ((current = brMain.readLine()) != null) {

                text = current.substring(0, 6);

                if (!text.equals(roll)) {
                    outFileT.println(current);
                } else {
                    found = true;
                }
            }

            brMain.close();
            outFileT.close();

            FileReader frTemp = new FileReader(fileTemp);
            BufferedReader brTemp = new BufferedReader(frTemp);

            FileWriter fwMain = new FileWriter(fileName);
            BufferedWriter bwMain = new BufferedWriter(fwMain);
            PrintWriter mainWriter = new PrintWriter(bwMain);

            while ((current = brTemp.readLine()) != null) {
                mainWriter.println(current);
            }

            brTemp.close();
            mainWriter.close();

            if (found)
                System.out.println("Record deleted successfully!");
            else
                System.out.println("Roll number not found!");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void display() {
        String current, text;
        Scanner sc = new Scanner(System.in);
        try {

            FileReader frMain = new FileReader(fileName);
            BufferedReader brMain = new BufferedReader(frMain);

            System.out.println("Enter roll number to display (format AA1234):");
            String roll = sc.nextLine();
            if (!isValidRoll(roll)) {
                System.out.println("Invalid roll number");
                return;
            }
            boolean found = false;

            while ((current = brMain.readLine()) != null) {

                text = current.substring(0, 6);

                if (text.equalsIgnoreCase(roll)) {

                    int posPhysSpace = current.indexOf(' ', current.indexOf("Phys") + 5);
                    int phys = Integer.parseInt(current.substring(current.indexOf("Phys") + 5, posPhysSpace));

                    int posChemSpace = current.indexOf(' ', current.indexOf("Chem") + 5);
                    int chem = Integer.parseInt(current.substring(current.indexOf("Chem") + 5, posChemSpace));

                    int posMathSpace = current.indexOf(' ', current.indexOf("Math") + 5);
                    int math = Integer.parseInt(current.substring(current.indexOf("Math") + 5, posMathSpace));

                    System.out.println(" Student Record ");
                    System.out.println(current);

                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Roll number not found!");
            }

            brMain.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getAverage(String current) {

        int posPhysSpace = current.indexOf(' ', current.indexOf("Phys") + 5);
        int phys = Integer.parseInt(current.substring(current.indexOf("Phys") + 5, posPhysSpace));

        int posChemSpace = current.indexOf(' ', current.indexOf("Chem") + 5);
        int chem = Integer.parseInt(current.substring(current.indexOf("Chem") + 5, posChemSpace));

        int posMathSpace = current.indexOf(' ', current.indexOf("Math") + 5);
        int math = Integer.parseInt(current.substring(current.indexOf("Math") + 5, posMathSpace));

        int average = (int) ((phys + chem + math) / 3.0);

        return current + " Avg " + average;
    }

    public void meritList() {
        try {

            FileReader frCount = new FileReader(fileName);
            BufferedReader brCount = new BufferedReader(frCount);

            int lines = 0;
            while (brCount.readLine() != null)
                lines++;
            brCount.close();

            if (lines == 0) {
                System.out.println("No student records found!");
                return;
            }

            String[] students = new String[lines];
            FileReader frMain = new FileReader(fileName);
            BufferedReader brMain = new BufferedReader(frMain);

            for (int i = 0; i < lines; i++) {
                students[i] = brMain.readLine();
            }
            brMain.close();

            for (int i = 0; i < students.length - 1; i++) {
                for (int j = 0; j < students.length - i - 1; j++) {
                    double avg1 = extractAverage(students[j]);
                    double avg2 = extractAverage(students[j + 1]);

                    if (avg1 < avg2) {

                        String temp = students[j];
                        students[j] = students[j + 1];
                        students[j + 1] = temp;
                    }
                }
            }

            System.out.println("  Merit List ");
            for (int i = 0; i < students.length; i++) {
                System.out.println(getAverage(students[i]));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public double extractAverage(String details) {
        int pos = details.lastIndexOf("Avg ");
        if (pos == -1)
            return 0;

        String avgStr = details.substring(pos + 4);
        return Double.parseDouble(avgStr);
    }

    public void displayAll() {
        String current;
        try {
            FileReader frMain = new FileReader(fileName);
            BufferedReader brMain = new BufferedReader(frMain);

            if (brMain.readLine() == null) {
                System.out.println("No student records found!");
                brMain.close();
                return;
            }

            frMain = new FileReader(fileName);
            brMain = new BufferedReader(frMain);

            System.out.println(" All Student Records ");
            while ((current = brMain.readLine()) != null) {
                System.out.println(current);
            }

            brMain.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean isValidRoll(String iden) {

        int num;
        if (iden.charAt(0) != 'A' || iden.length() != 6 || (int) iden.charAt(1) < 65 || (int) iden.charAt(1) > 90) {
            return false;
        }
        try

        {
            num = Integer.parseInt(iden.substring(2));
        } catch (Exception e) {
            return false;
        }

        return true;

    }

    public boolean isValidMarks(String mark) {
        int num;
        try {
            num = Integer.parseInt(mark.substring(mark.lastIndexOf(' ')));

        } catch (Exception e) {
            return false;
        }
        if (num > 100 || num < 0) {
            return false;
        }
        return true;

    }

    public boolean isRepeatRoll(String roll) {
        String current, text;
        try {
            FileReader frMain = new FileReader(fileName);
            BufferedReader brMain = new BufferedReader(frMain);

            while ((current = brMain.readLine()) != null) {
                text = current.substring(0, 6);
                if (text.equals(roll)) {
                    brMain.close();
                    return true;
                }
            }
            brMain.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

}
