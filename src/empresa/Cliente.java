
package empresa;

import java.util.HashMap;
import java.util.Map;


public class Cliente {
    private String nombres;
    private String apellidos;
    private String dni;
    private String direccion;
    private String fechaNacimiento;
    private Map<Producto,Integer>productosCliente;

    public Cliente(String nombres, String apellidos, String dni, String direccion, String fechaNacimiento) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        productosCliente = new HashMap<>();
        
    }


    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the productosCliente
     */
    public Map<Producto,Integer> getProductosCliente() {
        return productosCliente;
    }

    /**
     * @param productosCliente the productosCliente to set
     */
    public void setProductosCliente(Map<Producto,Integer> productosCliente) {
        this.productosCliente = productosCliente;
    }
    
}
