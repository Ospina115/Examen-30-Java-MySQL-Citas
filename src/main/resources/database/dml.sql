//************************************//
//* INSERTS DE DATOS PARA LAS TABLAS *//
//************************************//

INSERT INTO Paciente (nombre, apellido, fecha_nacimiento, dirección, teléfono, email)
VALUES
('Juan', 'Pérez', '1990-01-01', 'Calle 1', '1234567890', 'juan.perez@example.com'),
('María', 'González', '1985-06-15', 'Avenida 2', '9876543210', 'maria.gonzalez@example.com'),
('Pedro', 'Rodríguez', '1992-03-20', 'Calle 3', '5551234567', 'pedro.rodriguez@example.com');

INSERT INTO Especialidad (nombre)
VALUES
('Cardiología'),
('Neurología'),
('Pediatría');

INSERT INTO Médico (id, nombre, especialidad_id, horario_inicio, horario_fin)
VALUES
(1, 'Dr. Ana García', 1, '08:00:00', '16:00:00'),
(2, 'Dr. Juan Sánchez', 2, '09:00:00', '17:00:00'),
(3, 'Dr. María López', 1, '10:00:00', '18:00:00');

INSERT INTO Cita (paciente_id, medico_id, fecha_hora, estado)
VALUES
(1, 1, '2023-03-10 10:00:00', 'Pendiente'),
(2, 2, '2023-03-12 14:00:00', 'Realizada'),
(3, 3, '2023-03-15 16:00:00', 'Pendiente');

INSERT INTO Cita (paciente_id, medico_id, fecha_hora, estado)
VALUES
(1, 1, '2023-03-10 10:00:00', 'Pendiente'),
(2, 2, '2023-03-12 14:00:00', 'Realizada'),
(3, 3, '2023-03-15 16:00:00', 'Pendiente');

INSERT INTO users (enabled, username, password)
VALUES 
(TRUE, 'usuario', 'usuario'),
(TRUE, 'ana', 'clave12345'),
(FALSE, 'samuel', 'rokoopercp'),
(FALSE, 'admin', 'admin');

