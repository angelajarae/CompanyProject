
package empresa;

import java.util.ArrayList;




public class Proveedor {
    private String ruc;
    private String nombre;
    private String direccion;
    private ArrayList<Producto> productosProveedor;

    public Proveedor(String ruc, String nombre, String direccion) {
        this.ruc = ruc;
        this.nombre = nombre;
        this.direccion = direccion;
        productosProveedor=new ArrayList<>();
        
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the productoProveedor
     */
    public ArrayList<Producto> getProductosProveedor() {
        return productosProveedor;
    }

    /**
     * @param productosProveedor the productoProveedor to set
     */
    public void setProductoProveedor(ArrayList<Producto> productosProveedor) {
        this.productosProveedor = productosProveedor;
    }
    
}
