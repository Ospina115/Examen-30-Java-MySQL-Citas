package com.examenjava.medico;

import com.examenjava.medico.MedicoDAO;
import com.examenjava.medico.Medico;
import com.examenjava.medico.InputDialog;

import javax.swing.*;
import java.util.List;

public class Out {

    private static final MedicoDAO medicoDAO = new MedicoDAO();

    public static void main(String[] args) {
        while (true) {
            String[] options = {"Crear", "Leer", "Actualizar", "Eliminar", "Listar", "Salir"};
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción", "CRUD Médico",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    crearMedico();
                    break;
                case 1:
                    leerMedico();
                    break;
                case 2:
                    actualizarMedico();
                    break;
                case 3:
                    eliminarMedico();
                    break;
                case 4:
                    listarMedicos();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    private static void crearMedico() {
        Medico medico = InputDialog.obtenerDatosMedico();
        if (medico != null) {
            medicoDAO.crearMedico(medico);
        }
    }

    private static void leerMedico() {
        int id = InputDialog.obtenerIdMedico();
        if (id != -1) {
            Medico medico = medicoDAO.leerMedico(id);
            if (medico != null) {
                JOptionPane.showMessageDialog(null, "Médico encontrado:\n" +
                        "ID: " + medico.getId() + "\n" +
                        "Nombre: " + medico.getNombre() + "\n" +
                        "Especialidad ID: " + medico.getEspecialidadId() + "\n" +
                        "Horario de Inicio: " + medico.getHorarioInicio() + "\n" +
                        "Horario de Fin: " + medico.getHorarioFin());
            } else {
                JOptionPane.showMessageDialog(null, "Médico no encontrado");
            }
        }
    }

    private static void actualizarMedico() {
        int id = InputDialog.obtenerIdMedico();
        if (id != -1) {
            Medico medicoExistente = medicoDAO.leerMedico(id);
            if (medicoExistente != null) {
                Medico medicoActualizado = InputDialog.obtenerDatosMedicoActualizar(medicoExistente);
                if (medicoActualizado != null) {
                    medicoDAO.actualizarMedico(medicoActualizado);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Médico no encontrado");
            }
        }
    }

    private static void eliminarMedico() {
        int id = InputDialog.obtenerIdMedico();
        if (id != -1) {
            medicoDAO.eliminarMedico(id);
        }
    }

    private static void listarMedicos() {
        List<Medico> medicos = medicoDAO.obtenerMedicos();
        if (medicos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay médicos en la base de datos.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Medico medico : medicos) {
                sb.append("ID: ").append(medico.getId()).append("\n")
                  .append("Nombre: ").append(medico.getNombre()).append("\n")
                  .append("Especialidad ID: ").append(medico.getEspecialidadId()).append("\n")
                  .append("Horario de Inicio: ").append(medico.getHorarioInicio()).append("\n")
                  .append("Horario de Fin: ").append(medico.getHorarioFin()).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }
}
