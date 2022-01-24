
package numeros;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Daniel Miranda
 */

public class Numeros {
        public static int pedirNumero(String mensaje) {
        int numero = 0;
        Scanner teclado = new Scanner(System.in);
        boolean estado = true;

        while (estado) {
            try {
                System.out.print(mensaje + "\t");
                numero = teclado.nextInt();
                estado = false;
            } catch (InputMismatchException exception) {
                System.out.println("Introduce valores numericos");
                teclado.nextLine();
            }
        }
        return numero;
    }

    public static int pedirNumero(String mensaje, int limiteInferior) {
        int numero = 0;
        Scanner teclado = new Scanner(System.in);
        boolean estado = true;

        while (estado) {
            try {
                System.out.print(mensaje + "\t");
                numero = teclado.nextInt();
                if (numero < limiteInferior) {
                    System.out.println("El numero no puede ser mas pequeño que: " + limiteInferior);
                } else {
                    estado = false;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Introduce valores numericos");
                teclado.nextLine();
            }
        }
        return numero;
    }

    public static int pedirNumero(String mensaje, int limiteInferior, int limiteSuperior) {
        int numero = 0;
        Scanner teclado = new Scanner(System.in);
        boolean estado = true;

        while (estado) {
            try {
                System.out.print(mensaje + "\t");
                numero = teclado.nextInt();
                if (numero < limiteInferior || numero > limiteSuperior) {
                    System.out.println("El numero no puede ser mas pequeño que: " + limiteInferior + " ni mas grande que: " + limiteSuperior);
                } else {
                    estado = false;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Introduce valores numericos");
                teclado.nextLine();
            }
        }
        return numero;
    }

    public static float pedirNumeroReal(String mensaje) {
        float numero = 0;
        Scanner teclado = new Scanner(System.in);
        boolean estado = true;

        while (estado) {
            try {
                System.out.print(mensaje + "\t");
                numero = teclado.nextFloat();
                estado = false;
            } catch (InputMismatchException exception) {
                System.out.println("Introduce valores numericos");
                teclado.nextLine();
            }
        }
        return numero;
    }

    public static float pedirNumeroReal(String mensaje, float limiteInferior) {
        float numero = 0;
        Scanner teclado = new Scanner(System.in);
        boolean estado = true;

        while (estado) {
            try {
                System.out.print(mensaje + "\t");
                numero = teclado.nextFloat();
                if (numero < limiteInferior) {
                    System.out.println("El numero no puede ser mas pequeño que: " + limiteInferior);
                } else {
                    estado = false;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Introduce valores numericos");
                teclado.nextLine();
            }
        }
        return numero;
    }

    public static float pedirNumeroReal(String mensaje, float limiteInferior, float limiteSuperior) {
        float numero = 0;
        Scanner teclado = new Scanner(System.in);
        boolean estado = true;

        while (estado) {
            try {
                System.out.print(mensaje + "\t");
                numero = teclado.nextFloat();
                if (numero < limiteInferior || numero > limiteSuperior) {
                    System.out.println("El numero no puede ser mas pequeño que: " + limiteInferior + " ni mas grande que: " + limiteSuperior);
                } else {
                    estado = false;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Introduce valores numericos");
                teclado.nextLine();
            }
        }
        return numero;
    }
}
