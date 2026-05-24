/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author artea
 */
public class Auto implements Serializable
{

    private String placas;
    private String modelo;
    private String anio;
    private Date fechaIngreso;

    public Auto(String placas, String modelo, String anio, Date fechaIngreso)
    {
        this.placas = placas;
        this.modelo = modelo;
        this.anio = anio;
        this.fechaIngreso = fechaIngreso;
    }

    public String getPlacas()
    {
        return placas;
    }

    public void setPlacas(String placas)
    {
        this.placas = placas;
    }

    public String getModelo()
    {
        return modelo;
    }

    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    public Date getFechaIngreso()
    {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso)
    {
        this.fechaIngreso = fechaIngreso;
    }

    public String getAnio()
    {
        return anio;
    }

    public void setAnio(String anio)
    {
        this.anio = anio;
    }

}
