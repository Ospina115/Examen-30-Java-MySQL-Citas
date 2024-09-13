package com.examenjava;

import com.examenjava.dao.EspecialidadDAO;
import com.examenjava.model.Especialidad;
import com.examenjava.utils.InputDialog;

import javax.swing.*;
import java.util.List;

public class Out {

    private static final EspecialidadDAO especialidadDAO = new EspecialidadDAO();

    public static void main(String[] args) {
        while (true) {
            String[] options = {"Crear", "Leer", "Actualizar", "Eliminar", "Listar", "Salir"};
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción", "CRUD Especialidad",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    crearEspecialidad();
                    break;
                case 1:
                    leerEspecialidad();
                    break;
                case 2:
                    actualizarEspecialidad();
                    break;
                case 3:
                    eliminarEspecialidad();
                    break;
                case 4:
                    listarEspecialidades();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    private static void crearEspecialidad() {
        Especialidad especialidad = InputDialog.obtenerDatosEspecialidad();
        if (especialidad != null) {
            especialidadDAO.crearEspecialidad(especialidad);
        }
    }

    private static void leerEspecialidad() {
        int id = InputDialog.obtenerIdEspecialidad();
        if (id != -1) {
            Especialidad especialidad = especialidadDAO.leerEspecialidad(id);
            if (especialidad != null) {
                JOptionPane.showMessageDialog(null, "Especialidad encontrada:\n" +
                        "ID: " + especialidad.getId() + "\n" +
                        "Nombre: " + especialidad.getNombre());
            } else {
                JOptionPane.showMessageDialog(null, "Especialidad no encontrada");
            }
        }
    }

    private static void actualizarEspecialidad() {
        int id = InputDialog.obtenerIdEspecialidad();
        if (id != -1) {
            Especialidad especialidadExistente = especialidadDAO.leerEspecialidad(id);
            if (especialidadExistente != null) {
                Especialidad especialidadActualizada = InputDialog.obtenerDatosEspecialidadActualizar(especialidadExistente);
                if (especialidadActualizada != null) {
                    especialidadDAO.actualizarEspecialidad(especialidadActualizada);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Especialidad no encontrada");
            }
        }
    }

    private static void eliminarEspecialidad() {
        int id = InputDialog.obtenerIdEspecialidad();
        if (id != -1) {
            especialidadDAO.eliminarEspecialidad(id);
        }
    }

    private static void listarEspecialidades() {
        List<Especialidad> especialidades = especialidadDAO.obtenerEspecialidades();
        if (especialidades.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay especialidades en la base de datos.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Especialidad especialidad : especialidades) {
                sb.append("ID: ").append(especialidad.getId()).append("\n");
                sb.append("Nombre: ").append(especialidad.getNombre()).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }
}

