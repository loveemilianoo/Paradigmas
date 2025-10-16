import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculadora cal= new Calculadora(0);

        System.out.println("##### Programa de calculadora ##### \nEscoje la operación a realizar");
        int opci= 0;

        while (opci != 6) {
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Potenciar");
            System.out.println("6. Salir");
            opci= sc.nextInt();

            switch (opci) {
                case 1:
                    System.out.println("Ingresa el primer número");
                    double num1= sc.nextDouble();
                    System.out.println("Ingresa el segundo número");
                    double num2= sc.nextDouble();
                    System.out.println("RESULTADO: "+cal.suma(num1, num2));
                    break;
                case 2:
                    System.out.println("Ingresa el primer número");
                    num1= sc.nextDouble();
                    System.out.println("Ingresa el segundo número");
                    num2= sc.nextDouble();
                    System.out.println("RESULTADO: "+cal.resta(num1, num2));
                    break;
                case 3:
                    System.out.println("Ingresa el primer número");
                    num1= sc.nextDouble();
                    System.out.println("Ingresa el segundo número");
                    num2= sc.nextDouble();
                    System.out.println("RESULTADO: "+cal.multiplicar(num1, num2));
                    break;
                case 4:
                    System.out.println("Ingresa el primer número");
                    num1= sc.nextDouble();
                    System.out.println("Ingresa el segundo número");
                    num2= sc.nextDouble();
                    System.out.println("RESULTADO: "+cal.dividir(num1, num2));
                    break;
                case 5:
                    System.out.println("Ingresa el primer número");
                    num1= sc.nextDouble();
                    System.out.println("Ingresa el segundo número");
                    num2= sc.nextDouble();
                    System.out.println("RESULTADO: "+cal.potencia(num1, num2));
                    break;
                case 6:
                    System.out.println("Cerrando...");
                    break;
                default:
                    System.out.println("Valor no valido");
                    break;
            }
        }
        sc.close();
    }
}