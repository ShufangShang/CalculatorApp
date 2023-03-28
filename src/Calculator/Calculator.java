package Calculator;

public class Calculator {
    private double num1;

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum1() {
        return num1;
    }

    private double num2;

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getNum2() {
        return num2;
    }

    public Calculator()
    {
        this.num1 =0.0;
        this.num2 = 0.0;
    }

    public Calculator(Double number1, Double number2)
    {
        this.num1 = number1;
        this.num2 = number2;
    }

    public Calculator(Double number1)
    {
        this.num1 = number1;
        this.num2 = 0;
    }


    public Double add ()
    {
        return this.num1 + this.num2;
    }

    public Double subtract()
    {
        return this.num1 - this.num2;
    }

    public Double multiply()
    {
        return this.num1 * this.num2;
    }

    public Double divide ()
    {
        return this.num1 / this.num2;
    }

    public Double square ()
    {
        return this.num1 * this.num1;
    }    
}
