package MagicCalculator;

import Calculator.Calculator;
import java.lang.Math;

public class MagicCalculator extends Calculator {
    //private double num;
    
   /*  public void setNum(double number) {
        this.num = number;
    }

    public double getNum() {
        return this.num;
    } */

    public MagicCalculator(){
        super();
        //this.num = 0.0;
    }
  

    public MagicCalculator(Double number){
        super(number);        
    }

    public MagicCalculator(Double number1, Double number2){
        super(number1, number2);
    }
            
    
    public Double sin()
    {
        double randian = Math.toRadians(super.getNum1());
        return Math.sin(randian);
    }

    public Double cos()
    {
        double randian = Math.toRadians(super.getNum1());
        return Math.cos(randian);
    }

    public Double tan()
    {
        double randian = Math.toRadians(super.getNum1());
        return Math.tan(randian);
    }

    public Double squreRoot()
    {
       return Math.sqrt(super.getNum1());
    }   

}
