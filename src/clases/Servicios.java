/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.Serializable;

/**
 *
 * @author artea
 */
public class Servicios implements Serializable
{

    private String nom;
    private int precio;
    private String capacidad;

    public Servicios(String nom, int precio, String capacidad)
    {
        this.nom = nom;
        this.precio = precio;
        this.capacidad = capacidad;
    }
    
    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public int getPrecio()
    {
        return precio;
    }

    public void setPrecio(int precio)
    {
        this.precio = precio;
    }

    public String getCapacidad()
    {
        return capacidad;
    }

    public void setCapacidad(String capacidad)
    {
        this.capacidad = capacidad;
    }

}
