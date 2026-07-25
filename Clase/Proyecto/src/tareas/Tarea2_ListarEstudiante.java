package tareas;

import dao.EstudianteDAO;
import modelos.Estudiante;
import java.util.List;

public class Tarea2_ListarEstudiante extends TareaBase {

    public Tarea2_ListarEstudiante() {
        super("Listar Estudiantes",
              "Permite mostrar todos los estudiantes registrados");
    }

    @Override
    public void ejecutar() {

        mostrarInfo();

        EstudianteDAO dao = new EstudianteDAO();

        List<Estudiante> lista = dao.listarTodos();

        if (lista.isEmpty()) {

            System.out.println("❌ No existen estudiantes registrados.");

        } else {

            System.out.println("\n===== LISTA DE ESTUDIANTES =====");

            for (Estudiante e : lista) {

                System.out.println("----------------------------");
                System.out.println("ID: " + e.getId());
                System.out.println("Nombre: " + e.getNombre());
                System.out.println("Apellido: " + e.getApellido());
                System.out.println("Edad: " + e.getEdad());
                System.out.println("Carrera: " + e.getCarrera());

            }

            System.out.println("----------------------------");
            System.out.println("Total de estudiantes: " + lista.size());

        }

    }

}