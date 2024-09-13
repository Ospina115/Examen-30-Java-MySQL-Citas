package com.examenjava.paciente;

import com.examenjava.infrastructure.DatabaseConfig;
import com.examenjava.paciente.Paciente;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    public void crearPaciente(Paciente paciente) {
        String sql = "INSERT INTO Paciente (nombre, apellido, fecha_nacimiento, direccion, telefono, email) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, paciente.getNombre());
            pstmt.setString(2, paciente.getApellido());
            pstmt.setDate(3, new java.sql.Date(paciente.getFechaNacimiento().getTime()));
            pstmt.setString(4, paciente.getDireccion());
            pstmt.setString(5, paciente.getTelefono());
            pstmt.setString(6, paciente.getEmail());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Paciente creado exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al crear paciente: " + e.getMessage());
        }
    }

    public Paciente leerPaciente(int id) {
        String sql = "SELECT * FROM Paciente WHERE id = ?";
        Paciente paciente = null;
        try (Connection conn = DatabaseConfig.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                paciente = new Paciente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paciente;
    }

    public void actualizarPaciente(Paciente paciente) {
        String sql = "UPDATE Paciente SET nombre = ?, apellido = ?, fecha_nacimiento = ?, direccion = ?, telefono = ?, email = ? WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, paciente.getNombre());
            pstmt.setString(2, paciente.getApellido());
            pstmt.setDate(3, new java.sql.Date(paciente.getFechaNacimiento().getTime()));
            pstmt.setString(4, paciente.getDireccion());
            pstmt.setString(5, paciente.getTelefono());
            pstmt.setString(6, paciente.getEmail());
            pstmt.setInt(7, paciente.getId());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Paciente actualizado exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar paciente: " + e.getMessage());
        }
    }

    public void eliminarPaciente(int id) {
        String sql = "DELETE FROM Paciente WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Paciente eliminado exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al eliminar paciente: " + e.getMessage());
        }
    }

    public List<Paciente> obtenerPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM Paciente";
        try (Connection conn = DatabaseConfig.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Paciente paciente = new Paciente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("email")
                );
                pacientes.add(paciente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacientes;
    }
}
