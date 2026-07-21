package modelos;

public class Calificacion {
    private int id;
    private int estudianteId;
    private String materia;
    private double nota;
    
    public Calificacion() {}
    
    public Calificacion(int estudianteId, String materia, double nota) {
        this.estudianteId = estudianteId;
        this.materia = materia;
        this.nota = nota;
    }
    
    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getEstudianteId() { return estudianteId; }
    public void setEstudianteId(int estudianteId) { this.estudianteId = estudianteId; }
    public String getMateria() { return materia; }
    public void setMateria(String materia) { this.materia = materia; }
    public double getNota() { return nota; }
    public void setNota(double nota) { this.nota = nota; }
    
    @Override
    public String toString() {
        return String.format("ID: %d | Estudiante ID: %d | %s | Nota: %.2f", 
                            id, estudianteId, materia, nota);
    }
}