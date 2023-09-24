
package empresa;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Tienda {
    private ArrayList<Proveedor> proveedores;
    private ArrayList<Cliente> clientes;
    
    public Tienda (){
        proveedores=new ArrayList<>();
        clientes=new ArrayList<>();
    }
    
    public String agregarProveedor(String ruc, String nombre, String direccion, String nombreProducto, String codigoProducto, double precioUnitProducto, int stockProducto){
        boolean proveedorRegistrado=false;
        boolean productoRegistrado=false;
       
        for (int i=0;i<proveedores.size();i++){
            Proveedor proveedor=proveedores.get(i);
            
            if(proveedor.getRuc().equals(ruc)){
                proveedorRegistrado=true;
                
                for(int j=0;j<proveedor.getProductosProveedor().size();j++){
                    Producto producto=proveedor.getProductosProveedor().get(j);

                    if(producto.getCodigo().equals(codigoProducto)){
                        productoRegistrado=true;
                        
                        proveedores.remove(i);
                        proveedor.getProductosProveedor().remove(j);
                        producto.setStock(producto.getStock()+stockProducto);
                        proveedor.getProductosProveedor().add(producto);
                        proveedores.add(proveedor);
                        return("Producto abastecido con exito.");
                    }

                }
            }
                
        }
        
        if(proveedorRegistrado==true && productoRegistrado==false){
            for(int i=0;i<proveedores.size();i++){
                Proveedor proveedor=proveedores.get(i);
                
                if(proveedor.getRuc().equals(ruc)){
                    proveedores.remove(i);
                    Producto productoNuevo= new Producto(nombreProducto,codigoProducto,precioUnitProducto,stockProducto);
                    proveedor.getProductosProveedor().add(productoNuevo);
                    proveedores.add(proveedor);
                    return("Producto agregado a proveedor con éxito.");
                }
            }
        }
        
        
        if(proveedorRegistrado==false){
            productoRegistrado=false;
 
            for(int i=0;i<proveedores.size();i++){
                Proveedor proveedor=proveedores.get(i);
                
                for(int j=0;j<proveedor.getProductosProveedor().size();j++){
                    Producto producto=proveedor.getProductosProveedor().get(j);
                    
                    if(producto.getCodigo().equals(codigoProducto)){
                       productoRegistrado=true;
                       return("Producto ya abastecido por otro proveedor."); 
                    }
                }
            }
            
            if(productoRegistrado==false){
                Proveedor proveedorNuevo=new Proveedor(ruc, nombre, direccion);
                Producto productoNuevo= new Producto(nombreProducto,codigoProducto,precioUnitProducto, stockProducto);
                proveedorNuevo.getProductosProveedor().add(productoNuevo);
                proveedores.add(proveedorNuevo);
                return("Proveedor agregado con exito.");
                
            }
            
        }
        return null;
    }
    
    
    public String agregarCliente(String nombres, String apellidos, String dni, String direccion, String fechaNacimiento, String codigoProducto){
        boolean productoRegistrado=false;
        boolean clienteRegistrado=false;
        boolean productoEnProductosCliente=false;
        
        for(int i=0;i<proveedores.size();i++){
            Proveedor proveedor=proveedores.get(i);
            
            for(int j=0;j<proveedor.getProductosProveedor().size();j++){
                Producto producto=proveedor.getProductosProveedor().get(j);
                
                if(producto.getCodigo().equals(codigoProducto)){
                    productoRegistrado=true;
                    proveedores.remove(i);
                    proveedor.getProductosProveedor().remove(j);
                    producto.setStock(producto.getStock()-1);
                    proveedor.getProductosProveedor().add(producto);
                    proveedores.add(proveedor);
                    break;
                }
            }
            
            
        }
        
        if(productoRegistrado==true){
            for(int i=0;i<clientes.size();i++){
                Cliente cliente=clientes.get(i);
                ArrayList <Producto>productos=new ArrayList<>(cliente.getProductosCliente().keySet());
                
                if(cliente.getDni().equals(dni)){
                    clienteRegistrado=true;
                    
                    for(int j=0;j<productos.size();j++){
                        Producto producto=productos.get(j);

                        if(producto.getCodigo().equals(codigoProducto)){
                            productoEnProductosCliente=true;
                            int nProductos=cliente.getProductosCliente().get(producto);
                            nProductos+=1;
                            cliente.getProductosCliente().remove(producto);
                            cliente.getProductosCliente().put(producto, nProductos);
                            clientes.remove(i);
                            clientes.add(cliente);
                            return("Producto agregado a cliente con exito.");
                        }
                    }
                    
                    if(productoEnProductosCliente==false){
                        for(int j=0;j<proveedores.size();j++){
                            Proveedor proveedor=proveedores.get(j);
                            
                            for(int k=0;k<proveedor.getProductosProveedor().size();k++){
                                Producto producto=proveedor.getProductosProveedor().remove(k);
                                
                                if(producto.getCodigo().equals(codigoProducto)){
                                    cliente.getProductosCliente().put(producto, 1);
                                    clientes.remove(i);
                                    clientes.add(cliente);
                                    return("Nuevo producto agregado a cliente con exito.");
                                }
                            }
                        }
                    }
                }    
            }  
            
            if(clienteRegistrado==false){
                Cliente nuevoCliente= new Cliente(nombres,apellidos,dni,direccion,fechaNacimiento);
                
                for(int i=0;i<proveedores.size();i++){
                    Proveedor proveedor=proveedores.get(i);
                    
                    for(int j=0;j<proveedor.getProductosProveedor().size();j++){
                        Producto producto=proveedor.getProductosProveedor().get(j);
                        
                        if(producto.getCodigo().equals(codigoProducto)){
                            nuevoCliente.getProductosCliente().put(producto, 1);
                            clientes.add(nuevoCliente);
                            return("Cliente anadido con exito");
                        }
                    }
                }
            }
        }
        
        else{
            return("Código de producto no existe.");
        }
        
        return null;        
    }
    
    public String mostrarClientes(){
        StringBuilder mensaje=new StringBuilder();
        
        mensaje.append("<html>");
        for (int i=0;i<clientes.size();i++){
            Cliente cliente=clientes.get(i);
            mensaje.append("Nombres: " ).append(cliente.getNombres());
            mensaje.append("<br/>Apellidos: " ).append(cliente.getApellidos());
            mensaje.append("<br/>Dni: " ).append(cliente.getDni());
            mensaje.append("<br/>Fecha Nacimiento: " ).append(cliente.getFechaNacimiento());
            mensaje.append("<br/>Direccion: " ).append(cliente.getDireccion());
            
            mensaje.append("<br/>Productos: " );
            for(int j=0;j<cliente.getProductosCliente().size();j++){
                ArrayList<Producto> productos=new ArrayList<>(cliente.getProductosCliente().keySet());
                ArrayList<Integer> nProductos=new ArrayList<>(cliente.getProductosCliente().values());
                
                mensaje.append("<br/>&nbsp;Codigo: " ).append(productos.get(j).getCodigo());
                mensaje.append("<br/>&nbsp;Nombre: " ).append(productos.get(j).getNombre());
                mensaje.append("<br/>&nbsp;Precio unitario: " ).append(productos.get(j).getPrecioUnit());
                mensaje.append("<br/>&nbsp;Cantidad: " ).append(nProductos.get(j));
                mensaje.append("<br/>");
            }
            
            mensaje.append("<br/>");
        }
        mensaje.append("<html>");
        
        return(mensaje.toString());
    }
    
    public String mostrarProveedores(){
        StringBuilder mensaje=new StringBuilder();
        
        mensaje.append("<html>");
        for (int i=0;i<proveedores.size();i++){
            Proveedor proveedor=proveedores.get(i);
            mensaje.append("Nombre: " ).append(proveedor.getNombre());
            mensaje.append("<br/>Ruc: " ).append(proveedor.getRuc());
            mensaje.append("<br/>Direccion: " ).append(proveedor.getDireccion());
            
            mensaje.append("<br/>Productos: " );
            for(int j=0;j<proveedor.getProductosProveedor().size();j++){
                Producto producto=proveedor.getProductosProveedor().get(j);
                
                mensaje.append("<br/>&nbsp;Codigo: " ).append(producto.getCodigo());
                mensaje.append("<br/>&nbsp;Nombre: " ).append(producto.getNombre());
                mensaje.append("<br/>&nbsp;Precio unitario: " ).append(producto.getPrecioUnit());
                mensaje.append("<br/>&nbsp;Stock: " ).append(producto.getStock());
                mensaje.append("<br/>");
            }
            
            mensaje.append("<br/>");
        }
        mensaje.append("</html>");
        
        return(mensaje.toString());
    
    }
    
  
}

