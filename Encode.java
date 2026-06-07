import java.util.Scanner;

public class Encode {

    static boolean negative = false;

    public boolean inputCheck(String num, int type) {
        if (type == 1) {
            for (int i = 0; i < num.length() - 1; i++) {
                if (num.charAt(i) != '0' || num.charAt(i) != '1')
                    return false;

            }

        } else if (type == 2) {
            for (int i = 0; i < num.length() - 1; i++) {
                if (!(num.charAt(i) >= '0' &&
                        num.charAt(i) <= '9')) {

                    return false;
                }
            }
        } else if (type == 3) {
            for (int i = 0; i < num.length(); i++) {

                if (!(num.charAt(i) >= '0' &&
                        num.charAt(i) <= '7')) {

                    return false;
                }
            }
        } else if (type == 4) {
            num = num.toUpperCase();

            for (int i = 0; i < num.length(); i++) {

                if (!((num.charAt(i) >= '0' &&
                        num.charAt(i) <= '9') ||

                        (num.charAt(i) >= 'A' &&
                                num.charAt(i) <= 'F'))) {

                    return false;
                }
            }
        }

        return true;

    }

    public String twosCompliment(String bi) {
        String tcomp = "";
        int firstone = bi.lastIndexOf('1');
        for (int i = bi.length() - 1; i >= 0; i--) {
            if (i >= firstone) {
                tcomp = bi.charAt(i) + tcomp;

            } else if ((i < firstone)) {
                if (bi.charAt(i) == '1') {
                    tcomp = '0' + tcomp;
                } else {
                    tcomp = '1' + tcomp;
                }
            }
        }
        return tcomp;
    }

    public String binaryToOther(String num, int choice) {
        String result = "";
        int i;
        if (choice == 1) {
            int decimal = 0;
            for (i = 0; i < num.length(); i++) {

                decimal += (int) ((num.charAt(i) - '0') * Math.pow(2, num.length() - 1 - i));

            }
            result = String.valueOf(decimal);
        }
        if (choice == 2) {
            while (num.length() % 3 != 0) {
                num = "0" + num;
            }

            for (i = 0; i < num.length(); i += 3) {

                int value = (num.charAt(i) - '0') * 4 +
                        (num.charAt(i + 1) - '0') * 2 +
                        (num.charAt(i + 2) - '0');

                result += value;
            }
        } else if (choice == 3) {

            while (num.length() % 4 != 0) {
                num = "0" + num;
            }

            char hexChars[] = {
                    '0', '1', '2', '3',
                    '4', '5', '6', '7',
                    '8', '9', 'A', 'B',
                    'C', 'D', 'E', 'F'
            };

            for (i = 0; i < num.length(); i += 4) {

                int value = (num.charAt(i) - '0') * 8 +
                        (num.charAt(i + 1) - '0') * 4 +
                        (num.charAt(i + 2) - '0') * 2 +
                        (num.charAt(i + 3) - '0');

                result += hexChars[value];
            }
        }
        return result;
    }

    public String otherToBinary(String num, int choice) {

        String result = "";

        if (choice == 1) {

            int n = Integer.parseInt(num);

            while (n > 0) {
                result = (n % 2) + result;
                n /= 2;
            }
        }

        else if (choice == 2) {

            for (int i = 0; i < num.length(); i++) {

                char ch = num.charAt(i);

                switch (ch) {

                    case '0':
                        result += "000";
                        break;

                    case '1':
                        result += "001";
                        break;

                    case '2':
                        result += "010";
                        break;

                    case '3':
                        result += "011";
                        break;

                    case '4':
                        result += "100";
                        break;

                    case '5':
                        result += "101";
                        break;

                    case '6':
                        result += "110";
                        break;

                    case '7':
                        result += "111";
                        break;
                }
            }
        }

        else if (choice == 3) {

            num = num.toUpperCase();

            for (int i = 0; i < num.length(); i++) {

                char ch = num.charAt(i);

                switch (ch) {

                    case '0':
                        result += "0000";
                        break;

                    case '1':
                        result += "0001";
                        break;

                    case '2':
                        result += "0010";
                        break;

                    case '3':
                        result += "0011";
                        break;

                    case '4':
                        result += "0100";
                        break;

                    case '5':
                        result += "0101";
                        break;

                    case '6':
                        result += "0110";
                        break;

                    case '7':
                        result += "0111";
                        break;

                    case '8':
                        result += "1000";
                        break;

                    case '9':
                        result += "1001";
                        break;

                    case 'A':
                        result += "1010";
                        break;

                    case 'B':
                        result += "1011";
                        break;

                    case 'C':
                        result += "1100";
                        break;

                    case 'D':
                        result += "1101";
                        break;

                    case 'E':
                        result += "1110";
                        break;

                    case 'F':
                        result += "1111";
                        break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Encode ob = new Encode();

        String num;
        int type;
        int choice;

        while (true) {

            negative = false;

            System.out.println("\n===== NUMBER SYSTEM CONVERTER =====");

            System.out.println("Enter a Number (0 to Exit): ");
            num = sc.next();

            if (num.equals("0")) {
                System.out.println("Program Ended.");
                break;
            }

            System.out.println("\nInput Type:");
            System.out.println("1. Binary");
            System.out.println("2. Decimal");
            System.out.println("3. Octal");
            System.out.println("4. Hexadecimal");

            type = sc.nextInt();
            if (type == 1) {

                System.out.println("Is The Binary Number in 2's Complement Form (Negative)");
                System.out.println("1. Yes");
                System.out.println("2. No");

                int signChoice = sc.nextInt();

                if (signChoice == 1) {
                    negative = true;
                    num = ob.twosCompliment(num);
                }
            }

            else if (num.startsWith("-")) {

                negative = true;
                num = num.substring(1);
            }
            if (!ob.inputCheck(num, type)) {

                System.out.println("Invalid Input!");
                return;
            }

            while (true) {

                System.out.println("\n===== CONVERSION OPTIONS =====");

                if (type == 1) {

                    System.out.println("1. Decimal");
                    System.out.println("2. Octal");
                    System.out.println("3. Hexadecimal");
                }

                else if (type == 2) {

                    System.out.println("1. Binary");
                    System.out.println("2. Octal");
                    System.out.println("3. Hexadecimal");
                }

                else if (type == 3) {

                    System.out.println("1. Binary");
                    System.out.println("2. Decimal");
                    System.out.println("3. Hexadecimal");
                }

                else if (type == 4) {

                    System.out.println("1. Binary");
                    System.out.println("2. Decimal");
                    System.out.println("3. Octal");
                }

                System.out.println("4. Change Input");
                System.out.println("0. Exit");

                choice = sc.nextInt();

                if (choice == 0) {

                    System.out.println("Program Ended.");
                    System.exit(0);
                }

                else if (choice == 4) {
                    break;
                }

                if (type == 1) {

                    if (choice == 1) {

                        System.out.println("Decimal = "
                                + (negative ? "-" : "")
                                + ob.binaryToOther(num, 1));
                    }

                    else if (choice == 2) {

                        System.out.println("Octal = "
                                + (negative ? "-" : "")
                                + ob.binaryToOther(num, 2));
                    }

                    else if (choice == 3) {

                        System.out.println("Hexadecimal = "
                                + (negative ? "-" : "")
                                + ob.binaryToOther(num, 3));
                    }
                }

                else if (type == 2) {

                    String binary = ob.otherToBinary(num, 1);

                    if (choice == 1) {

                        if (negative) {
                            binary = ob.twosCompliment(binary);
                        }
                        System.out.println("Binary = " + binary);
                    }

                    else if (choice == 2) {

                        System.out.println("Octal = "
                                + (negative ? "-" : "")
                                + ob.binaryToOther(binary, 2));
                    }

                    else if (choice == 3) {

                        System.out.println("Hexadecimal = "
                                + (negative ? "-" : "")
                                + ob.binaryToOther(binary, 3));
                    }
                }

                else if (type == 3) {

                    String binary = ob.otherToBinary(num, 2);

                    if (choice == 1) {

                        if (negative) {
                            binary = ob.twosCompliment(binary);
                        }
                        System.out.println("Binary = " + binary);
                    }

                    else if (choice == 2) {

                        System.out.println("Decimal = "
                                + (negative ? "-" : "")
                                + ob.binaryToOther(binary, 1));
                    }

                    else if (choice == 3) {

                        System.out.println("Hexadecimal = "
                                + (negative ? "-" : "")
                                + ob.binaryToOther(binary, 3));
                    }
                }

                else if (type == 4) {

                    String binary = ob.otherToBinary(num, 3);

                    if (choice == 1) {

                        if (negative) {
                            binary = ob.twosCompliment(binary);
                        }
                        System.out.println("Binary = " + binary);
                    }

                    else if (choice == 2) {

                        System.out.println("Decimal = "
                                + (negative ? "-" : "")
                                + ob.binaryToOther(binary, 1));
                    }

                    else if (choice == 3) {

                        System.out.println("Octal = "
                                + (negative ? "-" : "")
                                + ob.binaryToOther(binary, 2));
                    }
                }
            }
        }
    }

}
