/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author Mauro S S
 */
public class ListasDLML 
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
            System.out.println("no se puede insertar");
        } else
        {
            if (r == null)
            {
                r=n;
            } else
            {
                if (n.getEt().compareTo(r.getEt())<0)
                {
                    n.setSig(r);
                    r.setAnt(n);
                    r=n;
                } else
                {
                    Nodo aux=r;
                    boolean b = true;
                    while (aux.getSig() != null && b)
                    {
                        if (n.getEt().compareTo(aux.getSig().getEt())<0)
                        {
                            n.setSig(aux.getSig());
                            n.setAnt(aux);
                            aux.getSig().setAnt(n);
                            aux.setSig(n);
                            b= false;
                        } else
                        {
                            aux= aux.getSig();
                        }
                    }
                    if (b)
                    {
                        n.setAnt(aux);
                        aux.setSig(n);
                    }
                }
            }
                    
        }
    }
    
    public Nodo elimina(String et)
    {
        Nodo n=null;
        if (r==null)
        {
            System.out.println("lista vacia");
        } else
        {
            if (r.getEt().compareTo(et)>0)
            {
                System.out.println("no existe el dato");
            } else
            {
                if (r.getEt().equals(et))
                {
                    n=r;
                    r=n.getSig();
                    if (r!= null)
                    {
                        r.setAnt(null);
                    }
                    n.setSig(null);
                } else
                {
                    Nodo aux= r;
                    boolean b = true;
                    while (aux.getSig()!= null && b)
                    {
                        if (aux.getSig().getEt().equals(et))
                        {
                            n=aux.getSig();
                            if(n.getSig()!=null)
                            {
                                aux.getSig().getSig().setAnt(aux);
                            }
                            aux.setSig(n.getSig());
                            n.setSig(null);
                            n.setAnt(null);
                            b= false;
                        } else
                        {
                            if (aux.getSig().getEt().compareTo(et)>0)
                            {
                                System.out.println("dato no encontrado");
                                b=false;         
                            } else
                            {
                                aux= aux.getSig();
                            }
                        }
                    }
                    if (b)
                    {
                        System.out.println("no se encontro el dato");
                    }
                }
            }
        }
        return n;
    }
    
    public String desp()
    {
        String s="";
        Nodo aux =r;
        Nodo ant= null;
        while (aux != null)
        {
            s+=aux.getObj() +"\t";
            ant=aux;
            aux=aux.getSig();
        }
        s+="\n";
        while (ant != null)
        {
            s+=ant.getObj() +"\t";
            ant=ant.getAnt();
        }
        return s;
    }
}
