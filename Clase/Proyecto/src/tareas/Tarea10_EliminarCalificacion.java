package tareas;

import java.util.Scanner;
import dao.CalificacionDAO;
import modelos.Calificacion;

public class Tarea10_EliminarCalificacion extends TareaBase {

    public Tarea10_EliminarCalificacion() {
        super(
            "Eliminar Calificación",
            "Permite eliminar una calificación mediante su ID"
        );
    }

    @Override
    public void ejecutar() {
        mostrarInfo();

        Scanner scanner = new Scanner(System.in);
        CalificacionDAO dao = new CalificacionDAO();

        System.out.print("Ingrese el ID de la calificación: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Calificacion calificacion = dao.buscarPorId(id);

        if (calificacion == null) {
            System.out.println(
                "❌ No se encontró una calificación con ese ID."
            );
            return;
        }

        System.out.println("Calificación encontrada: " + calificacion);
        System.out.print("¿Está seguro de eliminarla? (S/N): ");
        String confirmacion = scanner.nextLine();

        if (confirmacion.equalsIgnoreCase("S")) {
            if (dao.eliminar(id)) {
                System.out.println("✅ Calificación eliminada correctamente.");
            } else {
                System.out.println("❌ Error al eliminar la calificación.");
            }
        } else {
            System.out.println("⚠ Eliminación cancelada.");
        }
    }
}