/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.guatemarket.sistema.ventas.dao;

import gt.guatemarket.sistema.ventas.config.ConexionBD;
import gt.guatemarket.sistema.ventas.modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author omary
 */

public class EmpleadoDAOImpl implements EmpleadoDAO {

    @Override
    public boolean guardar(Empleado empleado) {
        String sql = "INSERT INTO empleados " + "(codigoEmpleado, nombreEmpleado, areaEmpleado, estadoEmpleado) " + "VALUES (?, ?, ?, ?)";
        try (Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, empleado.getCodigoEmpleado());
            ps.setString(2, empleado.getNombreEmpleado());
            ps.setString(3, empleado.getAreaEmpleado());
            ps.setString(4, empleado.getEstadoEmpleado());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar empleado:\n" + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Empleado> listar() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleados";
        try (Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setCodigoEmpleado(rs.getString("codigoEmpleado"));
                empleado.setNombreEmpleado(rs.getString("nombreEmpleado"));
                empleado.setAreaEmpleado(rs.getString("areaEmpleado"));
                empleado.setEstadoEmpleado(rs.getString("estadoEmpleado"));
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar empleados:\n" + e.getMessage());
        }
        return empleados;
    }

    @Override
    public Empleado buscarPorCodigo(String codigo) {
        String sql = "SELECT * FROM empleados " + "WHERE codigoEmpleado = ?";
        try (Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setCodigoEmpleado(rs.getString("codigoEmpleado"));
                empleado.setNombreEmpleado(rs.getString("nombreEmpleado"));
                empleado.setAreaEmpleado(rs.getString("areaEmpleado"));
                empleado.setEstadoEmpleado(rs.getString("estadoEmpleado"));
                return empleado;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar empleado:\n" + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean actualizar(Empleado empleado) {
        String sql = "UPDATE empleados SET " + "nombreEmpleado = ?, " + "areaEmpleado = ?, " + "estadoEmpleado = ? " + "WHERE codigoEmpleado = ?";
        try (Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, empleado.getNombreEmpleado());
            ps.setString(2, empleado.getAreaEmpleado());
            ps.setString(3, empleado.getEstadoEmpleado());
            ps.setString(4, empleado.getCodigoEmpleado());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar empleado:\n" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(String codigo) {
        String sql = "DELETE FROM empleados " + "WHERE codigoEmpleado = ?";
        try (Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, codigo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar empleado:\n" + e.getMessage());
            return false;
        }
    }
}
