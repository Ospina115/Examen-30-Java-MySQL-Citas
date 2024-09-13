package com.examenjava.medico;

import com.examenjava.medico.Medico;

import javax.swing.*;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InputDialog {
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    // Método para obtener datos de un nuevo médico
    public static Medico obtenerDatosMedico() {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre:");
            int especialidadId = Integer.parseInt(JOptionPane.showInputDialog("ID de Especialidad:"));
            String horarioInicioStr = JOptionPane.showInputDialog("Horario de Inicio (HH:mm):");
            Time horarioInicio = new Time(timeFormat.parse(horarioInicioStr).getTime());
            String horarioFinStr = JOptionPane.showInputDialog("Horario de Fin (HH:mm):");
            Time horarioFin = new Time(timeFormat.parse(horarioFinStr).getTime());

            return new Medico(0, nombre, especialidadId, horarioInicio, horarioFin);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato de la hora");
            return null;
        }
    }

    // Método para obtener el ID del médico
    public static int obtenerIdMedico() {
        try {
            return Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del médico:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato del ID");
            return -1; // Valor que indica un error
        }
    }

    // Método para obtener datos de un médico para actualizar
    public static Medico obtenerDatosMedicoActualizar(Medico medicoExistente) {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre:", medicoExistente.getNombre());
            int especialidadId = Integer.parseInt(JOptionPane.showInputDialog("ID de Especialidad:", medicoExistente.getEspecialidadId()));
            String horarioInicioStr = JOptionPane.showInputDialog("Horario de Inicio (HH:mm):", medicoExistente.getHorarioInicio().toString());
            Time horarioInicio = new Time(timeFormat.parse(horarioInicioStr).getTime());
            String horarioFinStr = JOptionPane.showInputDialog("Horario de Fin (HH:mm):", medicoExistente.getHorarioFin().toString());
            Time horarioFin = new Time(timeFormat.parse(horarioFinStr).getTime());

            return new Medico(medicoExistente.getId(), nombre, especialidadId, horarioInicio, horarioFin);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato de la hora");
            return null;
        }
    }
}
