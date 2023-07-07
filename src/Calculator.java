import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {  //entry point of the program
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the first number: ");
            double num1 = getValidNumber(scanner);

            System.out.print("Enter the second number: ");
            double num2 = getValidNumber(scanner);

            System.out.print("Enter the operation (subtraction/division): ");
            String operation = scanner.nextLine().toLowerCase(); //convert to lowercase incase user enters upper case letters

            double result;
            switch (operation) {
                case "subtraction":
                    result = subtract(num1, num2); //call the subtract function
                    System.out.println("Result: " + result);
                    break;
                case "division":
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                    } else {
                        result = divide(num1, num2); //call the divide function
                        System.out.println("Result: " + result);
                    }
                    break;
                default:
                    System.out.println("Invalid operation.");
            }

            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String choice = scanner.nextLine().toLowerCase();
            if (!choice.equals("yes")) {
                break;
            }
        }

        scanner.close(); //close the Scanner object
    }

    private static double getValidNumber(Scanner scanner) {
        while (true) {     //even integers are valid because they can be represented as doubles without loss of precision.
            if (scanner.hasNextDouble()) { //hasNextDouble checks for a valid double
                double number = scanner.nextDouble(); //nextDouble consumes the double
                scanner.nextLine(); // Consume the newline character
                return number;
            } else {
                System.out.print("Invalid input. Enter a valid number: ");
                scanner.nextLine(); // Clear the input buffer
            }
        }
    }

    private static double subtract(double num1, double num2) {
        return num1 - num2;
    }
    private static double divide(double num1, double num2) {
        return num1 / num2;
    }
}
