/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gt.guatemarket.sistema.ventas.dao;

import gt.guatemarket.sistema.ventas.modelo.Cliente;
import java.util.List;

/**
 *
 * @author omary
 */
public interface ClienteDAO {
    void guardar(Cliente cliente);

    List<Cliente> listar();

    Cliente buscarPorId(int id);
    
    Cliente buscarPorNombre(String nombre);

    void actualizar(Cliente cliente);

    void eliminar(int id);
}
