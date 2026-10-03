/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.guatemarket.sistema.ventas.dao;

import gt.guatemarket.sistema.ventas.config.ConexionBD;
import gt.guatemarket.sistema.ventas.modelo.Factura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author omary
 */
public class FacturaDAOImpl implements FacturaDAO {

    @Override
    public boolean guardar(Factura factura) {
        String sql = "INSERT INTO facturas " + "(idVenta, fechaFactura, total) " + "VALUES (?, ?, ?)";
        try (Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, factura.getIdVenta());
            ps.setString(2, factura.getFechaFactura());
            ps.setDouble(3, factura.getTotal());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Factura> listar() {

        List<Factura> facturas = new ArrayList<>();

        String sql = "SELECT idVenta, fechaFactura, total "
                + "FROM facturas "
                + "ORDER BY fechaFactura DESC";

        try (
                Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Factura factura = new Factura();

                factura.setIdVenta(rs.getString("idVenta"));
                factura.setFechaFactura(rs.getString("fechaFactura"));
                factura.setTotal(rs.getDouble("total"));

                facturas.add(factura);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar facturas: " + e.getMessage());
        }

        return facturas;
    }

    @Override
    public Factura buscarPorId(String idFactura) {
        String sql = "SELECT * FROM facturas " + "WHERE idFactura = ?";
        try (Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, idFactura);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Factura factura = new Factura();
                factura.setIdFactura(rs.getString("idFactura"));
                factura.setIdVenta(rs.getString("idVenta"));
                factura.setFechaFactura(rs.getString("fechaFactura"));
                factura.setTotal(rs.getDouble("total"));
                return factura;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
