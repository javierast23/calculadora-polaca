package calculadoraRevisted;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String expresion;
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa una expresion: ");
        expresion = sc.nextLine();

        String [] cadenaIngresada = expresion.split(" ");

        Calculadora r = new Calculadora(cadenaIngresada);

        System.out.println("\nResultado: " + r.calculadora());
    }
}
