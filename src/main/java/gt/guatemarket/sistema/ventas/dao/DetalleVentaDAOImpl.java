/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.guatemarket.sistema.ventas.dao;

import gt.guatemarket.sistema.ventas.config.ConexionBD;
import gt.guatemarket.sistema.ventas.modelo.DetalleVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author omary
 */
public class DetalleVentaDAOImpl implements DetalleVentaDAO {

    @Override
    public boolean guardar(DetalleVenta detalle) {
        String sql = "INSERT INTO detalle_venta " + "(idVenta, idProducto, nombreProducto, cantidadProducto, precioUnitario, Total) " + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, detalle.getIdVenta());
            ps.setString(2, detalle.getIdProducto());
            ps.setString(3, detalle.getNombreProducto());
            ps.setInt(4, detalle.getCantidadProducto());
            ps.setDouble(5, detalle.getPrecioUnitario());
            ps.setDouble(6, detalle.getTotal());
            int filas = ps.executeUpdate();
            System.out.println("Filas insertadas: " + filas);
            return filas > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error al guardar detalle:\n" + e.getMessage()
            );
            return false;
        }
    }
}
