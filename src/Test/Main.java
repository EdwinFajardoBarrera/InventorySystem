/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Controlador.*;
import Modelo.*;
import Vista.*;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author Edwin Fajardo
 */
public class Main {
    
    public static void main(String[] args) {
        
        MainView vMain = new MainView();
        ComprasView vCompras = new ComprasView();
        ProduccionView vProduccion = new ProduccionView();
        RegistroInventarioView vInventario = new RegistroInventarioView();
        SalirView vSalir = new SalirView();
        NuevoInsumoView vNewInsumo = new NuevoInsumoView();
        InventariosView vInventarios = new InventariosView();
        BigDecimal num = new BigDecimal(0);
        BigDecimal cant = new BigDecimal(0);
        Insumo insumo = new Insumo(0,"","",cant,num,"","");
        ArrayList<Insumo> listaInsumos = new ArrayList<Insumo>();
        ArrayList<String> listaUnidades = new ArrayList<String>();
        ArrayList<Insumo> listaRegistroInventarios = new ArrayList<Insumo>();
        ArrayList<Insumo> listaInventarios = new ArrayList<Insumo>();
        listaUnidades.add("Litros");
        listaUnidades.add("Kilos");
        listaUnidades.add("Gramos");
        listaUnidades.add("Piezas");
        listaUnidades.add("Cajas");   
        
        Controlador ctrl = new Controlador(vMain, vCompras, vProduccion, vInventario, vSalir, vNewInsumo, vInventarios, insumo, listaInsumos, listaUnidades,listaRegistroInventarios, listaInventarios);
        ctrl.iniciar();
        
        
        
    }
    
}
