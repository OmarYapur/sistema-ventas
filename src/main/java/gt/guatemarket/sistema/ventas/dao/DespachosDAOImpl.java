/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.guatemarket.sistema.ventas.dao;

import gt.guatemarket.sistema.ventas.config.ConexionBD;
import gt.guatemarket.sistema.ventas.modelo.Despachos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author omary
 */

public class DespachosDAOImpl implements DespachosDAO {

    @Override
    public boolean guardar(Despachos orden) {
        String sql = "INSERT INTO despachos " + "(idVenta, fechaDespacho, estadoDespacho) " + "VALUES (?, ?, ?)";
        try (Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, orden.getIdVenta());
            ps.setString(2, orden.getFechaDespacho());
            ps.setString(3, orden.getEstadoDespacho());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la orden de despacho:\n" + e.getMessage());
            return false;
        }
    }
}
