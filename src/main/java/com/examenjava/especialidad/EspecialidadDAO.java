package com.examenjava.dao;

import com.examenjava.infrastructure.DatabaseConfig;
import com.examenjava.model.Especialidad;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadDAO {

    // Crear una nueva especialidad
    public void crearEspecialidad(Especialidad especialidad) {
        String sql = "INSERT INTO Especialidad (nombre) VALUES (?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, especialidad.getNombre());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Especialidad creada exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al crear especialidad: " + e.getMessage());
        }
    }

    // Leer una especialidad por ID
    public Especialidad leerEspecialidad(int id) {
        String sql = "SELECT * FROM Especialidad WHERE id = ?";
        Especialidad especialidad = null;
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                especialidad = new Especialidad(
                        rs.getInt("id"),
                        rs.getString("nombre")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return especialidad;
    }

    // Actualizar una especialidad
    public void actualizarEspecialidad(Especialidad especialidad) {
        String sql = "UPDATE Especialidad SET nombre = ? WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, especialidad.getNombre());
            pstmt.setInt(2, especialidad.getId());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Especialidad actualizada exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar especialidad: " + e.getMessage());
        }
    }

    // Eliminar una especialidad por ID
    public void eliminarEspecialidad(int id) {
        String sql = "DELETE FROM Especialidad WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Especialidad eliminada exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al eliminar especialidad: " + e.getMessage());
        }
    }

    // Obtener todas las especialidades
    public List<Especialidad> obtenerEspecialidades() {
        List<Especialidad> especialidades = new ArrayList<>();
        String sql = "SELECT * FROM Especialidad";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Especialidad especialidad = new Especialidad(
                        rs.getInt("id"),
                        rs.getString("nombre")
                );
                especialidades.add(especialidad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return especialidades;
    }
}
