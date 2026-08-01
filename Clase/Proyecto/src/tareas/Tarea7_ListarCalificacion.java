package tareas;

import java.util.List;
import dao.CalificacionDAO;
import modelos.Calificacion;

public class Tarea7_ListarCalificacion extends TareaBase {

    public Tarea7_ListarCalificacion() {
        super(
            "Listar Calificaciones",
            "Muestra todas las calificaciones registradas"
        );
    }

    @Override
    public void ejecutar() {
        mostrarInfo();

        CalificacionDAO dao = new CalificacionDAO();
        List<Calificacion> lista = dao.listarTodos();

        if (lista.isEmpty()) {
            System.out.println("❌ No existen calificaciones registradas.");
            return;
        }

        System.out.println("\n===== LISTA DE CALIFICACIONES =====");

        for (Calificacion calificacion : lista) {
            System.out.println(calificacion);
        }

        System.out.println("----------------------------------");
        System.out.println("Total de calificaciones: " + lista.size());
    }
}