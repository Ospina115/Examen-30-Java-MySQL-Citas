package com.examenjava.dao;

import com.examenjava.infrastructure.DatabaseConfig;
import com.examenjava.model.Cita;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO {

    // Crear una nueva cita
    public void crearCita(Cita cita) {
        String sql = "INSERT INTO Cita (paciente_id, medico_id, fecha_hora, estado) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, cita.getPacienteId());
            pstmt.setInt(2, cita.getMedicoId());
            pstmt.setTimestamp(3, Timestamp.valueOf(cita.getFechaHora()));
            pstmt.setString(4, cita.getEstado());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cita creada exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al crear cita: " + e.getMessage());
        }
    }

    // Leer una cita por ID
    public Cita leerCita(int id) {
        String sql = "SELECT * FROM Cita WHERE id = ?";
        Cita cita = null;
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                cita = new Cita(
                        rs.getInt("id"),
                        rs.getInt("paciente_id"),
                        rs.getInt("medico_id"),
                        rs.getTimestamp("fecha_hora").toLocalDateTime(),
                        rs.getString("estado")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cita;
    }

    // Actualizar una cita
    public void actualizarCita(Cita cita) {
        String sql = "UPDATE Cita SET paciente_id = ?, medico_id = ?, fecha_hora = ?, estado = ? WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, cita.getPacienteId());
            pstmt.setInt(2, cita.getMedicoId());
            pstmt.setTimestamp(3, Timestamp.valueOf(cita.getFechaHora()));
            pstmt.setString(4, cita.getEstado());
            pstmt.setInt(5, cita.getId());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cita actualizada exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar cita: " + e.getMessage());
        }
    }

    // Eliminar una cita por ID
    public void eliminarCita(int id) {
        String sql = "DELETE FROM Cita WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cita eliminada exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al eliminar cita: " + e.getMessage());
        }
    }

    // Obtener todas las citas
    public List<Cita> obtenerCitas() {
        List<Cita> citas = new ArrayList<>();
        String sql = "SELECT * FROM Cita";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cita cita = new Cita(
                        rs.getInt("id"),
                        rs.getInt("paciente_id"),
                        rs.getInt("medico_id"),
                        rs.getTimestamp("fecha_hora").toLocalDateTime(),
                        rs.getString("estado")
                );
                citas.add(cita);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return citas;
    }
}
