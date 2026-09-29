/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.guatemarket.sistema.ventas.dao;

import gt.guatemarket.sistema.ventas.config.ConexionBD;
import gt.guatemarket.sistema.ventas.modelo.Producto;
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
public class ProductoDAOImpl implements ProductoDAO {

    @Override
    public void guardar(Producto producto) {

        String sql = "INSERT INTO inventario_productos "
                + "(idproducto, nombreproducto, categoriaproducto, precioproducto, stockproducto) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, producto.getIdProducto());
            ps.setString(2, producto.getNombreProducto());
            ps.setString(3, producto.getCategoriaProducto());
            ps.setDouble(4, producto.getPrecio());
            ps.setInt(5, producto.getStock());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();

        String sql = "SELECT idproducto, nombreproducto, categoriaproducto, precioproducto, stockproducto FROM inventario_productos";

        try (Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Producto producto = new Producto();

                producto.setIdProducto(rs.getString("idproducto"));
                producto.setNombreProducto(rs.getString("nombreproducto"));
                producto.setCategoriaProducto(rs.getString("categoriaProducto"));
                producto.setPrecio(rs.getDouble("precioproducto"));
                producto.setStock(rs.getInt("stockproducto"));

                productos.add(producto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productos;
    }

    @Override
    public Producto buscarPorId(int id) {
        Producto producto = null;

        String sql = "SELECT idproducto, nombreproducto, categoriaproducto, precioproducto, stockproducto FROM inventario_productos WHERE idproducto = ?";

            try {
                Connection cn = ConexionBD.conectar();
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, id);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    producto = new Producto();
                    producto.setIdProducto(rs.getString("idproducto"));
                    producto.setNombreProducto(rs.getString("nombreproducto"));
                    producto.setCategoriaProducto(rs.getString("categoriaproducto"));
                    producto.setPrecio(rs.getDouble("precio"));
                    producto.setStock(rs.getInt("stock"));
                }

        } catch (SQLException e) {
            System.out.println("Error al buscar producto: " + e.getMessage());
        }

        return producto;
    }

    @Override
    public void actualizar(Producto producto) {
        String sql = "UPDATE inventario_productos "
                + "SET nombreproducto = ?, "
                + "categoriaproducto = ?, "
                + "precioproducto = ?, "
                + "stockproducto = ? "
                + "WHERE idproducto = ?";

        try (Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getCategoriaProducto());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setString(5, producto.getIdProducto());

            ps.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar producto: " + e.getMessage());
        }
    }

    @Override
    public void agregarStock(String idProducto, int cantidad) {
        String sql = "UPDATE inventario_productos "
                + "SET stockproducto = stockproducto + ? "
                + "WHERE idproducto = ?";

        try (Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, cantidad);
            ps.setString(2, idProducto);

            int filas = ps.executeUpdate();

            if (filas == 0) {
                JOptionPane.showMessageDialog(null,
                        "El producto no existe.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Error al agregar stock: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM inventario_productos WHERE idproducto = ?";

        try (Connection cn = ConexionBD.conectar(); PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Error al eliminar producto: " + e.getMessage());
        }
    }
}
