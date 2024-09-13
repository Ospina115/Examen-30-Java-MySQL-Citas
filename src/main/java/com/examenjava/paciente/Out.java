package com.examenjava.paciente;

import com.examenjava.paciente.PacienteDAO;
import com.examenjava.paciente.Paciente;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Out {

    private static final PacienteDAO pacienteDAO = new PacienteDAO();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        while (true) {
            String[] options = {"Crear", "Leer", "Actualizar", "Eliminar", "Listar", "Salir"};
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción", "CRUD Paciente",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    crearPaciente();
                    break;
                case 1:
                    leerPaciente();
                    break;
                case 2:
                    actualizarPaciente();
                    break;
                case 3:
                    eliminarPaciente();
                    break;
                case 4:
                    listarPacientes();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    private static void crearPaciente() {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre:");
            String apellido = JOptionPane.showInputDialog("Apellido:");
            String fechaStr = JOptionPane.showInputDialog("Fecha de Nacimiento (yyyy-MM-dd):");
            Date fechaNacimiento = dateFormat.parse(fechaStr);
            String direccion = JOptionPane.showInputDialog("Dirección:");
            String telefono = JOptionPane.showInputDialog("Teléfono:");
            String email = JOptionPane.showInputDialog("Email:");

            Paciente paciente = new Paciente(0, nombre, apellido, fechaNacimiento, direccion, telefono, email);
            pacienteDAO.crearPaciente(paciente);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato de la fecha");
        }
    }

    private static void leerPaciente() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del paciente:"));
            Paciente paciente = pacienteDAO.leerPaciente(id);
            if (paciente != null) {
                JOptionPane.showMessageDialog(null, "Paciente encontrado:\n" +
                        "ID: " + paciente.getId() + "\n" +
                        "Nombre: " + paciente.getNombre() + "\n" +
                        "Apellido: " + paciente.getApellido() + "\n" +
                        "Fecha de Nacimiento: " + dateFormat.format(paciente.getFechaNacimiento()) + "\n" +
                        "Dirección: " + paciente.getDireccion() + "\n" +
                        "Teléfono: " + paciente.getTelefono() + "\n" +
                        "Email: " + paciente.getEmail());
            } else {
                JOptionPane.showMessageDialog(null, "Paciente no encontrado");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato del ID");
        }
    }

    private static void actualizarPaciente() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del paciente a actualizar:"));
            Paciente pacienteExistente = pacienteDAO.leerPaciente(id);

            if (pacienteExistente != null) {
                String nombre = JOptionPane.showInputDialog("Nuevo Nombre:", pacienteExistente.getNombre());
                String apellido = JOptionPane.showInputDialog("Nuevo Apellido:", pacienteExistente.getApellido());
                String fechaStr = JOptionPane.showInputDialog("Nueva Fecha de Nacimiento (yyyy-MM-dd):", dateFormat.format(pacienteExistente.getFechaNacimiento()));
                Date fechaNacimiento = dateFormat.parse(fechaStr);
                String direccion = JOptionPane.showInputDialog("Nueva Dirección:", pacienteExistente.getDireccion());
                String telefono = JOptionPane.showInputDialog("Nuevo Teléfono:", pacienteExistente.getTelefono());
                String email = JOptionPane.showInputDialog("Nuevo Email:", pacienteExistente.getEmail());

                Paciente pacienteActualizado = new Paciente(id, nombre, apellido, fechaNacimiento, direccion, telefono, email);
                pacienteDAO.actualizarPaciente(pacienteActualizado);
            } else {
                JOptionPane.showMessageDialog(null, "Paciente no encontrado");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato del ID");
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato de la fecha");
        }
    }

    private static void eliminarPaciente() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del paciente a eliminar:"));
            pacienteDAO.eliminarPaciente(id);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato del ID");
        }
    }

    private static void listarPacientes() {
        List<Paciente> pacientes = pacienteDAO.obtenerPacientes();
        if (pacientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pacientes en la base de datos.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Paciente paciente : pacientes) {
                sb.append("ID: ").append(paciente.getId()).append("\n")
                .append("Nombre: ").append(paciente.getNombre()).append("\n")
                .append("Apellido: ").append(paciente.getApellido()).append("\n")
                .append("Fecha de Nacimiento: ").append(dateFormat.format(paciente.getFechaNacimiento())).append("\n")
                .append("Dirección: ").append(paciente.getDireccion()).append("\n")
                .append("Teléfono: ").append(paciente.getTelefono()).append("\n")
                .append("Email: ").append(paciente.getEmail()).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }
}
