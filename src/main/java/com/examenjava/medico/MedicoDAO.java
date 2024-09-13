package com.examenjava.medico;

import com.examenjava.infrastructure.DatabaseConfig;
import com.examenjava.medico.Medico;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {

    // Crear un nuevo médico
    public void crearMedico(Medico medico) {
        String sql = "INSERT INTO Medico (nombre, especialidad_id, horario_inicio, horario_fin) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, medico.getNombre());
            pstmt.setInt(2, medico.getEspecialidadId());
            pstmt.setTime(3, medico.getHorarioInicio());
            pstmt.setTime(4, medico.getHorarioFin());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Médico creado exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al crear médico: " + e.getMessage());
        }
    }

    // Leer un médico por ID
    public Medico leerMedico(int id) {
        String sql = "SELECT * FROM Medico WHERE id = ?";
        Medico medico = null;
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                medico = new Medico(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("especialidad_id"),
                        rs.getTime("horario_inicio"),
                        rs.getTime("horario_fin")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medico;
    }

    // Actualizar un médico
    public void actualizarMedico(Medico medico) {
        String sql = "UPDATE Medico SET nombre = ?, especialidad_id = ?, horario_inicio = ?, horario_fin = ? WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, medico.getNombre());
            pstmt.setInt(2, medico.getEspecialidadId());
            pstmt.setTime(3, medico.getHorarioInicio());
            pstmt.setTime(4, medico.getHorarioFin());
            pstmt.setInt(5, medico.getId());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Médico actualizado exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar médico: " + e.getMessage());
        }
    }

    // Eliminar un médico por ID
    public void eliminarMedico(int id) {
        String sql = "DELETE FROM Medico WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Médico eliminado exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al eliminar médico: " + e.getMessage());
        }
    }

    // Obtener todos los médicos
    public List<Medico> obtenerMedicos() {
        List<Medico> medicos = new ArrayList<>();
        String sql = "SELECT * FROM Medico";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Medico medico = new Medico(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("especialidad_id"),
                        rs.getTime("horario_inicio"),
                        rs.getTime("horario_fin")
                );
                medicos.add(medico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicos;
    }
}

