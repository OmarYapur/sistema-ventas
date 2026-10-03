/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.guatemarket.sistema.ventas.dao;

import gt.guatemarket.sistema.ventas.config.ConexionBD;
import gt.guatemarket.sistema.ventas.modelo.OrdenDespacho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author omary
 */

import javax.swing.JOptionPane;

public class OrdenDespachoDAOImpl implements OrdenDespachoDAO {

    @Override
    public List<OrdenDespacho> buscarPorVenta(String idVenta) {

        List<OrdenDespacho> detalles = new ArrayList<>();

        String sql = "SELECT d.idProducto, d.nombreProducto, "
                + "d.cantidadProducto, p.stockproducto "
                + "FROM detalle_venta d "
                + "INNER JOIN inventario_productos p "
                + "ON d.idProducto = p.idproducto "
                + "WHERE d.idVenta = ?";

        try (Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, idVenta);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                OrdenDespacho detalle
                        = new OrdenDespacho();

                detalle.setIdProducto(
                        rs.getString("idProducto")
                );

                detalle.setNombreProducto(
                        rs.getString("nombreProducto")
                );

                detalle.setCantidadSolicitada(
                        rs.getInt("cantidadProducto")
                );

                detalle.setStockDisponible(
                        rs.getInt("stockproducto")
                );

                detalles.add(detalle);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error al consultar la venta:\n"
                    + e.getMessage()
            );
        }

        return detalles;
    }
}
