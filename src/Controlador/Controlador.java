/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edwin Fajardo
 */
public class Controlador implements ActionListener {
    
    private final MainView  vMain;
    private final ComprasView vCompras;
    private final ProduccionView vProduccion;
    private final RegistroInventarioView vRegistroInventarios;
    private final SalirView vSalir;
    private final NuevoInsumoView vNewInsumo;
    private final InventariosView vInventarios;
    private final Insumo insumos;
    private ArrayList<Insumo> listaInsumos;
    private ArrayList<String> listaUnidadesMed;
    private ArrayList<Insumo> listaRegistroInsumos;
    private ArrayList<Insumo> listaInventarios;
    private ArrayList<Producto> listaProductos;
    
    //Constructor
    public Controlador(MainView vMain, ComprasView vCompras, ProduccionView vProduccion, RegistroInventarioView vRegistroInventarios, SalirView vSalir, NuevoInsumoView vNewInsumo, InventariosView vInventarios, Insumo insumos, ArrayList<Insumo> listaInsumos, ArrayList<String> listaUnidadesMed, ArrayList<Insumo> listaRegistroInsumos, ArrayList<Insumo> listaInventarios) {
        this.vMain = vMain;
        this.vCompras = vCompras;
        this.vProduccion = vProduccion;
        this.vRegistroInventarios = vRegistroInventarios;
        this.vSalir = vSalir;
        this.vNewInsumo = vNewInsumo;
        this.vInventarios = vInventarios;
        this.insumos = insumos;
        this.listaInsumos = listaInsumos;
        this.listaUnidadesMed = listaUnidadesMed;
        this.listaRegistroInsumos = listaRegistroInsumos;
        this.listaInventarios = listaInventarios;
    }     
    

    public void iniciar() {
        ItemListener s = null;
        ItemListener s2 = null;
        
        vMain.setVisible(true);
        vCompras.setVisible(false);
        vProduccion.setVisible(false);
        vInventarios.setVisible(false);
        vSalir.setVisible(false);
        vRegistroInventarios.setVisible(false);
        vNewInsumo.setVisible(false);
        
        
        //Titulos de ventanas
        vMain.setTitle("Bowisa");
        vCompras.setTitle("Compras");
        vProduccion.setTitle("Producción");
        vRegistroInventarios.setTitle("Registro de compras y ventas");
        vSalir.setTitle("Salir");
        vNewInsumo.setTitle("Nuevo insumo");
        vInventarios.setTitle("Inventarios");
        
        //Locación de las ventanas
        vMain.setLocationRelativeTo(null);
        vCompras.setLocationRelativeTo(null);
        vProduccion.setLocationRelativeTo(null);
        vRegistroInventarios.setLocationRelativeTo(null);
        vSalir.setLocationRelativeTo(null);
        vNewInsumo.setLocationRelativeTo(null);
        vInventarios.setLocationRelativeTo(null);
        
        //Botones Main
        vMain.JBCompras.addActionListener(this);
        vMain.JBProduccion.addActionListener(this);
        vMain.JBRegistroInsumos.addActionListener(this);
        vMain.JBInventarios.addActionListener(this);
        vMain.JBSalir.addActionListener(this);
        
        //Botones Compras
        vCompras.JBGuardar.addActionListener(this);
        vCompras.JBNuevoInsumo.addActionListener(this);
        vCompras.JBSalir.addActionListener(this);
        vCompras.JCBInsumos.addItemListener(s);
        
        //Botones Produccion
        vProduccion.JBSalir.addActionListener(this);
        
        //Botones Inventarios
        vInventarios.JBSalir.addActionListener(this);
        
        //Botones RegistroInventarios
        vRegistroInventarios.JBSalir.addActionListener(this);
        
        //Botones Salir
        vSalir.JBCancelar.addActionListener(this);
        vSalir.JBSalir.addActionListener(this);
        
        //Botones NuevoInsumo
        vNewInsumo.JBGuardar.addActionListener(this);
        vNewInsumo.JBSalir.addActionListener(this);
        
        //Unidades de medida default        
        for (int i = 0; i < listaUnidadesMed.size(); i++) {
            vNewInsumo.JCBUnidadMed.addItem(listaUnidadesMed.get(i));            
        }        
        
        //Inicialización de las tablas
        configuraTablaRegistro(vRegistroInventarios.JTInsumos);
        configuraTablaInventarios(vInventarios.JTInventarios);
        }
    
    /**
     * 
     * @param String fecha = ""
     * @return SimpleDateFormat("dd/MM/yyyy HH:mm") + " HRS"
     */
    public String EstablecerFecha(String fecha){
            
            Date now = new Date(System.currentTimeMillis());
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            
            String fechaActual = date.format(now);
            
            return fechaActual + " HRS";            
            
    }
    
    /**
     * 
     * @param JTabletabla 
     */
    public void configuraTablaRegistro(JTable tabla){
        Vector<String> titulos = new Vector<String>();
        Vector<Vector<Object>> datos = new Vector<Vector<Object>>();
        
        titulos.add("ID");
        titulos.add("Nombre");
        titulos.add("Cantidad");
        titulos.add("Unidad de medida");
        titulos.add("Precio");
        titulos.add("Fecha");
        titulos.add("Transacción");
        
        for (Insumo ins : listaRegistroInsumos) {
            Vector<Object> row = new Vector<Object>();
            
            row.add(ins.getID());
            row.add(ins.getNombre());
            row.add(ins.getCantidad());
            row.add(ins.getUnidadMedida());
            row.add(ins.getPrecio());
            row.add(ins.getFecha());
            row.add(ins.getTransaccion());
            
            datos.add(row);
        }
        
        DefaultTableModel modelo = new DefaultTableModel(datos, titulos);
        
        tabla.setModel(modelo);                 
        
    }
    
    /**
     * 
     * @param JTable tabla 
     */
    public void configuraTablaInventarios(JTable tabla){
        Vector<String> titulos = new Vector<String>();
        Vector<Vector<Object>> datos = new Vector<Vector<Object>>();
        
        titulos.add("ID");
        titulos.add("Nombre");
        titulos.add("Cantidad");
        titulos.add("Precio unitario promedio");
        titulos.add("Unidad de medida");
        
        for (Insumo ins : listaInventarios) {
            Vector<Object> row = new Vector<Object>();
            
            row.add(ins.getID());
            row.add(ins.getNombre());
            row.add(ins.getCantidad());
            row.add(ins.getPrecio());
            row.add(ins.getUnidadMedida());
            
            datos.add(row);
        }
        
        DefaultTableModel modelo = new DefaultTableModel(datos, titulos);
        
        tabla.setModel(modelo);                 
        
    }
    
    public void actionPerformed (ActionEvent e){
        
        //Botones vMain
        if (vMain.getJBCompras() == e.getSource()){
            vCompras.setVisible(true);
        }
        
        if (vMain.getJBVentas() == e.getSource()){
            vProduccion.setVisible(true);
        }
        
        if (vMain.getJBRegistroInsumos() == e.getSource()){
            vRegistroInventarios.setVisible(true);
        }
        
        if (vMain.getJBInventarios() == e.getSource()) {
            vInventarios.setVisible(true);
        }
        
        if (vMain.getJBSalir() == e.getSource()) {
            vSalir.setVisible(true);
        }
        
        //Botones vCompras
        if (vCompras.getJBGuardar() == e.getSource()){            
            
            
            try{
                
                /*
                Se toman los valores {nombreInsumo, cantidad, precio, fecha}
                de los campos correspondientes en la interfaz grafica donde 
                escribirá y/o seleccionara el usuario. La transaccion será, en
                esta caso, siempre la constante "Compra".
                */
                String nombreInsumo = (String) vCompras.JCBInsumos.getSelectedItem();                
                BigDecimal cantidad = new BigDecimal(vCompras.JTFCantidad.getText());
                BigDecimal precio = new BigDecimal(vCompras.JTFPrecio.getText());
                String fecha = null;
                String fechaActual = EstablecerFecha(fecha);
                String transaccion = "Compra";
            
                //Excepción donde se verifica que el campo nombre no esté vacío
                if(nombreInsumo.isEmpty() || vCompras.JTFCantidad.getText().isEmpty() || vCompras.JTFPrecio.getText().isEmpty()){
                    throw new EmptyException("");
                }
                
                //Excepción donde se verifica que la cantidad y precio no sean menores o iguales a cero
                if (cantidad.doubleValue() <= 0 || precio.doubleValue() <= 0){
                    throw new CeroException("");
                }               
                
                /*
                En esta parte con los datos obtenidos previamente se busca en la
                lista de insumos elemento por elemento, para agregar este a el
                registro de compras y los inventarios.
                */
                for (Insumo insumo : listaInsumos) {                    
                    
                    boolean existe = false;
                    
                    /*
                    En esta parte ser verifica si en los inventarios existe ya 
                    el insumo, de ser así, solo se actualizan la cantidad y el 
                    precio promedio por unidad en la lista de inventarios.                    
                    */
                    for(Insumo nombre : listaInventarios){
                            
                        /*
                        En esta parte se verifica si el nombre del insumo que
                        está seleccionado por el usuario es igual al nombre del
                        elemento actual de la lista, de ser así se procede a
                        cambiar la cantidad y el precio unitario del insumo en 
                        los inventarios.
                        */
                        if (nombre.getNombre().equals(nombreInsumo)) {
                            //BigDecimal cantTotal = cantidad.add(nombre.getCantidad());
                            BigDecimal cantTotal = nombre.getCantidad().add(cantidad);
                            nombre.setCantidad(cantTotal);
                                
                            BigDecimal TWO = new BigDecimal(2);
                            BigDecimal precioProme = precio.divide(cantidad, 2, RoundingMode.CEILING);
                            BigDecimal precioProme2 = precioProme.add(nombre.getPrecio()).divide(TWO, 2, RoundingMode.CEILING);
                            //precioProme.setScale(2, BigDecimal.ROUND_UP);                                
                            nombre.setPrecio(precioProme2);
                            existe = true;
                            break;
                        }
                    
                    }                    
                    
                    /*
                    En esta parte se verifica si en ya existía el insumo en los
                    inventarios, de ser sasí, se añade al registro de insumos la
                    compra para lo cual se utilizan los datos solicitados
                    previamente {unidadMed, ID}.
                    */
                    if (existe) {                        
                        
                        int ID = insumo.getID();
                        String unidadMed = insumo.getUnidadMedida();
                        Insumo compraInsumos = new Insumo(ID,nombreInsumo,unidadMed,cantidad,precio,fechaActual, transaccion);
                        listaRegistroInsumos.add(compraInsumos); 
                        
                        break;
                    }
                    
                    
                        /*
                        Aquí se verifica si el insumo no está en los inventarios,
                        de ser así, se agrega la compra al registro y se añade 
                        por primera vez a los inventarios, para lo cual se utilizan
                        los datos solicidados previamente {ID y unidadMed}.
                        */
                        if (insumo.getNombre().equals(nombreInsumo)) {
                        
                            int ID = insumo.getID();
                            String unidadMed = insumo.getUnidadMedida();
                        
                            BigDecimal precioProm = precio.divide(cantidad, 2, RoundingMode.CEILING);
                            precioProm.setScale(2, BigDecimal.ROUND_UNNECESSARY);
                        
                            //CompraInsumos sirve agregar la compra al registro
                            Insumo compraInsumos = new Insumo(ID,nombreInsumo,unidadMed,cantidad,precio,fechaActual, transaccion);
                        
                            //CompraInventarios sirve para agregar el insumo a los inventarios
                            Insumo compraInventarios = new Insumo(ID,nombreInsumo,unidadMed,cantidad,precioProm,fechaActual, transaccion);
                        
                            listaRegistroInsumos.add(compraInsumos);                      
                        
                            //Si nunca antes se ha comprado el insumo se agrega por primera vez al inventario
                            if (existe == false) {
                                listaInventarios.add(compraInventarios);
                                System.out.println("Se agregó por primera vez el insumo al inventario");
                            }
                        
                        }                            
                             
                    }
                
                //Para cada elemento de listaInsumos (1)
//                for (int i = 0; i < listaInsumos.size(); i++) {
//                    
//                        //Si en los inventarios existe ya el insumo, solo se cambian sus valores
//                        boolean existe = false;
//                        for(Insumo nombre : listaInventarios){
//                            
//                            if (nombre.getNombre().equals(nombreInsumo)) {
//                                //BigDecimal cantTotal = cantidad.add(nombre.getCantidad());
//                                BigDecimal cantTotal = nombre.getCantidad().add(cantidad);
//                                nombre.setCantidad(cantTotal);
//                                
//                                BigDecimal TWO = new BigDecimal(2);
//                                BigDecimal precioProme = precio.divide(cantidad, 2, RoundingMode.CEILING);
//                                BigDecimal precioProme2 = precioProme.add(nombre.getPrecio()).divide(TWO, 2, RoundingMode.CEILING);
//                                //precioProme.setScale(2, BigDecimal.ROUND_UP);                                
//                                nombre.setPrecio(precioProme2);
//                                existe = true;
//                                break;
//                            }                            
//                            
//                            
//                        }
//                    
//                    //Si su nombre es igual a nombreInsumo
//                    if (listaInsumos.get(i).getNombre().equals(nombreInsumo)) {
//                        
//                        int ID = listaInsumos.get(i).getID();
//                        String unidadMed = listaInsumos.get(i).getUnidadMedida();
//                        
//                        BigDecimal precioProm = precio.divide(cantidad, 2, RoundingMode.CEILING);
//                        precioProm.setScale(2, BigDecimal.ROUND_UNNECESSARY);
//                        
//                        //CompraInsumos sirve para el registro de insumos comprados
//                        Insumo compraInsumos = new Insumo(ID,nombreInsumo,unidadMed,cantidad,precio,fechaActual, transaccion);
//                        
//                        //CompraInventarios sirve para agregar a los inventarios
//                        Insumo compraInventarios = new Insumo(ID,nombreInsumo,unidadMed,cantidad,precioProm,fechaActual, transaccion);
//                        
//                        listaRegistroInsumos.add(compraInsumos);             
//                        
//                        
//                        //Si nunca antes se ha comprado el insumo se agrega por primera vez al inventario
//                        if (existe == false) {
//                            listaInventarios.add(compraInventarios);
//                            System.out.println("No existe el insumo en el inventario");
//                            break; 
//                        }
//                       break;    
//                    }
//                    
//                    
//                }
                
                

                JOptionPane.showMessageDialog(null, "¡Guardado satisfactoriamente!");
                configuraTablaRegistro(vRegistroInventarios.JTInsumos);
                configuraTablaInventarios(vInventarios.JTInventarios);
            
            }
            
            catch(EmptyException e1){
                JOptionPane.showMessageDialog(null, "Campos vacíos");
            }
            
            catch(NumberFormatException e2){
                JOptionPane.showMessageDialog(null, "Inserte un valor numérico");
            }
            
            catch(NullPointerException e3){
                JOptionPane.showMessageDialog(null, "No ingresó un insumo");
            }
            
            catch(CeroException e4){
                JOptionPane.showMessageDialog(null, "La cantidad no puede ser menor o igual a cero");
            }
        }
        
        if (vCompras.getJBNuevoInsumo() == e.getSource()){
            vNewInsumo.setVisible(true);            
        }
        
        if (vCompras.getJBSalir() == e.getSource()){
            vCompras.setVisible(false);
        }        
        
        
        //Botones vProduccion           
        if (vProduccion.getJBSalir() == e.getSource()) {
            vProduccion.setVisible(false);
        }        
        
        //Botones vRegistroInventarios
        if (vRegistroInventarios.getJBSalir() == e.getSource()){
            vRegistroInventarios.setVisible(false);
        }
        
        //Botones vInventarios        
        if (vInventarios.getJBSalir() == e.getSource()) {
            vInventarios.setVisible(false);
        }
        
        //Botones vSalir
        if (vSalir.getJBCancelar() == e.getSource()) {
            vSalir.setVisible(false);
        }
        
        if (vSalir.getJBSalir() == e.getSource()) {
            System.exit(0);
        }
        
        //Botones vNewInsumo
        if (vNewInsumo.getJBGuardar() == e.getSource()){           
            
            try{
            String s = (String) vNewInsumo.JCBUnidadMed.getSelectedItem();
            int ID = listaInsumos.size() + 1; 
            vNewInsumo.JTFID.setText("" + ID);
            String nombre = vNewInsumo.getJTFNombre().getText();
            String unidadMed = s;
            BigDecimal price = new BigDecimal(0);
            BigDecimal cant = new BigDecimal(0);
            
                if (nombre.isEmpty()) {
                    throw new EmptyException("");
                }
                
                for (int i = 0; i < listaInsumos.size(); i++) {
                    
                    if (listaInsumos.get(i).getNombre().equalsIgnoreCase(nombre)) {                        
                        throw new AlreadyUsedException("");                        
                    }
                    
                }            
            
            Insumo ins = new Insumo(ID,nombre,unidadMed,cant,price,"", "");
            
            listaInsumos.add(ins);
            vCompras.JCBInsumos.addItem(ins.getNombre());
            JOptionPane.showMessageDialog(null, "¡Guardado satisfactoriamente!");
            
            }
            
            catch(EmptyException e1){
                JOptionPane.showMessageDialog(null,"Campos vacíos");
            }
            
            catch(AlreadyUsedException e2){
                JOptionPane.showMessageDialog(null,"El insumo ya existe");
            }    
            
        }        
        
        
        if (vNewInsumo.getJBSalir() == e.getSource()){
            vNewInsumo.setVisible(false);
        }
        
        
        
    }

    
    
    
}
