/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.guatemarket.sistema.ventas.dao;

import gt.guatemarket.sistema.ventas.config.ConexionBD;
import gt.guatemarket.sistema.ventas.modelo.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author omary
 */

public class VentaDAOImpl implements VentaDAO {

    @Override
    public String guardar(Venta venta) {

        String sql = "INSERT INTO ventas "
                + "(nombreCliente, dpiCliente, nitCliente, telefonoCliente, "
                + "correoCliente, direccionCliente, fechaVenta) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement(
                sql,
                PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, venta.getNombre());
            ps.setString(2, venta.getDpi());
            ps.setString(3, venta.getNit());
            ps.setString(4, venta.getTelefono());
            ps.setString(5, venta.getCorreo());
            ps.setString(6, venta.getDireccion());
            ps.setString(7, venta.getFechaVenta());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                return rs.getString(1);
            }

        } catch (SQLException e) {
            System.out.println("Error al guardar venta: " + e.getMessage());
        }

        return null;
    }
}
