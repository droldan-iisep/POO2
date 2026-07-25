package ul;

import config.DatabaseConnection;
import tareas.*;
import java.util.*;

public class MenuPrincipal {
    
    private static Map<Integer, TareaBase> tareas = new HashMap<>();
    
    public static void main(String[] args) {
        // Inicializar todas las tareas
        inicializarTareas();
        
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\n" + "=".repeat(60));
            System.out.println("        🏫 SISTEMA ESCOLAR - MENÚ PRINCIPAL");
            System.out.println("=".repeat(60));
            System.out.println("1. Insertar Estudiante      (Alumno 1)");
            System.out.println("2. Listar Estudiantes       (Alumno 2)");
            System.out.println("3. Buscar Estudiante        (Alumno 3)");
            System.out.println("4. Actualizar Estudiante    (Alumno 4)");
            System.out.println("5. Eliminar Estudiante      (Alumno 5)");
            System.out.println("6. Insertar Calificación    (Alumno 6)");
            System.out.println("7. Listar Calificaciones    (Alumno 7)");
            System.out.println("8. Buscar Calificación      (Alumno 8)");
            System.out.println("9. Actualizar Calificación  (Alumno 9)");
            System.out.println("10. Eliminar Calificación   (Alumno 10)");
            System.out.println("0. Salir");
            System.out.println("=".repeat(60));
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
                
                if (opcion == 0) {
                    System.out.println("👋 ¡Hasta luego!");
                    DatabaseConnection.closeConnection();
                    break;
                }
                
                if (tareas.containsKey(opcion)) {
                    tareas.get(opcion).ejecutar();
                } else {
                    System.out.println("❌ Opción no válida");
                }
                
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
                
            } catch (InputMismatchException e) {
                System.out.println("❌ Error: Ingrese un número válido");
                scanner.nextLine();
                opcion = -1;
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
                e.printStackTrace();
                opcion = -1;
            }
            
        } while (opcion != 0);
        
        scanner.close();
    }
    
    private static void inicializarTareas() {

        tareas.put(1, new Tarea1_InsertarEstudiante());
        tareas.put(2, new Tarea2_ListarEstudiante());

    }
        // Aquí se añadirán las tareas 2-10 cuando los alumnos las completen
        // tareas.put(2, new Tarea2_ListarEstudiantes());
        // tareas.put(3, new Tarea3_BuscarEstudiante());
        // etc...
    }