-- Crear la base de datos
CREATE DATABASE escuela_tareas;
USE escuela_tareas;

-- Tabla de estudiantes
CREATE TABLE estudiantes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    edad INT,
    carrera VARCHAR(100)
);

-- Tabla de calificaciones
CREATE TABLE calificaciones (
    id INT PRIMARY KEY AUTO_INCREMENT,
    estudiante_id INT,
    materia VARCHAR(100),
    nota DECIMAL(4,2),
    FOREIGN KEY (estudiante_id) REFERENCES estudiantes(id)
);

-- Insertar datos de ejemplo
INSERT INTO estudiantes (nombre, apellido, edad, carrera) VALUES
('Ana', 'García', 20, 'Ingeniería'),
('Carlos', 'López', 22, 'Matemáticas'),
('María', 'Martínez', 21, 'Física');

INSERT INTO calificaciones (estudiante_id, materia, nota) VALUES
(1, 'Matemáticas', 8.5),
(1, 'Programación', 9.0),
(2, 'Matemáticas', 7.5),
(3, 'Física', 8.0);


select * from estudiantes;