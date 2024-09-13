# EXAMEN #1

Joseph Samuel Ospina 13/09/2024

### **Descripción del Proyecto**:

El sistema de control de citas médicas permitirá la gestión de pacientes, médicos, especialidades y citas. Los usuarios podrán agendar, modificar o cancelar citas, mientras los administradores podrán gestionar la información de médicos, especialidades, y horarios.

### **Requisitos Funcionales**:

- **Gestión de Pacientes**: Crear, leer, actualizar y eliminar información de pacientes (nombre, dirección, teléfono, etc.).
- **Gestión de Médicos**: Crear, leer, actualizar y eliminar información de médicos (nombre, especialidad, horarios).
- **Gestión de Especialidades**: Registrar y consultar las especialidades médicas disponibles.
- **Gestión de Citas**: Agendar, modificar o cancelar citas médicas con un médico específico.
- **Consulta de Historial**: Permitir a los pacientes ver su historial de citas.

### **Modelo de Datos (MySQL)**:

- **Paciente** (id, nombre, apellido, fecha_nacimiento, dirección, teléfono, email).
- **Médico** (id, nombre, especialidad_id, horario_inicio, horario_fin).
- **Especialidad** (id, nombre).
- **Cita** (id, paciente_id, medico_id, fecha_hora, estado).



### **Condiciones de entrega**

1. Crear un repositorio privado para el proyecto.
2. Agregar al trainer como colaborador.
3. El plazo maximo de entrega 14:00
4. Cuando finalice el desarrollo o se disponga a publicar la solucion cambie las credenciales de  conexion de la base de  datos. usuario : root y clave: 123456

