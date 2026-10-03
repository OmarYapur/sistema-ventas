package gt.guatemarket.sistema.ventas.modelo;

public class Factura {

    private String idFactura;
    private String idVenta;
    private String fechaFactura;
    private double total;

    public Factura() {
    }

    public Factura(String idFactura, String idVenta, String fechaFactura, double total) {
        this.idFactura = idFactura;
        this.idVenta = idVenta;
        this.fechaFactura = fechaFactura;
        this.total = total;
    }

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
