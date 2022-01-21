package string;

import fecha.Fecha;
import java.util.Scanner;

/**
 *
 * @author Daniel Miranda Pérez
 */
public class Textos {

    public static String pedirString(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        String nombre;
        System.out.print(mensaje + "\t");
        nombre = teclado.nextLine();

        while (nombre.equals("")) {
            System.out.println("Dato requerido");
            System.out.print(mensaje + "\t");
            nombre = teclado.nextLine();
        }
        return nombre;
    }
    
    public static Fecha pedirFecha(String mensaje){
        // fintroducida = Fecha Introducida
        Fecha finIntroducida = new Fecha();
        
        String dato;
        dato = pedirString(mensaje);
        
        while (finIntroducida.validarFecha(dato) != 0 || finIntroducida.comprobarFechas(dato) !=0){
            System.out.println("Fecha incorrecta, Vuelva a introducirla");
            dato = pedirString(mensaje);
        }
        return finIntroducida;
    }
}
