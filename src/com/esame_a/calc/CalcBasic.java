package com.esame_a.calc;

import java.util.Scanner;

import static java.lang.System.*;

public class CalcBasic {

    private double doCalc(double a, double b, String operator){
        double result;
        switch (operator){
            case "*": {
                result = a*b;
                break;
            }

            case "+" : {
                result = a + b;
                break;
            }

            case "-": {
                result = a-b;
                break;
            }
            case "/": {
                result = a/b;
                break;
            }
            case "ln" :{
                result = Math.log(a);
                break;
            }

            case "^" :{
                result = Math.pow(a,b);
                break;
            }
            default: throw new IllegalArgumentException("Operazione non valida!");

        }
        return result;
    }

    public void calculator(){
        Scanner scanner = new Scanner(in);
        do {
            try {
                out.println("""
                        Scegli l'operazione da eseguire:
                        +, -, *, /, ln, ^ o 'exit' per uscire
                        """);
                String operator = scanner.nextLine();
                if (operator.equals("exit"))
                    break;
                out.println("""
                        Inserisci il numero (o i numeri) su cui eseguire l'operazione (es.: 12.45 4.12)
                        """);
                String twoNumbers = scanner.nextLine();
                if (twoNumbers.split(" ").length != 2 ){
                    if (!operator.equals("ln")) {
                        err.println("Input non valido, riprovare" + "\n");
                    }
                    else {
                        double res = this.doCalc(Double.parseDouble(twoNumbers.split(" ")[0]),  0, "ln");
                        out.println("Il risultato è: " + res + "\n");
                    }
                }
                else {
                 String[] numbers = twoNumbers.split(" ");
                 double res = this.doCalc(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]), operator);
                 out.println("Il risultato è: " + res + "\n");
                }
            }catch (NumberFormatException e){
                err.println("Numero inserito non valido!" + "\n");
            }catch (IllegalArgumentException | ArithmeticException e){
                err.println("Operazione non valida o operatore scorretto" + "\n");
            }
        } while (true);
    }

    public static void main(String[] args) {
        CalcBasic calcBasic = new CalcBasic();
        calcBasic.calculator();
    }
}
