package model;

public class Model {

    public String calculation(double a, double b, String operator) {
        String result;
        switch (operator) {
            case "+":
                result = String.valueOf(a + b);
                break;
            case "-":
                result = String.valueOf(a - b);
                break;
            case "*":
                result = String.valueOf(a * b);
                break;
            case "/":
                if (b != 0)
                    result = String.valueOf(a / b);
                else
                    result = "Division by zero!";
                break;
            default:
                result = "Unknown operation!";
                break;
        }
        return result;
    }
    
}
