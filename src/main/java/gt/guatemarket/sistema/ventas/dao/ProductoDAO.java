/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gt.guatemarket.sistema.ventas.dao;

import gt.guatemarket.sistema.ventas.modelo.Producto;
import java.util.List;

/**
 *
 * @author omary
 */
public interface ProductoDAO {
    void guardar(Producto producto);

    List<Producto> listar();

    Producto buscarPorId(int id);

    void actualizar(Producto producto);

    void eliminar(int id);
}
