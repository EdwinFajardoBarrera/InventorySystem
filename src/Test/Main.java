/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Controlador.*;
import Modelo.*;
import Vista.*;
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
        NuevoInsumoView vNewInsumo = new NuevoInsumoView();
        InventariosView vInventarios = new InventariosView();
        Insumos insumo = new Insumos(0,"","",0,0,"");
        ArrayList<Insumos> listaInsumos = new ArrayList<Insumos>();
        ArrayList<String> listaUnidades = new ArrayList<String>();
        ArrayList<Insumos> listaRegistroInventarios = new ArrayList<Insumos>();
        ArrayList<Insumos> listaInventarios = new ArrayList<Insumos>();
        listaUnidades.add("Litros");
        listaUnidades.add("Kilos");
        listaUnidades.add("Gramos");
        listaUnidades.add("Piezas");
        listaUnidades.add("Cajas");   
        
        Controlador ctrl = new Controlador(vMain, vCompras, vProduccion, vInventario, vNewInsumo, vInventarios, insumo, listaInsumos, listaUnidades,listaRegistroInventarios, listaInventarios);
        ctrl.iniciar();
        
        
        
    }
    
}
