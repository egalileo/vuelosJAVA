import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static int agregarVuelo(String[][] vuelos, int contador){
        Scanner fc = new Scanner(System.in);

        if (contador >= 10) {
            System.out.println("No se pueden agregar más vuelos, la matriz está llena.");
            return contador;
        }

        try{
            System.out.print("Ingrese el origen: ");
            String origen = fc.nextLine();
            System.out.print("Ingrese el destino: ");
            String destino = fc.nextLine();
            System.out.print("Ingrese la hora de salida (dd/MM/yyyy HH:mm): ");
            String salida = fc.nextLine();
            System.out.print("Ingrese la hora de llegada (dd/MM/yyyy HH:mm): ");
            String llegada = fc.nextLine();

            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date horaSalida = formatoFecha.parse(salida);
            Date horaLlegada = formatoFecha.parse(llegada);
            long duracion = horaLlegada.getTime() - horaSalida.getTime();
            String duracionEnHoras = String.valueOf(duracion / (1000 * 60 * 60));

            vuelos[contador][0] = origen;
            vuelos[contador][1] = destino;
            vuelos[contador][2] = salida;
            vuelos[contador][3] = llegada;
            vuelos[contador][4] = duracionEnHoras;
            contador++;

            System.out.println("Vuelo agregado exitosamente.");

        }catch(ParseException e){
            System.out.println("Formato de fecha incorrecto. Use dd/MM/yyyy HH:mm");
        }
        return contador;
    }

    public static void mostrarVuelos(int contadorVuelos, String vuelos[][]) {
        for (int i = 0; i < contadorVuelos; i++) {
            System.out.println("Vuelo " + (i + 1) + ":");
            System.out.println("Origen: " + vuelos[i][0]);
            System.out.println("Destino: " + vuelos[i][1]);
            System.out.println("Hora de Salida: " + vuelos[i][2]);
            System.out.println("Hora de Llegada: " + vuelos[i][3]);
            System.out.println("Duración: " + vuelos[i][4] + " Horas");
            System.out.println();
        }
    }


    public static void main(String[] args) {
        // id, origen, destino, horasalida, horallegada, duracion

        String vuelos[][] = new String[10][5];
        int contadorVuelos = 0, opcion;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Menú:");
            System.out.println("1. Agregar nuevo vuelo");
            System.out.println("2. Mostrar vuelos");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1: //agregar nuevo vuelo
                    contadorVuelos = agregarVuelo(vuelos, contadorVuelos);
                    break;
                case 2:
                    mostrarVuelos(contadorVuelos, vuelos);
                    break;
                case 3:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);

        sc.close();

    }
}