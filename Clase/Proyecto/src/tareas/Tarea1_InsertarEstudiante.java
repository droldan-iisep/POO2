package tareas;

import dao.EstudianteDAO;
import modelos.Estudiante;
import java.util.Scanner;

public class Tarea1_InsertarEstudiante extends TareaBase {
    
    public Tarea1_InsertarEstudiante() {
        super("Insertar Estudiante", "Permite agregar un nuevo estudiante a la base de datos");
    }
    
    @Override
    public void ejecutar() {
        mostrarInfo();
        Scanner scanner = new Scanner(System.in);
        EstudianteDAO dao = new EstudianteDAO();
        
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese carrera: ");
        String carrera = scanner.nextLine();
        
        Estudiante estudiante = new Estudiante(nombre, apellido, edad, carrera);
        
        if (dao.insertar(estudiante)) {
            System.out.println("✅ Estudiante insertado correctamente");
        } else {
            System.out.println("❌ Error al insertar estudiante");
        }
    }
}