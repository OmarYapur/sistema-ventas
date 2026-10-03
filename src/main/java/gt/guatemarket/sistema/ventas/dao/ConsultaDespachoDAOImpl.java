/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.guatemarket.sistema.ventas.dao;

import gt.guatemarket.sistema.ventas.config.ConexionBD;
import gt.guatemarket.sistema.ventas.modelo.ConsultaDespacho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author omary
 */
public class ConsultaDespachoDAOImpl implements ConsultaDespachoDAO {

    @Override
    public List<ConsultaDespacho> listar() {
        List<ConsultaDespacho> despachos = new ArrayList<>();
        String sql = "SELECT idDespacho, idVenta, fechaDespacho, estadoDespacho " + "FROM despachos";
        try (Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                despachos.add(new ConsultaDespacho(rs.getString("idDespacho"), rs.getString("idVenta"), rs.getString("fechaDespacho"), rs.getString("estadoDespacho")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return despachos;
    }
}
