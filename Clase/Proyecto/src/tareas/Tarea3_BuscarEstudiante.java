package tareas;

import java.util.Scanner;
import dao.EstudianteDAO;
import modelos.Estudiante; // Importamos la clase Estudiante

public class Tarea3_BuscarEstudiante extends TareaBase {

    public Tarea3_BuscarEstudiante() {
        super("Buscar Estudiante", "Permite buscar la información de un estudiante por su ID");
    }

    @Override
    public void ejecutar() {
        mostrarInfo();
        Scanner scanner = new Scanner(System.in);
        EstudianteDAO dao = new EstudianteDAO();

        System.out.print("Ingrese el ID del estudiante que desea buscar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea del scanner

        // Llamamos al método del DAO para buscar en la base de datos
        // Nota: Si te marca error aquí, revisa cómo se llama el método en tu clase EstudianteDAO
        // Puede que tu profe le haya puesto dao.buscar(id) o dao.obtener(id)
        Estudiante estudiante = dao.buscarPorId(id);

        if (estudiante != null) {
            System.out.println("✅ Estudiante encontrado:");
            System.out.println("-----------------------------");
            System.out.println("ID: " + estudiante.getId());
            System.out.println("Nombre: " + estudiante.getNombre() + " " + estudiante.getApellido());
            System.out.println("Edad: " + estudiante.getEdad());
            System.out.println("Carrera: " + estudiante.getCarrera());
            System.out.println("-----------------------------");
        } else {
            System.out.println("❌ Error: No se encontró estudiante con ese ID.");
        }
    }
}