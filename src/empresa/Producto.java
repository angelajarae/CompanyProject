
package empresa;


public class Producto {
    private String nombre;
    private String codigo;
    private double precioUnit;
    private int stock;

    public Producto(String nombre, String codigo, double precioUnit, int stock) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precioUnit = precioUnit;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(double precioUnit) {
        this.precioUnit = precioUnit;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
