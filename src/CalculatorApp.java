import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

import MagicCalculator.MagicCalculator;

public class CalculatorApp {
    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to use the Magic Calculator!");
        Scanner input = new Scanner(System.in);
        Boolean done = false;
        do {
            Boolean validInput = false;
            char operator;

            // Get the user's input for the operation to perform and validate the input
            // operator
            do {
                System.out.println("please enter a valid operator from the following list:");
                System.out.println("+ for addition");
                System.out.println("- for subtraction");
                System.out.println("* for multiplication");
                System.out.println("/ for division");
                System.out.println("^ for squre");
                System.out.println("s for sin");
                System.out.println("c for cosine");
                System.out.println("t for tangent");
                System.out.println("r for squre root");
                System.out.println("! for factorial");

                operator = (char) input.next().charAt(0);

                // validate the user's input to make sure the input is valid

                validInput = isValidOperator(operator);

            } while (validInput == false);

            Double inputNumber1 = 0.0;
            Double inputNumber2 = 0.0;
            if (isUnaryOperator(operator)) {
                // Get the operand and validate the input
                System.out.println("Please enter the operand (a number) for the selected operator:");
                while (!input.hasNextDouble()) {
                    System.out.println("Please enter a valid operand (a number) for the selected operator:");
                    input.next();
                }
                inputNumber1 = input.nextDouble();
            } else {
                // Get the first operand and validate the input
                System.out.println("Please enter the first operand (a number) for the selected operator:");
                while (!input.hasNextDouble()) {
                    System.out.println("Please enter a valid first operand (a number) for the selected operator:");
                    input.next();
                }

                inputNumber1 = input.nextDouble();

                // Get the second operand and validate the input
                System.out.println("Please enter the second operand (a number) for the selected operator:");
                while (!input.hasNextDouble()) {
                    System.out.println("Please enter an valid second operand (a number) for the selected operator:");
                    input.next();
                }
                inputNumber2 = input.nextDouble();
            }

            // Perform the operation accordingly
            switch (operator) {
                case '+':
                    Double sum = addition(inputNumber1, inputNumber2);
                    System.out.printf("The sum of %.2f and %.2f is %.2f.", inputNumber1, inputNumber2, sum);
                    break;

                case '-':
                    Double diff = subtraction(inputNumber1, inputNumber2);
                    System.out.printf("The difference of %.2f and %.2f is %.2f.", inputNumber1, inputNumber2, diff);
                    break;

                case '*':
                    Double prod = multiplication(inputNumber1, inputNumber2);
                    System.out.printf("The product of %.2f and %.2f is %.2f.", inputNumber1, inputNumber2, prod);
                    break;

                case '/':
                    // Make sure the divider is not 0
                    Boolean invalidDivider = false;
                    if (inputNumber2 == 0.0) {
                        System.out.println("The divider cannot be zero!");
                        invalidDivider = true;
                    }

                    // Prompt for the non-zero divider
                    while (invalidDivider == true) {
                        try {
                            System.out.println("Please enter a non-zero number for the divider:");

                            while (!input.hasNextDouble()) {
                                System.out.println("Please enter a non-zero number for the divider:");
                                input.next();
                            }
                            inputNumber2 = input.nextDouble();
                            if (inputNumber2 != 0.0) {
                                invalidDivider = false;
                            }
                        } catch (Exception e) {
                            invalidDivider = true;
                        }
                    }

                    Double quot = division(inputNumber1, inputNumber2);
                    System.out.printf("The quotient of %.2f divided by %.2f is %.2f.", inputNumber1, inputNumber2,
                            quot);
                    break;

                case '^':
                    Double sqr = findSquare(inputNumber1);
                    System.out.printf("The squre of %.2f is %.2f.", inputNumber1, sqr);
                    break;

                case 's':
                    Double sinVal = findSine(inputNumber1);
                    System.out.printf("The sin of %.2f is %.2f.", inputNumber1, sinVal);
                    break;

                case 'c':
                    Double cosVal = findCosine(inputNumber1);
                    System.out.printf("The cosine of %.2f angle is %.2f.", inputNumber1, cosVal);
                    break;

                case 't':
                    //Check to see if the tangent value of the operand entered is undefined
                    Double cos = findCosine(inputNumber1);                  
                    BigDecimal bigCos = new BigDecimal(cos).setScale(1,RoundingMode.HALF_DOWN);
                    BigDecimal bigZero = new BigDecimal("0.0").setScale(1,RoundingMode.HALF_DOWN);
                    if(bigCos.compareTo(bigZero) == 0)
                    {
                        System.out.printf("The tangent of %.2f angle is undefined.", inputNumber1);
                    }
                    else{
                        Double tanVal = findTan(inputNumber1);
                        System.out.printf("The tangent of %.2f angle is %.2f.", inputNumber1, tanVal);
                    }
                    break;

                case 'r':
                    Boolean  invalidOperand = false;
                    if (inputNumber1 < 0.0) {
                        System.out.println("The operand cannot be a negative number!");
                        invalidOperand = true;
                    }

                    //Prompt for non-negative number
                    while (invalidOperand == true)
                    {
                        try{
                            System.out.println("Please enter a non-negative number to continue:");
                            while (!input.hasNextDouble()){
                                System.out.println("Please enter a non-negative number to continue:");
                                input.next();                              
                            }              
                            inputNumber1 = input.nextDouble(); 
                            if( inputNumber1 >= 0.0) {
                                invalidOperand = false;
                            } 
                        }
                        catch(Exception e)
                        {
                            invalidOperand = true;
                        }
                    }
                    Double sqrtVal = findSqrt(inputNumber1);
                    System.out.printf("The square root of %.2f is %.2f.", inputNumber1, sqrtVal);
                    break;

                default:
                    int number = inputNumber1.intValue();
                    int facVal = factorial(number);
                    System.out.printf("The factotial of %d is %d.", number, facVal);
                    break;
            }

            input.nextLine();// Read the line return from previous input
            System.out.println("\nDo you want to continue next calculation? (Y/N)");
            String response = input.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                done = false;
            } else {
                System.out.println("Done with calculation. Thanks for using the Calculator!");
                done = true;
            }

        } while (done == false);

        input.close();

    }

    //This function returns the sum of the two input values
    public static Double addition(Double operand1, Double Operand2) {
        MagicCalculator myCalculator = new MagicCalculator(operand1, Operand2);
        return myCalculator.add();
    }

    //This function returns the difference of the two input values
    public static Double subtraction(Double operand1, Double Operand2) {
        MagicCalculator myCalculator = new MagicCalculator(operand1, Operand2);
        return myCalculator.subtract();
    }

    //This function returns the product of the two input values
    public static Double multiplication(Double operand1, Double Operand2) {
        MagicCalculator myCalculator = new MagicCalculator(operand1, Operand2);
        return myCalculator.multiply();
    }

    //This function returns the quotient of the operand1 divided by Operand2
    public static Double division(Double operand1, Double Operand2) {
        MagicCalculator myCalculator = new MagicCalculator(operand1, Operand2);
        return myCalculator.divide();
    }

    //This function returns the squre of the operand
    public static Double findSquare(Double operand) {
        MagicCalculator myCalculator = new MagicCalculator(operand);
        return myCalculator.square();
    }

    //This function returns the squre of the squre root of the operand
    public static Double findSqrt(Double operand) {
        MagicCalculator myCalculator = new MagicCalculator(operand);
        return myCalculator.squreRoot();
    }

    //This function returns the sine value the operand
    public static Double findSine(Double operand) {
        MagicCalculator myCalculator = new MagicCalculator(operand);
        return myCalculator.sin();
    }

    //This function returns the cosine value the operand
    public static Double findCosine(Double operand) {
        MagicCalculator myCalculator = new MagicCalculator(operand);
        return myCalculator.cos();
    }

     //This function returns the tangent value the operand
    public static Double findTan(Double operand) {
        MagicCalculator myCalculator = new MagicCalculator(operand);
        return myCalculator.tan();
    }

    //This function returns the factorial of the operand
    public static int factorial(int n) {
        if (n == 0)
            return 1;
        else if (n > 0)
            return n * factorial(n - 1);
        else {
            return n * factorial(n + 1);
        }
    }

    // This function will check whether the input operator is a valid operator
    private static Boolean isValidOperator(char op) {
        Boolean retVal = false;
        char[] operatorArray = { '+', '-', '*', '/', '^', 's', 'c', 't', 'r', '!' };

        for (int i = 0; i < operatorArray.length; i++) {
            if (operatorArray[i] == op) {
                retVal = true;
                return retVal;
            }
        }

        return retVal;
    }

    // Check to see if the operator is an Unary operator
    private static Boolean isUnaryOperator(char op) {
        Boolean retVal = false;
        char[] operatorArray = { '^', 's', 'c', 't', 'r', '!' };

        for (int i = 0; i < operatorArray.length; i++) {
            if (operatorArray[i] == op) {
                retVal = true;
                return retVal;
            }
        }
        return retVal;
    }
}
