package calculadoraRevisted;
import java.util.Stack;

public class Calculadora {

    private String [] cadenaIngresada;
    private Stack<String> pila;

    public Calculadora(String [] cadenaIngresada) {
        this.cadenaIngresada = cadenaIngresada;
        this.pila = new Stack();
    }

    public double calculadora(){
        String topElement, bottomElement;
        double result;

        for(String elemento: cadenaIngresada) {
            if(esOperador(elemento)) {
                topElement = pila.pop();
                if(pila.isEmpty()) {
                    System.out.println("Error, falta un elemento");
                    break;
                }
                bottomElement = pila.pop();
                result = operar(bottomElement, elemento, topElement);
                pila.push("" + result);
            } else {
                pila.push(elemento);
            }
        }
        return Double.parseDouble(pila.pop());
    }

    private double operar(String bottomElement, String elemento, String topElement) {
        double a = Double.parseDouble(bottomElement);
        double b = Double.parseDouble(topElement);

        switch (elemento) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: return -1;
        }
    }

    private boolean esOperador(String elemento) {
        return elemento.equals("+") || elemento.equals("-") || elemento.equals("*") ||
                elemento.equals("/");
    }
}
