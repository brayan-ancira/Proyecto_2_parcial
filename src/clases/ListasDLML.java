/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.Serializable;

/**
 *
 * @author Mauro S S
 */
public class ListasDLML implements Serializable
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
        if (n == null)
        {
            System.out.println("No se puede insertar el nodo en la lista porque nodo es NULL");
        } else
        {
            if (r == null)
            {
                r = n;
                System.out.println("Se inserto el nodo en el primer espacio de la lista");
            } else
            {
                if (n.getEt().compareTo(r.getEt()) < 0)
                { 
                    n.setSig(r);
                    r.setAnt(n);
                    r = n;
                    System.out.println("Se agrego antes de r: "+n.getEt());
                } else
                {
                    Nodo aux = r;
                    boolean b = true;
                    while (aux.getSig() != null && b)
                    {
                        if (n.getEt().compareTo(aux.getSig().getEt()) < 0)
                        {
                            n.setSig(aux.getSig());
                            n.setAnt(aux);
                            aux.getSig().setAnt(n);
                            aux.setSig(n);
                            b = false;
                            System.out.println("Se agrego "+n.getEt()+"entre dos nodos");
                        } else
                        {
                            aux = aux.getSig();
                        }
                    }
                    
                    if (b)
                    {
                        n.setAnt(aux);
                        aux.setSig(n);
                        System.out.println("Se agrego al final: "+n.getEt());
                    }
                }
            }

        }
    }

    public Nodo elimina(String et)
    {
        Nodo n = null;
        if (r == null)
        {
            System.out.println("La R de la lista esta vacia");
        } else
        {
            if (r.getEt().compareTo(et) > 0)
            {
                System.out.println("El dato a buscar no existe porque es menor a el dato mas pequeño");
            } else
            {
                if (r.getEt().equals(et))
                {
                    n = r;
                    r = n.getSig();
                    if (r != null)
                    {
                        r.setAnt(null);
                    }
                    n.setSig(null);
                    
                    System.out.println("El dato eliminado fue la cabeza de la lista");
                } else
                {
                    Nodo aux = r;
                    boolean b = true;
                    while (aux.getSig() != null && b)
                    {
                        
                        if (aux.getSig().getEt().equals(et))
                        {
                            n = aux.getSig();
                            if (n.getSig() != null)
                            {
                                aux.getSig().getSig().setAnt(aux);
                                System.out.println("El dato a eliminar estaba al final de la lista");
                            }
                            aux.setSig(n.getSig());
                            n.setSig(null);
                            n.setAnt(null);
                            b = false;
                            
                            System.out.println("El dato fue encontrado dentro de la lista");
                        } else
                        {
                            if (aux.getSig().getEt().compareTo(et) > 0)
                            {
                                System.out.println("Se busco en toda la lista y no se encontro");
                                b = false;
                            } else
                            {
                                aux = aux.getSig();
                                System.out.println("Sigo buscando");
                            }
                        }
                    }
                    
                    if (b==false &&n!=null)
                    {
                        System.out.println("Se encontro el dato "+n.getEt());
                    }
                }
            }
        }
        
        return n;
    }

    public String desp()
    {
        String s = "";
        Nodo aux = r;
        Nodo ant = null;
        while (aux != null)
        {
            s += aux.getObj() + "\t";
            ant = aux;
            aux = aux.getSig();
        }
        s += "\n";
        while (ant != null)
        {
            s += ant.getObj() + "\t";
            ant = ant.getAnt();
        }
        return s;
    }
}
