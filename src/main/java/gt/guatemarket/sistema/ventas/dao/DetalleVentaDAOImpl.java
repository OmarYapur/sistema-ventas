/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.guatemarket.sistema.ventas.dao;

import gt.guatemarket.sistema.ventas.modelo.DetalleConsultaVenta;
import gt.guatemarket.sistema.ventas.config.ConexionBD;
import gt.guatemarket.sistema.ventas.modelo.DetalleVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

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

    @Override
    public List<DetalleConsultaVenta> listarPorVenta(String idVenta) {
        List<DetalleConsultaVenta> detalles = new ArrayList<>();
        String sql = "SELECT nombreProducto, cantidadProducto, precioUnitario, Total " + "FROM detalle_venta " + "WHERE idVenta = ?";
        try (Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, idVenta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DetalleConsultaVenta detalle = new DetalleConsultaVenta();
                detalle.setNombreProducto(rs.getString("nombreProducto"));
                detalle.setCantidad(rs.getInt("cantidadProducto"));
                detalle.setPrecioUnitario(rs.getDouble("precioUnitario"));
                detalle.setTotal(rs.getDouble("Total"));
                detalles.add(detalle);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar el detalle:\n" + e.getMessage());
        }
        return detalles;
    }
}
