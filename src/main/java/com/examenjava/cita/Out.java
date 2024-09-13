package com.examenjava;

import com.examenjava.dao.CitaDAO;
import com.examenjava.model.Cita;
import com.examenjava.utils.InputDialog;

import javax.swing.*;
import java.util.List;

public class Out {

    private static final CitaDAO citaDAO = new CitaDAO();
    public static void main(String[] args) {
        while (true) {
            String[] options = {"Crear", "Leer", "Actualizar", "Eliminar", "Listar", "Salir"};
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción", "CRUD Cita", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (choice) {
                case 0:
                    crearCita();
                    break;
                case 1:
                    leerCita();
                    break;
                case 2:
                    actualizarCita();
                    break;
                case 3:
                    eliminarCita();
                    break;
                case 4:
                    listarCitas();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

private static void crearCita() {
Cita cita = InputDialog.obtenerDatosCita();
if (cita != null) {
    citaDAO.crearCita(cita);
}
}

private static void leerCita() {
int id = InputDialog.obtenerIdCita();
if (id != -1) {
    Cita cita = citaDAO.leerCita(id);
    if (cita != null) {
        JOptionPane.showMessageDialog(null, "Cita encontrada:\n" +
                "ID: " + cita.getId() + "\n" +
                "Paciente ID: " + cita.getPacienteId() + "\n" +
                "Médico ID: " + cita.getMedicoId() + "\n" +
                "Fecha y Hora: " + cita.getFechaHora() + "\n" +
                "Estado: " + cita.getEstado());
    } else {
        JOptionPane.showMessageDialog(null, "Cita no encontrada");
    }
}
}

private static void actualizarCita() {
int id = InputDialog.obtenerIdCita();
if (id != -1) {
    Cita citaExistente = citaDAO.leerCita(id);
    if (citaExistente != null) {
        Cita citaActualizada = InputDialog.obtenerDatosCitaActualizar(citaExistente);
        if (citaActualizada != null) {
            citaDAO.actualizarCita(citaActualizada);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Cita no encontrada");
    }
}
}

private static void eliminarCita() {
int id = InputDialog.obtenerIdCita();
if (id != -1) {
    citaDAO.eliminarCita(id);
}
}

private static void listarCitas() {
List<Cita> citas = citaDAO.obtenerCitas();
if (citas.isEmpty()) {
    JOptionPane.showMessageDialog(null, "No hay citas en la base de datos.");
} else {
    StringBuilder sb = new StringBuilder();
    for (Cita cita : citas) {
        sb.append("ID: ").append(cita.getId()).append("\n")
          .append("Paciente ID: ").append(cita.getPacienteId()).append("\n")
          .append("Médico ID: ").append(cita.getMedicoId()).append("\n")
          .append("Fecha y Hora: ").append(cita.getFechaHora()).append("\n")
          .append("Estado: ").append(cita.getEstado()).append("\n\n");
    }
    JOptionPane.showMessageDialog(null, sb.toString());
}
}
}
