package gt.guatemarket.sistema.ventas.modelo;

public class Cliente {

    private String codigo;
    private String nombre;
    private String dpi;
    private String nit;
    private String telefono;
    private String correo;
    private String tipoCliente;
    private String direccion;

    public Cliente() {
    }

    public Cliente(String codigo, String nombre, String dpi, String nit, String telefono, String correo, String tipoCliente, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.dpi = dpi;
        this.nit = nit;
        this.telefono = telefono;
        this.correo = correo;
        this.tipoCliente = tipoCliente;
        this.direccion = direccion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void registrarInformacion() {
        System.out.println("Registrando información del cliente: " + nombre);
    }

    public void realizarCompra() {
        System.out.println(nombre + " está realizando una compra.");
    }

    public void mostrarInformacion() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("DPI: " + dpi);
        System.out.println("NIT: " + nit);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Correo: " + correo);
        System.out.println("Tipo de cliente: " + tipoCliente);
        System.out.println("Dirección: " + direccion);
    }
}
