/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gt.guatemarket.sistema.ventas.dao;

import gt.guatemarket.sistema.ventas.modelo.Factura;
import java.util.List;

/**
 *
 * @author omary
 */

public interface FacturaDAO {

    boolean guardar(Factura factura);

    List<Factura> listar();

    Factura buscarPorId(String idFactura);
}
