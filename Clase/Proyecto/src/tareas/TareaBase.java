package tareas;

public abstract class TareaBase {
    protected String nombreTarea;
    protected String descripcion;
    
    public TareaBase(String nombreTarea, String descripcion) {
        this.nombreTarea = nombreTarea;
        this.descripcion = descripcion;
    }
    
    public abstract void ejecutar();
    
    public void mostrarInfo() {
        System.out.println("📌 Tarea: " + nombreTarea);
        System.out.println("📝 Descripción: " + descripcion);
        System.out.println("─".repeat(50));
    }
}