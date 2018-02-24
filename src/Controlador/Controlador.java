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
    private final NuevoInsumoView vNewInsumo;
    private final InventariosView vInventarios;
    private final Insumos insumos;
    private ArrayList<Insumos> listaInsumos;
    private ArrayList<String> listaUnidadesMed;
    private ArrayList<Insumos> listaRegistroInsumos;
    private ArrayList<Insumos> listaInventarios; 
    
    //Constructor
    public Controlador(MainView vMain, ComprasView vCompras, ProduccionView vProduccion, RegistroInventarioView vRegistroInventarios, NuevoInsumoView vNewInsumo, InventariosView vInventarios, Insumos insumos, ArrayList<Insumos> listaInsumos, ArrayList<String> listaUnidadesMed, ArrayList<Insumos> listaRegistroInsumos, ArrayList<Insumos> listaInventarios) {
        this.vMain = vMain;
        this.vCompras = vCompras;
        this.vProduccion = vProduccion;
        this.vRegistroInventarios = vRegistroInventarios;
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
        vRegistroInventarios.setVisible(false);
        vNewInsumo.setVisible(false);
        vInventarios.setVisible(false);
        
        //Titulos de ventanas
        vMain.setTitle("Bowisa");
        vCompras.setTitle("Compras");
        vProduccion.setTitle("Producción");
        vRegistroInventarios.setTitle("Registro de insumos");
        vNewInsumo.setTitle("Nuevo insumo");
        vInventarios.setTitle("Inventarios");
        
        //Locación de las ventanas
        vMain.setLocationRelativeTo(null);
        vCompras.setLocationRelativeTo(null);
        vProduccion.setLocationRelativeTo(null);
        vRegistroInventarios.setLocationRelativeTo(null);
        vNewInsumo.setLocationRelativeTo(null);
        vInventarios.setLocationRelativeTo(null);
        
        //Botones Main
        vMain.JBCompras.addActionListener(this);
        vMain.JBProduccion.addActionListener(this);
        vMain.JBRegistroInsumos.addActionListener(this);
        vMain.JBInventarios.addActionListener(this);
        
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
        
        //Botones NuevoInsumo
        vNewInsumo.JBGuardar.addActionListener(this);
        vNewInsumo.JBSalir.addActionListener(this);
        
        //Unidades de medida default        
        for (int i = 0; i < listaUnidadesMed.size(); i++) {
            vNewInsumo.JCBUnidadMed.addItem(listaUnidadesMed.get(i));            
        }        
        
        //Inicialización de la tabla del la ventana "Inventario
        configuraTablaRegistro(vRegistroInventarios.JTInsumos);
        configuraTablaRegistro(vInventarios.JTInventarios);
        
        }
    
    public String EstablecerFecha(String fecha){
            
            Date now = new Date(System.currentTimeMillis());
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            
            String fechaActual = date.format(now);
            
            return fechaActual + " HRS";            
            
        }
    
    
    public void configuraTablaRegistro(JTable tabla){
        Vector<String> titulos = new Vector<String>();
        Vector<Vector<Object>> datos = new Vector<Vector<Object>>();
        
        titulos.add("ID");
        titulos.add("Nombre");
        titulos.add("Cantidad");
        titulos.add("Unidad de medida");
        titulos.add("Precio");
        titulos.add("Fecha");
        
        for (Insumos ins : listaRegistroInsumos) {
            Vector<Object> row = new Vector<Object>();
            
            row.add(ins.getID());
            row.add(ins.getNombre());
            row.add(ins.getCantidad());
            row.add(ins.getUnidadMedida());
            row.add(ins.getPrecio());
            row.add(ins.getFecha());
            
            datos.add(row);
        }
        
        DefaultTableModel modelo = new DefaultTableModel(datos, titulos);
        
        tabla.setModel(modelo);                 
        
    }
    
    public void configuraTablaInventarios(JTable tabla){
        Vector<String> titulos = new Vector<String>();
        Vector<Vector<Object>> datos = new Vector<Vector<Object>>();
        
        titulos.add("ID");
        titulos.add("Nombre");
        titulos.add("Cantidad");
        titulos.add("Precio promedio");
        
        for (Insumos ins : listaInventarios) {
            Vector<Object> row = new Vector<Object>();
            
            row.add(ins.getID());
            row.add(ins.getNombre());
            row.add(ins.getCantidad());
            row.add(ins.getPrecio());
            
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
        
        //Botones vCompras
        if (vCompras.getJBGuardar() == e.getSource()){            
            
            
            try{
                
            String nombreInsumo = (String) vCompras.JCBInsumos.getSelectedItem();            
            int cantidad = Integer.parseInt(vCompras.JTFCantidad.getText());
            int precio = Integer.parseInt(vCompras.JTFPrecio.getText());
            String fecha = null;
            String fechaActual = EstablecerFecha(fecha);
            
                if(nombreInsumo.isEmpty() || vCompras.JTFCantidad.getText().isEmpty() || vCompras.JTFPrecio.getText().isEmpty()){
                    throw new EmptyException("");
                }
                
                if (cantidad <= 0 || precio <= 0){
                    throw new CeroException("");
                }
                
                for (int i = 0; i < listaInsumos.size(); i++) {
                    
                    if (listaInsumos.get(i).getNombre().equals(nombreInsumo)) {
                        
                        int ID = listaInsumos.get(i).getID();
                        String unidadMed = listaInsumos.get(i).getUnidadMedida();
                        
                        
                        
                        int precioProm = precio / cantidad;
                        
                        Insumos compra = new Insumos(ID,nombreInsumo,unidadMed,cantidad,precio,fechaActual);
                        
                        Insumos compra2 = new Insumos(ID,nombreInsumo,unidadMed,cantidad,precioProm,fechaActual);
                        
                        listaRegistroInsumos.add(compra);
                        //listaInventarios.add(compra2);                       

                        for (int j = 0; j < listaInventarios.size(); j++) {                            
                            
                            if (listaInventarios.get(j).getNombre().equalsIgnoreCase(nombreInsumo)) {                                
                                listaInventarios.get(j).setCantidad(cantidad + listaInventarios.get(j).getCantidad());
                                listaInventarios.get(j).setPrecio((precio + listaInventarios.get(j).getPrecio()) / listaInventarios.get(j).getCantidad() );
                            }
                        }
                        
                        if (listaInventarios.isEmpty()) {
                            listaInventarios.add(compra2);
                        }
                        
//                        int cantidadTotal = cantidad + listaInsumos.get(i).getCantidad();
//                        int precioSum = (int) (precio + listaInsumos.get(i).getPrecio());
//                        int precioProm = precioSum / cantidadTotal;
                        
//                        for (int j = 0; j < listaInventarios.size(); j++) {
//                            
//                            if (listaInventarios.get(i).getNombre().equals(nombreInsumo)) {
//                                listaInventarios.get(i).setCantidad(cantidad + listaInsumos.get(i).getCantidad());
//                                listaInventarios.get(i).setPrecio(precio + listaInsumos.get(i).getPrecio());
//                            }
//                            
//                        }
                        
                        //Insumos compra2 = new Insumos(ID,nombreInsumo,unidadMed,cantidadTotal,precioProm,fechaActual);
                        //listaInventarios.add(compra);
                           
                    }
                    
                }
                
//                for (int i = 0; i < listaInsumos.size(); i++) {
//                    
//                    if (listaInsumos.get(i).getNombre().equals(nombreInsumo)) {
//                        
//                        int ID = listaInsumos.get(i).getID();
//                        String unidadMed = listaInsumos.get(i).getUnidadMedida();
//                        int cantidadTotal = Integer.parseInt(vCompras.JTFCantidad.getText() + listaInsumos.get(i).getCantidad());
//                        int precioSum = Integer.parseInt(vCompras.JTFPrecio.getText() + listaInsumos.get(i).getPrecio());
//                        int precioProm = precioSum / cantidadTotal;
//                        
//                        Insumos compra2 = new Insumos(ID,nombreInsumo,unidadMed,cantidadTotal,precioProm,fechaActual);
//                        listaInventarios.add(compra2);
//                        
//                    }
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
        
        //Botones vNewInsumo
        if (vNewInsumo.getJBGuardar() == e.getSource()){           
            
            try{
            String s = (String) vNewInsumo.JCBUnidadMed.getSelectedItem();
            int ID = listaInsumos.size() + 1; 
            vNewInsumo.JTFID.setText("" + ID);
            String nombre = vNewInsumo.getJTFNombre().getText();
            String unidadMed = s;
            
                if (nombre.isEmpty()) {
                    throw new EmptyException("");
                }
                
                for (int i = 0; i < listaInsumos.size(); i++) {
                    
                    if (listaInsumos.get(i).getNombre().equalsIgnoreCase(nombre)) {                        
                        throw new AlreadyUsedException("");                        
                    }
                    
                }            
            
            Insumos ins = new Insumos(ID,nombre,unidadMed,0,0,"");
            
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
