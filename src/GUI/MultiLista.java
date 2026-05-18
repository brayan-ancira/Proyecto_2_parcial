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
        if (c.length-1==nivel)
        {
            ListaDoblementeLigadaCircular l = new ListaDoblementeLigadaCircular();
            l.setR(r);
            l.inserta(n);
            System.out.println("inserto:"+n.getEtiqueta());
            return l.getR();
        } else
        {
            Nodo aux = busca(r,c[nivel]);
            if (aux !=null)
            {
                System.out.println("encontro: "+ aux.getEtiqueta());
                aux.setAbajo(inserta(n, c, nivel+1, aux.getAbajo()));
                
                if (n.getArriba()==null)
                {
                    n.setArriba(aux);
                }
            }
            return r;
        }
    }
    
    public Nodo busca(Nodo r, String et)
    {
        if (r!=null)
        {
            Nodo aux = r.getSiguiente();
            do
            {
                if (aux.getEtiqueta().equals(et))
                {
                    return aux;
                }
                aux=aux.getSiguiente();
            } while (aux != r.getSiguiente());
        } 
        return null;
    }
    
    public Nodo[] elimina(String c[], int nivel, Nodo r)
    {
        Nodo obj[]= new Nodo[2];
        
        if (c.length-1==nivel)
        {
            ListaDoblementeLigadaCircular l = new ListaDoblementeLigadaCircular();
            l.setR(r);
            obj[0]=l.elimina(c[nivel]);
            obj[0].setArriba(null);
            obj[1]=l.getR();
            return obj;
        } else
        {
            Nodo aux = busca(r,c[nivel]);
            if (aux !=null)
            {
                obj=elimina(c,nivel+1,aux.getAbajo());
                System.out.println("encontro: "+ aux.getEtiqueta());
                aux.setAbajo(obj[1]);
            }
            
            obj[1]=r;
            return obj;
        }
    }
    
    
    public void desp(Nodo r, String n)
    {
        if (r!= null)
        {
            Nodo aux = r.getSiguiente();
            do
            {
                
                if (aux.getArriba()==null)
                {
                    System.out.println(n+aux.getEtiqueta()+"\n");
                }else
                {
                    System.out.println(n+aux.getEtiqueta()+"\tle pertenece a: "+aux.getArriba().getEtiqueta()+"\n");
                }
                desp(aux.getAbajo(), n+"\t");
                aux=aux.getSiguiente();
            } while (aux!=r.getSiguiente());
        }
    }
}
