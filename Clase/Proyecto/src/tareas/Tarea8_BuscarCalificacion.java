package tareas;

import java.util.Scanner;
import dao.CalificacionDAO;
import modelos.Calificacion;

public class Tarea8_BuscarCalificacion extends TareaBase {

    public Tarea8_BuscarCalificacion() {
        super(
            "Buscar Calificación",
            "Permite buscar una calificación mediante su ID"
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

        if (calificacion != null) {
            System.out.println("✅ Calificación encontrada:");
            System.out.println("-----------------------------");
            System.out.println("ID: " + calificacion.getId());
            System.out.println(
                "ID del estudiante: " + calificacion.getEstudianteId()
            );
            System.out.println("Materia: " + calificacion.getMateria());
            System.out.println("Nota: " + calificacion.getNota());
            System.out.println("-----------------------------");
        } else {
            System.out.println(
                "❌ No se encontró una calificación con ese ID."
            );
        }
    }
}