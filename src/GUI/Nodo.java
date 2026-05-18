/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.io.Serializable;

/**
 *
 * @author vllnm
 */
public class Nodo <T> implements Serializable 
{
    private T obj; 
    private String etiqueta;
    private Nodo siguiente;
    private Nodo anterior;
    private Nodo abajo;
    private Nodo arriba;

    public Nodo(T obj, String etiqueta)
    {
        this.obj = obj;
        this.etiqueta = etiqueta;
    }

    /**
     * @return the obj
     */
    public T getObj()
    {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(T obj)
    {
        this.obj = obj;
    }

    /**
     * @return the etiqueta
     */
    public String getEtiqueta()
    {
        return etiqueta;
    }

    /**
     * @param etiqueta the etiqueta to set
     */
    public void setEtiqueta(String etiqueta)
    {
        this.etiqueta = etiqueta;
    }

    /**
     * @return the siguiente
     */
    public Nodo getSiguiente()
    {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(Nodo siguiente)
    {
        this.siguiente = siguiente;
    }

    @Override
    public String toString()
    {
        //
        return "Nodo{" + "obj=" + getObj().toString() + ", etiqueta=" + getEtiqueta() + '}';
    }

    /**
     * @return the anterior
     */
    public Nodo getAnterior()
    {
        return anterior;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnterior(Nodo anterior)
    {
        this.anterior = anterior;
    }

    /**
     * @return the abajo
     */
    public Nodo getAbajo()
    {
        return abajo;
    }

    /**
     * @param abajo the abajo to set
     */
    public void setAbajo(Nodo abajo)
    {
        this.abajo = abajo;
    }

    /**
     * @return the arriba
     */
    public Nodo getArriba()
    {
        return arriba;
    }

    /**
     * @param arriba the arriba to set
     */
    public void setArriba(Nodo arriba)
    {
        this.arriba = arriba;
    }
    
    
}
