/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.guatemarket.sistema.ventas.modelo;

/**
 *
 * @author omary
 */
public class Empleado {

    private String codigoEmpleado;
    private String nombreEmpleado;
    private String areaEmpleado;
    private String estadoEmpleado;

    public Empleado() {
    }

    public Empleado(String codigoEmpleado, String nombreEmpleado, String areaEmpleado, String estadoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.areaEmpleado = areaEmpleado;
        this.estadoEmpleado = estadoEmpleado;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getAreaEmpleado() {
        return areaEmpleado;
    }

    public void setAreaEmpleado(String areaEmpleado) {
        this.areaEmpleado = areaEmpleado;
    }

    public String getEstadoEmpleado() {
        return estadoEmpleado;
    }

    public void setEstadoEmpleado(String estadoEmpleado) {
        this.estadoEmpleado = estadoEmpleado;
    }
}
