package fecha;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Daniel Miranda Pérez
 */
public class Fecha {

    private int dia;
    private int mes;
    private int anno;
    // Variables creadas para guardar el dia, mes, anno actual si reemplazarlo
    private int diaAhora;
    private int mesAhora;
    private int annoAhora;

    // Propiedad compartida cualquier objecto puede modicar cualquier propiedad
    private static int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 39, 31, 30, 31};
    private static final String[] nombreMes = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    public Fecha() {

        Calendar c = new GregorianCalendar();

        dia = c.get(Calendar.DATE);
        mes = c.get(Calendar.MONTH);
        anno = c.get(Calendar.YEAR);
        diaAhora  = c.get(Calendar.DATE);
        mesAhora  = c.get(Calendar.MONTH);
        annoAhora = c.get(Calendar.YEAR);

    }

    public Fecha(int dia, int mes, int anno) {
        this.dia = dia;
        this.mes = mes;
        this.anno = anno;
    }

    public String fechaCompleta() {
        return dia + "/" + (mes + 1) + "/" + anno;
    }

    public String fechaCompletaLetra() {
        return dia + "/" + nombreMes[mes] + "/" + anno;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnno() {
        return anno;
    }

    /**
     *
     * @param dato
     * @return -1 Incorrecta | -2 dia incorrecto | -3 mes incorrecto | -4 año
     * incorrecto | 0 Fecha correcta
     */
    public int validarFecha(String dato) {
        int resultado = 0;
        String[] elementos = dato.split("/");

        if (elementos.length != 3) {
            resultado = -1;
        } else {
            try {

                this.dia = Integer.parseInt(elementos[0]);
                this.mes = Integer.parseInt(elementos[1]) - 1;
                this.anno = Integer.parseInt(elementos[2]);

                if (anno < 1000 || anno > 3000) {
                    resultado = -4;
                } else {
                    if (mes < 0 || mes > 11) {
                        resultado = -3;
                    } else {
                        bisiesto();
                        if (dia < 1 || dia > diasMes[mes]) {
                            resultado = -2;
                        }
                    }
                }
                
            } catch (NumberFormatException Exception) {
                resultado = -1;
            }
        }
        return resultado;
    }
    
    public int comprobarFechas(String dato){
        int resultado = 0;
        validarFecha(dato);
        
        if ((anno > annoAhora) || (anno == annoAhora && mes > mesAhora) || (anno == annoAhora && mes <= mesAhora && dia >= diaAhora )){
            resultado = -5;
            return resultado;
        }

        return validarFecha(dato);
    }

    /**
     * Metodo que nos calculará si un año es bisiesto o no
     */
    public void bisiesto() {
        if (anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0) {
            diasMes[1] = 29;
        } else {
            diasMes[1] = 28;
        }
    }

    public void calcularVencimiento(int diasVencimiento) {
        dia += diasVencimiento;
        bisiesto();
        while (dia > diasMes[mes]) {
            dia -= diasMes[mes];
            mes++;
            if (mes > 11) {
                anno++;
                mes = 0;
                bisiesto();
            }
        }
    }

    /**
     * Este método nos servirá para calcular los dias que llevamos de año
     *
     * @return Devolverá el numero de dias que llevamos de año
     */
    public int calcularOrden() {
        int ndias = 0;
        int mesx = 1;

        bisiesto();

        while (mesx < this.mes) {
            ndias += diasMes[mesx];
            mesx++;
        }

        ndias += this.dia;

        return ndias;
    }

    public int calcularSenios(Fecha fechaAlta, int numeroSenios) {
        Fecha fechaHoy = new Fecha();
        int senios;
        int anno = 1; //Es como un boolean que cuando no se ha cumplido un año mas en la fecha de alta ese año no cuenta
        
        if (fechaHoy.getMes() > fechaAlta.getMes()){
            anno--;
        }else{
            if(fechaHoy.getMes() == fechaAlta.getMes() && fechaHoy.getDia() >= fechaAlta.getDia()){
                anno--;
            }
        }
        
        senios = (fechaHoy.getAnno() - fechaAlta.getAnno() - anno) / numeroSenios;
        
        return senios;
    }
   
    /**
     * Metodo que nos servirá para calcular los dias que nos queda para terminar
     * el año
     *
     * @return Devolverá el numero de dias que nos queda para terminar el año
     */
    public int cacularDiasFinAnno() {
        int dias = 365;

        if (anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0) {
            dias = 366;
        }
        dias -= calcularOrden();

        return dias;
    }
}
