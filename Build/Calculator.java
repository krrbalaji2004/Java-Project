import java.util.Scanner;
import java.lang.Math;

public class Calculator {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        
        while (running) {
            displayMenu();
            int choice = getUserChoice();
            
            if (choice == 0) {
                running = false;
                System.out.println("Thank you for using the Advanced Calculator!");
                continue;
            }
            
            performOperation(choice);
        }
        
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("\n=== Advanced Calculator ===");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Square Root");
        System.out.println("6. Power");
        System.out.println("7. Logarithm (base 10)");
        System.out.println("8. Sine");
        System.out.println("9. Cosine");
        System.out.println("10. Tangent");
        System.out.println("11. Natural Logarithm");
        System.out.println("12. Absolute Value");
        System.out.println("13. Floor");
        System.out.println("14. Ceiling");
        System.out.println("15. Round");
        System.out.println("16. Random Number");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
    
    private static int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }
    
    private static void performOperation(int choice) {
        double result = 0;
        double num1, num2;
        
        try {
            switch (choice) {
                case 1: // Addition
                    System.out.print("Enter first number: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = scanner.nextDouble();
                    result = add(num1, num2);
                    System.out.printf("Result: %.2f + %.2f = %.2f%n", num1, num2, result);
                    break;
                    
                case 2: // Subtraction
                    System.out.print("Enter first number: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = scanner.nextDouble();
                    result = subtract(num1, num2);
                    System.out.printf("Result: %.2f - %.2f = %.2f%n", num1, num2, result);
                    break;
                    
                case 3: // Multiplication
                    System.out.print("Enter first number: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = scanner.nextDouble();
                    result = multiply(num1, num2);
                    System.out.printf("Result: %.2f * %.2f = %.2f%n", num1, num2, result);
                    break;
                    
                case 4: // Division
                    System.out.print("Enter first number: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = scanner.nextDouble();
                    if (num2 == 0) {
                        throw new ArithmeticException("Cannot divide by zero!");
                    }
                    result = divide(num1, num2);
                    System.out.printf("Result: %.2f / %.2f = %.2f%n", num1, num2, result);
                    break;
                    
                case 5: // Square Root
                    System.out.print("Enter a number: ");
                    num1 = scanner.nextDouble();
                    if (num1 < 0) {
                        throw new ArithmeticException("Cannot calculate square root of negative number!");
                    }
                    result = squareRoot(num1);
                    System.out.printf("Result: √%.2f = %.2f%n", num1, result);
                    break;
                    
                case 6: // Power
                    System.out.print("Enter base: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter exponent: ");
                    num2 = scanner.nextDouble();
                    result = power(num1, num2);
                    System.out.printf("Result: %.2f ^ %.2f = %.2f%n", num1, num2, result);
                    break;
                    
                case 7: // Logarithm
                    System.out.print("Enter a number: ");
                    num1 = scanner.nextDouble();
                    if (num1 <= 0) {
                        throw new ArithmeticException("Cannot calculate logarithm of non-positive number!");
                    }
                    result = logarithm(num1);
                    System.out.printf("Result: log10(%.2f) = %.2f%n", num1, result);
                    break;
                    
                case 8: // Sine
                    System.out.print("Enter angle in degrees: ");
                    num1 = scanner.nextDouble();
                    result = sine(num1);
                    System.out.printf("Result: sin(%.2f°) = %.2f%n", num1, result);
                    break;
                    
                case 9: // Cosine
                    System.out.print("Enter angle in degrees: ");
                    num1 = scanner.nextDouble();
                    result = cosine(num1);
                    System.out.printf("Result: cos(%.2f°) = %.2f%n", num1, result);
                    break;
                    
                case 10: // Tangent
                    System.out.print("Enter angle in degrees: ");
                    num1 = scanner.nextDouble();
                    result = tangent(num1);
                    System.out.printf("Result: tan(%.2f°) = %.2f%n", num1, result);
                    break;
                    
                case 11: // Natural Logarithm
                    System.out.print("Enter a number: ");
                    num1 = scanner.nextDouble();
                    if (num1 <= 0) {
                        throw new ArithmeticException("Cannot calculate natural logarithm of non-positive number!");
                    }
                    result = naturalLog(num1);
                    System.out.printf("Result: ln(%.2f) = %.2f%n", num1, result);
                    break;
                    
                case 12: // Absolute Value
                    System.out.print("Enter a number: ");
                    num1 = scanner.nextDouble();
                    result = absolute(num1);
                    System.out.printf("Result: |%.2f| = %.2f%n", num1, result);
                    break;
                    
                case 13: // Floor
                    System.out.print("Enter a number: ");
                    num1 = scanner.nextDouble();
                    result = floor(num1);
                    System.out.printf("Result: floor(%.2f) = %.2f%n", num1, result);
                    break;
                    
                case 14: // Ceiling
                    System.out.print("Enter a number: ");
                    num1 = scanner.nextDouble();
                    result = ceiling(num1);
                    System.out.printf("Result: ceil(%.2f) = %.2f%n", num1, result);
                    break;
                    
                case 15: // Round
                    System.out.print("Enter a number: ");
                    num1 = scanner.nextDouble();
                    result = round(num1);
                    System.out.printf("Result: round(%.2f) = %.2f%n", num1, result);
                    break;
                    
                case 16: // Random Number
                    System.out.print("Enter minimum value: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter maximum value: ");
                    num2 = scanner.nextDouble();
                    if (num1 >= num2) {
                        throw new ArithmeticException("Minimum value must be less than maximum value!");
                    }
                    result = random(num1, num2);
                    System.out.printf("Result: Random number between %.2f and %.2f = %.2f%n", num1, num2, result);
                    break;
                    
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input! Please enter valid numbers.");
            scanner.nextLine(); // Clear the input buffer
        }
    }
    
    // Basic arithmetic operations
    private static double add(double a, double b) {
        return a + b;
    }
    
    private static double subtract(double a, double b) {
        return a - b;
    }
    
    private static double multiply(double a, double b) {
        return a * b;
    }
    
    private static double divide(double a, double b) {
        return a / b;
    }
    
    // Advanced mathematical operations
    private static double squareRoot(double a) {
        return Math.sqrt(a);
    }
    
    private static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
    
    private static double logarithm(double a) {
        return Math.log10(a);
    }
    
    private static double sine(double degrees) {
        return Math.sin(Math.toRadians(degrees));
    }
    
    private static double cosine(double degrees) {
        return Math.cos(Math.toRadians(degrees));
    }
    
    private static double tangent(double degrees) {
        return Math.tan(Math.toRadians(degrees));
    }
    
    // Additional advanced mathematical operations
    private static double naturalLog(double a) {
        return Math.log(a);
    }
    
    private static double absolute(double a) {
        return Math.abs(a);
    }
    
    private static double floor(double a) {
        return Math.floor(a);
    }
    
    private static double ceiling(double a) {
        return Math.ceil(a);
    }
    
    private static double round(double a) {
        return Math.round(a);
    }
    
    private static double random(double min, double max) {
        return min + (Math.random() * (max - min));
    }
} 