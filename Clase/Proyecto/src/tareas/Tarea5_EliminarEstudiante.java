package tareas;

import java.util.Scanner;
import dao.EstudianteDAO;
import modelos.Estudiante;

public class Tarea5_EliminarEstudiante extends TareaBase {

    public Tarea5_EliminarEstudiante() {
        super(
            "Eliminar Estudiante",
            "Permite eliminar un estudiante mediante su ID"
        );
    }

    @Override
    public void ejecutar() {
        mostrarInfo();

        Scanner scanner = new Scanner(System.in);
        EstudianteDAO dao = new EstudianteDAO();

        System.out.print("Ingrese el ID del estudiante que desea eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Estudiante estudiante = dao.buscarPorId(id);

        if (estudiante == null) {
            System.out.println("❌ No se encontró un estudiante con ese ID.");
            return;
        }

        System.out.println("Estudiante encontrado: " + estudiante);
        System.out.print("¿Está seguro de eliminarlo? (S/N): ");
        String confirmacion = scanner.nextLine();

        if (confirmacion.equalsIgnoreCase("S")) {
            if (dao.eliminar(id)) {
                System.out.println("✅ Estudiante eliminado correctamente.");
            } else {
                System.out.println("❌ Error al eliminar el estudiante.");
                System.out.println(
                    "Puede tener calificaciones relacionadas en la base de datos."
                );
            }
        } else {
            System.out.println("⚠ Eliminación cancelada.");
        }
    }
}