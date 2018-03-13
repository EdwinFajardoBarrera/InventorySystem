/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Edwin Fajardo
 */
public class Producto {
    
    private int ID;
    private String nombre;
    private ArrayList<Insumo> insumos;

    //Constructor
    public Producto(int ID, String nombre, ArrayList<Insumo> insumos) {
        this.ID = ID;
        this.nombre = nombre;
        this.insumos = insumos;
    }
    
    //Getters and setters
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

    public ArrayList<Insumo> getInsumos() {
        return insumos;
    }

    public void setInsumos(ArrayList<Insumo> insumos) {
        this.insumos = insumos;
    }
    
    
}
