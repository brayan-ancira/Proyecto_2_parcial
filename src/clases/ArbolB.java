/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class ArbolB implements Serializable
{

    private NodoArbol r = null;

    public NodoArbol getR()
    {
        return r;
    }

    public void setR(NodoArbol r)
    {
        this.r = r;
    }

    public NodoArbol inserta(NodoArbol r, NodoArbol n)
    {
        if (n != null)
        {
            if (r == null)
            {
                return n;
            } else
            {
                if (n.getEtiqueta().compareTo(r.getEtiqueta()) < 0)
                {
                    r.setIzq(inserta(r.getIzq(), n));
                } else
                {
                    r.setDer(inserta(r.getDer(), n));
                }

            }

        }
        return r;
    }

    public void enOrden(NodoArbol r)
    {
        if (r != null)
        {
            enOrden(r.getIzq());
            System.out.print(r.getEtiqueta() + " ");
            enOrden(r.getDer());
        }
    }

    public void enPreOrden(NodoArbol r)
    {
        if (r != null)
        {
            System.out.print(r.getEtiqueta() + " ");
            enPreOrden(r.getIzq());
            enPreOrden(r.getDer());
        }
    }

    public void enPosOrden(NodoArbol r)
    {
        if (r != null)
        {

            enPosOrden(r.getIzq());
            enPosOrden(r.getDer());
            System.out.print(r.getEtiqueta() + " ");
        }
    }

    public void elimina(NodoArbol arr[], String s, NodoArbol r)
    {
        if (r == null)
        {
            arr[0] = null;
            arr[1] = null;
        } else
        {
            if (r.getEtiqueta().equals(s))
            {
                arr[0] = r;
                if (r.getIzq() == null && r.getDer() == null)
                {
                    arr[1] = null;
                } else
                {
                    if (!(r.getIzq() != null && r.getDer() != null))
                    {
                        if (r.getIzq() != null)
                        {
                            arr[1] = r.getIzq();
                        } else
                        {
                            arr[1] = r.getDer();
                        }
                    } else
                    {
                        if (r.getDer().getIzq() == null)
                        {
                            r.getDer().setIzq(r.getIzq());
                            arr[1] = r.getDer();
                        } else
                        {
                            NodoArbol se = buscaSE(r.getDer());
                            arr[1] = se.getIzq();
                            se.setIzq(se.getIzq().getDer());
                            arr[1].setIzq(r.getIzq());
                            arr[1].setDer(r.getDer());
                        }
                    }
                }
                arr[0].setDer(null);
                arr[0].setIzq(null);
            } else
            {
                if (r.getEtiqueta().compareTo(s) > 0)
                {
                    elimina(arr, s, r.getIzq());
                    r.setIzq(arr[1]);
                } else
                {
                    elimina(arr, s, r.getDer());
                    r.setDer(arr[1]);
                }
                arr[1] = r;
            }
        }
    }

    public NodoArbol buscaSE(NodoArbol r)
    {
        if (r.getIzq().getIzq() != null)
        {
            return buscaSE(r.getIzq());
        }
        return r;
    }
}
