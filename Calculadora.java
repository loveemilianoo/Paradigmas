
public class Calculadora{
    private double resultado;
    
    public Calculadora (double resultado){
        this.resultado= 0;
    }

    public double suma(double num1, double num2){
        resultado= 0;
        resultado = num1 + num2;
        return resultado;
    }

    public double resta(double num1, double num2){
        resultado=0;
        resultado = num1- num2;
        return resultado;
    }

    public double multiplicar (double num1, double num2){
        resultado=0;
        resultado= num1 * num2;
        return resultado;
    }

    public double dividir (double num1, double num2){
        resultado=0;
        if (num2 ==0){
            resultado = -1;
            return resultado;
        } else {
            resultado = 0;
            resultado = num1/num2;
            return resultado;
        }
    }

    public double potencia (double num1, double num2){
        resultado =0;
        resultado = Math.pow(num1, num2);
        return resultado;
    }
}