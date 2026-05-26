/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import clases.ListasDLML;
import java.io.Serializable;

/**
 *
 * @author Mauro S S
 */
public class MultiLista implements Serializable
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

    public Nodo inserta(Nodo n, String c[], int nivel, Nodo r)
    {
        if (c.length - 1 == nivel)
        {
            ListasDLML l = new ListasDLML();
            l.setR(r);
            l.inserta(n);
            System.out.println("inserto:" + n.getEt());
            return l.getR();
        } else
        {
            Nodo aux = busca(r, c[nivel]);
            if (aux != null)
            {
                System.out.println("encontro: " + aux.getEt());
                aux.setAbj(inserta(n, c, nivel + 1, aux.getAbj()));
                if (n.getArb() == null)
                {
                    n.setArb(aux);
                }
            }
            return r;
        }
    }

    public Nodo busca(Nodo r, String et)
    {
        if (r != null)
        {
            Nodo aux = r;
            while (aux != null)
            {
                if (aux.getEt().equals(et))
                {
                    return aux;
                }
                aux = aux.getSig();
            }
        }
        return null;
    }

    public void desp(Nodo r, String n)
    {
        if (r != null)
        {
            Nodo aux = r.getSig();
            do
            {

                if (aux.getArb() == null)
                {
                    System.out.println(n + aux.getEt() + "\n");
                } else
                {
                    System.out.println(n + aux.getEt() + "\t" + aux.getArb() + "\n");
                }
                desp(aux.getAbj(), n + "\t");
                aux = aux.getSig();
            } while (aux != r.getSig());
        }
    }

    public Nodo[] elimina(String c[], int nivel, Nodo r)
    {
        Nodo obj[] = new Nodo[2];

        if (c.length - 1 == nivel)
        {
            ListasDLML l = new ListasDLML();
            l.setR(r);
            obj[0] = l.elimina(c[nivel]);
            if (obj[0] != null)
            {
                obj[0].setArb(null);
            }
            obj[1] = l.getR();

            return obj;
        } else
        {
            Nodo aux = busca(r, c[nivel]);
            if (aux != null)

            {
                System.out.println("encontro: " + aux.getEt());
                obj = elimina(c, nivel + 1, aux.getAbj());
                aux.setAbj(obj[1]);
            }
            obj[1] = r;
            return obj;
        }
    }
}
