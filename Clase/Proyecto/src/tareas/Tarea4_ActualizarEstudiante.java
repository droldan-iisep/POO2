package tareas;

import java.util.Scanner;
import dao.EstudianteDAO;
import modelos.Estudiante;

public class Tarea4_ActualizarEstudiante extends TareaBase {

    public Tarea4_ActualizarEstudiante() {
        super(
            "Actualizar Estudiante",
            "Permite actualizar los datos de un estudiante por su ID"
        );
    }

    @Override
    public void ejecutar() {
        mostrarInfo();

        Scanner scanner = new Scanner(System.in);
        EstudianteDAO dao = new EstudianteDAO();

        System.out.print("Ingrese el ID del estudiante: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Estudiante estudiante = dao.buscarPorId(id);

        if (estudiante == null) {
            System.out.println("❌ No se encontró un estudiante con ese ID.");
            return;
        }

        System.out.println("Estudiante encontrado: " + estudiante);

        System.out.print("Ingrese el nuevo nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el nuevo apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese la nueva edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la nueva carrera: ");
        String carrera = scanner.nextLine();

        estudiante.setNombre(nombre);
        estudiante.setApellido(apellido);
        estudiante.setEdad(edad);
        estudiante.setCarrera(carrera);

        if (dao.actualizar(estudiante)) {
            System.out.println("✅ Estudiante actualizado correctamente.");
        } else {
            System.out.println("❌ Error al actualizar el estudiante.");
        }
    }
}