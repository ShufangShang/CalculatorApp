import java.util.Scanner;
import Calculator.Calculator;

public class CalculatorApp {
    public static void main(String[] args) throws Exception {
       
        Scanner input = new Scanner (System.in);
        Boolean done = false;
        do {
            Boolean invalidInput = false;
            char operator;
            do{
                System.out.println("please enter an operator (+, -, *, /, ^) to continue:");
                operator = (char)input.next().charAt(0);
                if((operator != '+') && (operator != '-') && (operator != '*') && (operator != '/') && (operator != '^'))
                {
                    invalidInput = true;
                }
                else
                {
                    invalidInput = false;
                }
            } while (invalidInput == true); 

            Double inputNumber1 = 0.0;
            Double inputNumber2 = 0.0;
            if((operator == '^'))
            {
                System.out.println("Please input the number to be squred:");
                inputNumber1 = input.nextDouble();
            }
            else
            {
                System.out.println("Please input the first number:");
                inputNumber1 = input.nextDouble();
                System.out.println("Please input the second number:");
                inputNumber2 = input.nextDouble();
            }

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
                Double quot = division(inputNumber1, inputNumber2);
                System.out.printf("The quotient of %.2f divided by %.2f is %.2f.", inputNumber1, inputNumber2, quot);
                break;

                default:
                Double sqr = findSquare(inputNumber1);
                System.out.printf("The squre of %.2f is %.2f.", inputNumber1, sqr);
                break;
            }
            
            input.nextLine();// Read the line return from previous input
            System.out.println("\nDo you want to continue next calculation? (Y/N)");
            String response = input.nextLine();
            if(response.equalsIgnoreCase("Y"))
            {
                done = false;
            }
            else
            {
                System.out.println("Thanks for using the Calculator!");
                done = true;
            }
            
        }while (done == false);

        input.close();

    }

    private static Double addition (Double operand1, Double Operand2)
    {
        Calculator myCalculator = new Calculator(operand1,  Operand2);
        return myCalculator.add();
    }

    private static Double subtraction (Double operand1, Double Operand2)
    {
        Calculator myCalculator = new Calculator(operand1,  Operand2);
        return myCalculator.subtract();
    }

    private static Double multiplication (Double operand1, Double Operand2)
    {
        Calculator myCalculator = new Calculator(operand1,  Operand2);
        return myCalculator.multiply();
    }

    private static Double division (Double operand1, Double Operand2)
    {
        Calculator myCalculator = new Calculator(operand1,  Operand2);
        return myCalculator.divide();
    }

    private static Double findSquare (Double operand)
    {
        Calculator myCalculator = new Calculator(operand);
        return myCalculator.square();
    }
   
}
