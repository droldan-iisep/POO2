package tareas;

import dao.CalificacionDAO;
import modelos.Calificacion;
import java.util.Scanner;

public class Tarea6_InsertarCalificacion extends TareaBase {

    public Tarea6_InsertarCalificacion() {
        super("Insertar Calificación",
              "Permite agregar una nueva calificación a la base de datos");
    }

    @Override
    public void ejecutar() {

        mostrarInfo();

        Scanner scanner = new Scanner(System.in);
        CalificacionDAO dao = new CalificacionDAO();

        System.out.print("Ingrese ID del estudiante: ");
        int estudianteId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese materia: ");
        String materia = scanner.nextLine();

        System.out.print("Ingrese nota: ");
        double nota = scanner.nextDouble();

        Calificacion calificacion = new Calificacion(estudianteId, materia, nota);

        if (dao.insertar(calificacion)) {
            System.out.println("✅ Calificación insertada correctamente");
        } else {
            System.out.println("❌ Error al insertar calificación");
        }
    }
}