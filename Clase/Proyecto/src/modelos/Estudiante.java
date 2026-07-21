package modelos;

public class Estudiante {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String carrera;
    
    public Estudiante() {}
    
    public Estudiante(String nombre, String apellido, int edad, String carrera) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.carrera = carrera;
    }
    
    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }
    
    @Override
    public String toString() {
        return String.format("ID: %d | %s %s | Edad: %d | Carrera: %s", 
                            id, nombre, apellido, edad, carrera);
    }
}