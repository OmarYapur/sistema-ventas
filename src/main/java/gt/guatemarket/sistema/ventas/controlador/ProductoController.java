/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.guatemarket.sistema.ventas.controlador;

import gt.guatemarket.sistema.ventas.dao.ProductoDAOImpl;
import gt.guatemarket.sistema.ventas.modelo.Producto;
import java.util.List;

/**
 *
 * @author omary
 */
public class ProductoController {

    ProductoDAOImpl dao;

    public ProductoController() {
        dao = new ProductoDAOImpl();
    }

    public void Guardar(Producto producto) {
        dao.guardar(producto);
    }

    public List<Producto> GetProductos() {
        return dao.listar();
    }

    public void Eliminar(int idProducto) {
        dao.eliminar(idProducto);
    }

    public Producto BuscarPorId(int idProducto) {
        return dao.buscarPorId(idProducto);
    }
}
