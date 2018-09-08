package sv.edu.unab.GuiaDos.Dominio;

import java.util.StringJoiner;

public class Cliente {
    private String codigo;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String Direccion;
    private int telefono;
    private Character TipoCliente;

    public Cliente() {
    }

    public Cliente(String codigo) {
        this.codigo = codigo;
    }


    public Cliente(String codigo, String nombre, String apellidoPaterno, String apellidoMaterno,String Direccion, int telefono, Character TipoCliente) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.Direccion = Direccion;
        this.telefono = telefono;
        this.TipoCliente =TipoCliente;
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

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Character getTipoCliente() {
        return TipoCliente;
    }

    public void setTipoCliente(Character tipoCliente) {
        TipoCliente = tipoCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;

        Cliente cliente = (Cliente) o;

        return codigo.equals(cliente.codigo);
    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }

    @Override
    public String toString() {
        return new StringJoiner("")
                .add(codigo)
                .toString();
    }

    public String toString1() {
        return new StringJoiner(", ", Cliente.class.getSimpleName() + "[", "]")
                .add("codigo='" + codigo + "'")
                .add("nombre='" + nombre + "'")
                .add("apellidoPaterno='" + apellidoPaterno + "'")
                .add("apellidoMaterno='" + apellidoMaterno + "'")
                .add("Direccion='" + Direccion + "'")
                .add("telefono=" + telefono)
                .add("tipoCliente='" + TipoCliente + "'")
                .toString();
    }
}

