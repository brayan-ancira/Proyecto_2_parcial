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
public class ListaDoblementeLigadaCircular implements Serializable 
{
    private Nodo r;
 
    /**
     * @return the r
     */
    public Nodo getR()
    {
        return r;
    }
 
    /**
     * @param r the r to set
     */
    public void setR(Nodo r)
    {
        this.r = r;
    }
 
    public void inserta(Nodo n)
    {
        if (n != null)
        {
            if (r == null)
            {
                r = n;
                r.setSiguiente(n);
                r.setAnterior(n);
            } else
            {
                if (n.getEtiqueta().compareTo(r.getSiguiente().getEtiqueta()) < 0
                        || n.getEtiqueta().compareTo(r.getEtiqueta()) > 0)
                {
                    n.setSiguiente(r.getSiguiente());
                    n.setAnterior(r);
                    r.getSiguiente().setAnterior(n);
                    r.setSiguiente(n);
                    if (n.getEtiqueta().compareTo(r.getEtiqueta()) > 0)
                    {
                        r = n;
                    }
                } else
                {
                    Nodo aux = r.getSiguiente();
                    while (true)
                    {
                        if (aux.getSiguiente().getEtiqueta().compareTo(n.getEtiqueta()) > 0)
                        {
                            n.setSiguiente(aux.getSiguiente());
                            n.setAnterior(aux);
                            aux.getSiguiente().setAnterior(n);
                            aux.setSiguiente(n);
                            break;
                        } else
                        {
                            aux = aux.getSiguiente();
                        }
                    }
                }
            }
        } else
        {
            System.out.println("no se puede insertar");
        }
    }
 
    public Nodo elimina(String et)
    {
        Nodo n = null;
        if (r == null)
        {
            System.out.println("lista vacia");
        } else
        {
            if (et.compareTo(r.getSiguiente().getEtiqueta()) < 0
                    || et.compareTo(r.getEtiqueta()) > 0)
            {
                System.out.println("el dato no se encuentra en la lista");
            } else
            {
                if (et.equals(r.getSiguiente().getEtiqueta()))
                {
                    n = r.getSiguiente();
                    r.setSiguiente(n.getSiguiente());
                    r.getSiguiente().setAnterior(n.getAnterior());
                    if (r == n)
                    {
                        r = null;
                    }
                } else
                {
                    Nodo aux = r.getSiguiente();
                    while (true)
                    {
                        if (aux.getSiguiente().getEtiqueta().equals(et))
                        {
                            n = aux.getSiguiente();
                            aux.getSiguiente().setAnterior(aux);
                            aux.setSiguiente(n.getSiguiente());
                            if (n == r)
                            {
                                r = aux;
                            }
                            break;
                        } else
                        {
                            if (aux.getSiguiente().getEtiqueta().compareTo(et) > 0)
                            {
                                break;
                            } else
                            {
                                aux = aux.getSiguiente();
                            }
                        }
                    }
                }
            }
        }
        if (n != null)
        {
            n.setSiguiente(null);
            n.setAnterior(null);
        }
        return n;
 
    }
 
    public String desp()
    {
        String s = "";
        if (r != null)
        {
            Nodo aux = r.getSiguiente();
            do
            {
                s += aux.getEtiqueta() + "\t";
                aux = aux.getSiguiente();
            } while (aux != r.getSiguiente());
        }
        return s;
    }
}
