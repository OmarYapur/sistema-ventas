/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.guatemarket.sistema.ventas.dao;

import gt.guatemarket.sistema.ventas.modelo.ConsultaVenta;
import gt.guatemarket.sistema.ventas.config.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author omary
 */
public class ConsultaVentaDAOImpl implements ConsultaVentaDAO {

    @Override
    public List<ConsultaVenta> listar() {
        List<ConsultaVenta> ventas = new ArrayList<>();
        String sql = "SELECT v.idVenta, v.nombreCliente, v.fechaVenta, " + "COALESCE(SUM(d.cantidadProducto * d.precioUnitario), 0) AS total " + "FROM ventas v " + "LEFT JOIN detalle_venta d ON v.idVenta = d.idVenta " + "GROUP BY v.idVenta, v.nombreCliente, v.fechaVenta " + "ORDER BY v.idVenta DESC";
        try (Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                ConsultaVenta venta = new ConsultaVenta();
                venta.setIdVenta(rs.getString("idVenta"));
                venta.setNombreCliente(rs.getString("nombreCliente"));
                venta.setFechaVenta(rs.getString("fechaVenta"));
                venta.setTotal(rs.getDouble("total"));
                ventas.add(venta);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar ventas: " + e.getMessage());
        }
        return ventas;
    }
}
