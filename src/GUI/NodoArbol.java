/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class NodoArbol implements Serializable
{

    private String etiqueta;
    private Object obj;
    private NodoArbol izq;
    private NodoArbol der;
    Nodo nodo;

    public NodoArbol()
    {
    }

    public NodoArbol(String etiqueta, Object obj)
    {
        this.etiqueta = etiqueta;
        this.obj = obj;
    }

    public String getEtiqueta()
    {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta)
    {
        this.etiqueta = etiqueta;
    }

    public Object getObj()
    {
        return obj;
    }

    public void setObj(Object obj)
    {
        this.obj = obj;
    }

    public NodoArbol getIzq()
    {
        return izq;
    }

    public void setIzq(NodoArbol izq)
    {
        this.izq = izq;
    }

    public NodoArbol getDer()
    {
        return der;
    }

    public void setDer(NodoArbol der)
    {
        this.der = der;
    }

    @Override
    public String toString()
    {
        return "NodoArbol{" + "etiqueta=" + etiqueta + ", obj=" + obj + ", izq=" + izq + ", der=" + der + '}';
    }

    public Nodo getNodo()
    {
        return nodo;
    }

    public void setNodo(Nodo nodo)
    {
        this.nodo = nodo;
    }

}
