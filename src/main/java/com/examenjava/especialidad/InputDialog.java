package com.examenjava.especialidad;

import com.examenjava.model.Especialidad;

import javax.swing.*;

public class InputDialog {

    // Método para obtener datos de una nueva especialidad
    public static Especialidad obtenerDatosEspecialidad() {
        String nombre = JOptionPane.showInputDialog("Nombre de la Especialidad:");
        if (nombre != null && !nombre.trim().isEmpty()) {
            return new Especialidad(0, nombre);
        } else {
            JOptionPane.showMessageDialog(null, "Nombre no válido");
            return null;
        }
    }

    // Método para obtener el ID de una especialidad
    public static int obtenerIdEspecialidad() {
        try {
            return Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la especialidad:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato del ID");
            return -1; // Valor que indica un error
        }
    }

    // Método para obtener datos de una especialidad para actualizar
    public static Especialidad obtenerDatosEspecialidadActualizar(Especialidad especialidadExistente) {
        String nombre = JOptionPane.showInputDialog("Nombre de la Especialidad:", especialidadExistente.getNombre());
        if (nombre != null && !nombre.trim().isEmpty()) {
            return new Especialidad(especialidadExistente.getId(), nombre);
        } else {
            JOptionPane.showMessageDialog(null, "Nombre no válido");
            return null;
        }
    }
}
