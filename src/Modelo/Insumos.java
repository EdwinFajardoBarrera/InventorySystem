/* En esta clase se van a crear objetios del tipo insumo tales que contienen ID, nombre, unidad de medida, cantidad y precio*/
package Modelo;

/**
 *
 * @author erofa
 */
public class Insumos {
    
    private int ID;
    private String nombre;
    private String unidadMedida;
    private int cantidad;
    private double precio;
    private String fecha;

    //Constructor
    public Insumos(int ID, String nombre, String unidadMedida, int cantidad, double precio, String fecha) {
        this.ID = ID;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha = fecha;
    }

        public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
        
}
