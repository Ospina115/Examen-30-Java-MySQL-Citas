package com.examenjava.utils;

import com.examenjava.model.Cita;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InputDialog {

    // Método para obtener datos de una nueva cita
    public static Cita obtenerDatosCita() {
        try {
            int pacienteId = Integer.parseInt(JOptionPane.showInputDialog("ID del Paciente:"));
            int medicoId = Integer.parseInt(JOptionPane.showInputDialog("ID del Médico:"));
            String fechaHoraStr = JOptionPane.showInputDialog("Fecha y Hora de la Cita (yyyy-MM-dd HH:mm):");
            LocalDateTime fechaHora = LocalDateTime.parse(fechaHoraStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            String estado = JOptionPane.showInputDialog("Estado de la Cita:");

            return new Cita(0, pacienteId, medicoId, fechaHora, estado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la entrada de datos: " + e.getMessage());
            return null;
        }
    }

    // Método para obtener el ID de una cita
    public static int obtenerIdCita() {
        try {
            return Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la cita:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato del ID");
            return -1; // Valor que indica un error
        }
    }

    // Método para obtener datos de una cita para actualizar
    public static Cita obtenerDatosCitaActualizar(Cita citaExistente) {
        try {
            int pacienteId = Integer.parseInt(JOptionPane.showInputDialog("ID del Paciente:", citaExistente.getPacienteId()));
            int medicoId = Integer.parseInt(JOptionPane.showInputDialog("ID del Médico:", citaExistente.getMedicoId()));
            String fechaHoraStr = JOptionPane.showInputDialog("Fecha y Hora de la Cita (yyyy-MM-dd HH:mm):", citaExistente.getFechaHora().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            LocalDateTime fechaHora = LocalDateTime.parse(fechaHoraStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            String estado = JOptionPane.showInputDialog("Estado de la Cita:", citaExistente.getEstado());

            return new Cita(citaExistente.getId(), pacienteId, medicoId, fechaHora, estado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la entrada de datos: " + e.getMessage());
            return null;
        }
    }
}
