package tareas;

import java.util.Scanner;
import dao.CalificacionDAO;
import dao.EstudianteDAO;
import modelos.Calificacion;
import modelos.Estudiante;

public class Tarea6_InsertarCalificacion extends TareaBase {

    public Tarea6_InsertarCalificacion() {
        super(
            "Insertar Calificación",
            "Permite registrar una calificación para un estudiante"
        );
    }

    @Override
    public void ejecutar() {
        mostrarInfo();

        Scanner scanner = new Scanner(System.in);
        CalificacionDAO calificacionDAO = new CalificacionDAO();
        EstudianteDAO estudianteDAO = new EstudianteDAO();

        System.out.print("Ingrese el ID del estudiante: ");
        int estudianteId = scanner.nextInt();
        scanner.nextLine();

        Estudiante estudiante = estudianteDAO.buscarPorId(estudianteId);

        if (estudiante == null) {
            System.out.println("❌ No existe un estudiante con ese ID.");
            return;
        }

        System.out.println("Estudiante: " + estudiante);

        System.out.print("Ingrese la materia: ");
        String materia = scanner.nextLine();

        System.out.print("Ingrese la nota: ");
        double nota = scanner.nextDouble();
        scanner.nextLine();

        Calificacion calificacion =
            new Calificacion(estudianteId, materia, nota);

        if (calificacionDAO.insertar(calificacion)) {
            System.out.println("✅ Calificación insertada correctamente.");
        } else {
            System.out.println("❌ Error al insertar la calificación.");
        }
    }
}