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
    private Date anio;
    private Date fechaIngreso;

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

    public Date getAnio()
    {
        return anio;
    }

    public void setAnio(Date anio)
    {
        this.anio = anio;
    }

}
