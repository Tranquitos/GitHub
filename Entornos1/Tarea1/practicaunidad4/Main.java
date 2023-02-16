/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaunidad4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Sebastian Perniola
 */

public class Main {
    static BufferedReader dato = new BufferedReader(new InputStreamReader(System.in));

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CCuenta miCuenta1;
        double saldoActual;

        int opcion = 0;
        miCuenta1 = new CCuenta("Antonio López", "1000-2365-85-1230456789", 2500, 0);
        saldoActual = miCuenta1.estado();
        System.out.println("El saldo actual es " + saldoActual);

        do {
            try {
                System.out.println("MENÚ DE OPERACIONES");
                System.out.println("-------------------");
                System.out.println("1 - Ingresar");
                System.out.println("2 - Retirar");
                System.out.println("3 - Finalizar");
                opcion = Integer.parseInt(dato.readLine());
                if (opcion == 1) {
                    System.out.println("¿Cuánto desea ingresar?: ");
                    float ingresar = Integer.parseInt(dato.readLine());
                    operativa_cuenta(miCuenta1, ingresar, opcion);
                } else if (opcion == 2) {
                    System.out.println("¿Cuátno desea retirar?: ");
                    float retirar = Integer.parseInt(dato.readLine());
                    operativa_cuenta(miCuenta1, retirar, opcion);
                } else if (opcion == 3) {
                    System.out.println("Finalizamos la ejecución");
                } else {
                    System.err.println("Opción errónea");
                }
                /*
                 * switch(opcion){
                 * case 1:
                 * System.out.println("¿Cuánto desea ingresar?: ");
                 * float ingresar=Integer.parseInt(dato.readLine());
                 * operativa_cuenta(cuenta1,ingresar,opcion);
                 * break;
                 * case 2:
                 * System.out.println("¿Cuátno desea retirar?: ");
                 * float retirar=Integer.parseInt(dato.readLine());
                 * operativa_cuenta(cuenta1,retirar,opcion);
                 * break;
                 * case 3:
                 * System.out.println("Finalizamos la ejecución");
                 * }
                 */ } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (opcion != 3);
        saldoActual = miCuenta1.estado();
        System.out.println("El saldo actual es" + saldoActual);
    }

    public static void operativa_cuenta(CCuenta cuenta1, float cantidad, int opcion) {
        if (opcion == 2) {
            try {
                cuenta1.retirar(cantidad);
            } catch (Exception e) {
                System.out.print("Fallo al retirar");
            }
        } else if (opcion == 1) {
            try {
                System.out.println("Ingreso en cuenta");
                cuenta1.ingresar(cantidad);
            } catch (Exception e) {
                System.out.print("Fallo al ingresar");
            }
        }
    }
}
