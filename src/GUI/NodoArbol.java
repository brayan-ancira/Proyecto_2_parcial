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
public class NodoArbol implements Serializable
{
    private Object obj;
    private NodoArbol izq;
    private NodoArbol der;
    private String etiqueta;

    public NodoArbol(Object obj, String etiqueta)
    {
        this.obj = obj;
        this.etiqueta = etiqueta;
    }

    /**
     * @return the obj
     */
    public Object getObj()
    {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(Object obj)
    {
        this.obj = obj;
    }

    /**
     * @return the izq
     */
    public NodoArbol getIzq()
    {
        return izq;
    }

    /**
     * @param izq the izq to set
     */
    public void setIzq(NodoArbol izq)
    {
        this.izq = izq;
    }

    /**
     * @return the der
     */
    public NodoArbol getDer()
    {
        return der;
    }

    /**
     * @param der the der to set
     */
    public void setDer(NodoArbol der)
    {
        this.der = der;
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
    
    public void desp()
    {
        
        if (izq==null)
        {
            izq.setEtiqueta("No hay izquierda");
        }
        
        
        if (der==null)
        {
            der.setEtiqueta("No hay derecha");
        }
        
        
        System.out.println("objeto: "+obj.toString()
                +"\nizq: "+izq.getEtiqueta()
                +"\nder: "+der.getEtiqueta()
                +"\netiqueta: "+etiqueta);
    }
    

    public void inOrden(NodoArbol r)
    {
        if (r!=null)
        {
            //Se mueve hasta la izquierda mas profunda
            //despues regresa a la raiz y imprime
            //despues se va a la derecha
            inOrden(r.getIzq()); 
            System.out.println(r.getEtiqueta()+" ");
            inOrden(r.getDer());
        }
    }
    
    public void preOrden(NodoArbol r)
    {
        if (r!=null)
        {
            //Imprime la raiz primero
            // se mueve a la izquierda y la imprime
            //se mueve a la derecha y la imprime
            System.out.println(r.getEtiqueta()+" ");
            preOrden(r.getIzq());
            preOrden(r.getDer());
        }
    }
    
    public void postOrden(NodoArbol r)
    {
        if (r!=null)
        {
            //Se va a la izquieda
            //Luego a la derecha
            //hasta llegar al fondo del patron izq der imprime
            postOrden(r.getIzq());
            postOrden(r.getDer());
            System.out.println(r.getEtiqueta()+" ");
        }
    }
    
}
