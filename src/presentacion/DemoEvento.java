package presentacion;

import datos.Credencial;
import datos.CredencialEvento;
import negocio.ConfiguracionEvento;
import negocio.GestorCredenciales;
import java.util.Scanner;


public class DemoEvento {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------");
        System.out.println("-          GENERADOR DE CREDENCIALES DE EVENTO     -");
        System.out.println("----------------------------------------------------");
        System.out.println("-  Aplicacion de patrones: Prototype y Singleton   -");
        System.out.println("-  Desarrollado por: Eugenio Vergara               -");
        System.out.println("----------------------------------------------------");
        
        
        ConfiguracionEvento config = ConfiguracionEvento.getInstancia();
        System.out.println("\n CONFIGURACION DEL EVENTO (mediante patron SINGLETON)");
        System.out.println(config);
        
        System.out.println("\n CREANDO PLANTILLA BASE DE CREDENCIAL (para patron PROTOTYPE)");
        Credencial plantilla = new CredencialEvento(config.getNombreEvento(), config.getFechaEvento());
        System.out.println(" Plantilla base creada exitosamente.");
        
        GestorCredenciales gestor = new GestorCredenciales(plantilla);
        
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Agregar nueva credencial");
            System.out.println("2. Ver credenciales generadas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                switch (opcion) {
                    case 1:
                        System.out.print("Nombre del asistente: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Rol del asistente (PARTICIPANTE, EXPOSITOR, ORGANIZADOR, VIP): ");
                        String rol = scanner.nextLine();
                        
                        Credencial nuevaCredencial = gestor.generarCredencial(nombre, rol);
                        if (nuevaCredencial != null) {
                            System.out.println("\n Credencial generada exitosamente:");
                            System.out.println(nuevaCredencial);
                        }
                        break;
                        
                    case 2:
                        gestor.mostrarCredencialesGeneradas();
                        break;
                        
                    case 3:
                        System.out.println("\n Saliendo del sistema...");
                        break;
                        
                    default:
                        System.out.println("\n️ Opcion no valida. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("\n Error: Entrada invalida.");
                scanner.nextLine(); 
                opcion = 0;
            }
            
        } while (opcion != 3);
        
        scanner.close();
        System.out.println("Se generaron un total de " + gestor.getCantidadCredenciales() + " credenciales.");
        System.out.println("Gracias por usar el Sistema de Generacion de Credenciales!");
    }
}