/* En esta clase se van a crear objetios del tipo insumo tales que contienen ID, nombre, unidad de medida, cantidad y precio*/
package Modelo;

import java.math.BigDecimal;

/**
 *
 * @author erofa
 */
public class Insumo {
    
    private int ID;
    private String nombre;
    private String unidadMedida;
    private BigDecimal cantidad;
    private BigDecimal precio;
    private String fecha;
    private String transaccion;

    //Constructor
    public Insumo(int ID, String nombre, String unidadMedida, BigDecimal cantidad, BigDecimal precio, String fecha, String transaccion) {
        this.ID = ID;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha = fecha;
        this.transaccion = transaccion;
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

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(String transaccion) {
        this.transaccion = transaccion;
    }
    
    
    
        
}
