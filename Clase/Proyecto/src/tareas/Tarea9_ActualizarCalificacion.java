package tareas;

import java.util.Scanner;
import dao.CalificacionDAO;
import dao.EstudianteDAO;
import modelos.Calificacion;
import modelos.Estudiante;

public class Tarea9_ActualizarCalificacion extends TareaBase {

    public Tarea9_ActualizarCalificacion() {
        super(
            "Actualizar Calificación",
            "Permite actualizar los datos de una calificación"
        );
    }

    @Override
    public void ejecutar() {
        mostrarInfo();

        Scanner scanner = new Scanner(System.in);
        CalificacionDAO calificacionDAO = new CalificacionDAO();
        EstudianteDAO estudianteDAO = new EstudianteDAO();

        System.out.print("Ingrese el ID de la calificación: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Calificacion calificacion = calificacionDAO.buscarPorId(id);

        if (calificacion == null) {
            System.out.println(
                "❌ No se encontró una calificación con ese ID."
            );
            return;
        }

        System.out.println("Calificación actual: " + calificacion);

        System.out.print("Ingrese el nuevo ID del estudiante: ");
        int estudianteId = scanner.nextInt();
        scanner.nextLine();

        Estudiante estudiante = estudianteDAO.buscarPorId(estudianteId);

        if (estudiante == null) {
            System.out.println("❌ El estudiante indicado no existe.");
            return;
        }

        System.out.print("Ingrese la nueva materia: ");
        String materia = scanner.nextLine();

        System.out.print("Ingrese la nueva nota: ");
        double nota = scanner.nextDouble();
        scanner.nextLine();

        calificacion.setEstudianteId(estudianteId);
        calificacion.setMateria(materia);
        calificacion.setNota(nota);

        if (calificacionDAO.actualizar(calificacion)) {
            System.out.println("✅ Calificación actualizada correctamente.");
        } else {
            System.out.println("❌ Error al actualizar la calificación.");
        }
    }
}