/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.guatemarket.sistema.ventas.dao;

import gt.guatemarket.sistema.ventas.config.ConexionBD;
import gt.guatemarket.sistema.ventas.modelo.Cliente;
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
public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public void guardar(Cliente cliente) {
        String sql = "INSERT INTO clientes " + "(codigoCliente, nombreCliente, dpiCliente, nitCliente, " + "telefonoCliente, correoCliente, tipoCliente, direccionCliente) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, cliente.getCodigo());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getDpi());
            ps.setString(4, cliente.getNit());
            ps.setString(5, cliente.getTelefono());
            ps.setString(6, cliente.getCorreo());
            ps.setString(7, cliente.getTipoCliente());
            ps.setString(8, cliente.getDireccion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT codigoCliente, nombreCliente, dpiCliente, " + "nitCliente, telefonoCliente, correoCliente, " + "tipoCliente, direccionCliente FROM clientes";
        try (Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getString("codigoCliente"), rs.getString("nombreCliente"), rs.getString("dpiCliente"), rs.getString("nitCliente"), rs.getString("telefonoCliente"), rs.getString("correoCliente"), rs.getString("tipoCliente"), rs.getString("direccionCliente"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public Cliente buscarPorId(int id) {
        Cliente cliente = null;
        String sql = "SELECT codigoCliente, nombreCliente, dpiCliente, " + "nitCliente, telefonoCliente, correoCliente, " + "tipoCliente, direccionCliente " + "FROM clientes WHERE codigoCliente = ?";
        try (Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Cliente(rs.getString("codigoCliente"), rs.getString("nombreCliente"), rs.getString("dpiCliente"), rs.getString("nitCliente"), rs.getString("telefonoCliente"), rs.getString("correoCliente"), rs.getString("tipoCliente"), rs.getString("direccionCliente"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
    public Cliente buscarPorNombre(String nombre) {

        Cliente cliente = null;

        String sql = "SELECT codigoCliente, nombreCliente, dpiCliente, "
                + "nitCliente, telefonoCliente, correoCliente, "
                + "tipoCliente, direccionCliente "
                + "FROM clientes WHERE nombreCliente = ?";

        try (Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, nombre);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                cliente = new Cliente(
                        rs.getString("codigoCliente"),
                        rs.getString("nombreCliente"),
                        rs.getString("dpiCliente"),
                        rs.getString("nitCliente"),
                        rs.getString("telefonoCliente"),
                        rs.getString("correoCliente"),
                        rs.getString("tipoCliente"),
                        rs.getString("direccionCliente")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }

    @Override
    public void actualizar(Cliente cliente) {
        String sql = "UPDATE clientes SET " + "nombreCliente = ?, " + "dpiCliente = ?, " + "nitCliente = ?, " + "telefonoCliente = ?, " + "correoCliente = ?, " + "tipoCliente = ?, " + "direccionCliente = ? " + "WHERE codigoCliente = ?";
        try (Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDpi());
            ps.setString(3, cliente.getNit());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getCorreo());
            ps.setString(6, cliente.getTipoCliente());
            ps.setString(7, cliente.getDireccion());
            ps.setString(8, cliente.getCodigo());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM clientes WHERE codigoCliente = ?";
        try (Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
