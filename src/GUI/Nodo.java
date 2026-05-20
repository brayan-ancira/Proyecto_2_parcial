/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author Mauro S S
 */
public class Nodo<T>
{

    private T obj;
    private String et;
    private Nodo arb;
    private Nodo sig;
    private Nodo ant;
    private Nodo abj;

    public Nodo(T obj, String et)
    {
        this.obj = obj;
        this.et = et;
    }

    /**
     * @return the obj
     */
    public T getObj()
    {
        return obj;
    }

    public Nodo getArb()
    {
        return arb;
    }

    public void setArb(Nodo arb)
    {
        this.arb = arb;
    }

    public Nodo getAnt()
    {
        return ant;
    }

    public void setAnt(Nodo ant)
    {
        this.ant = ant;
    }

    public Nodo getAbj()
    {
        return abj;
    }

    public void setAbj(Nodo abj)
    {
        this.abj = abj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(T obj)
    {
        this.obj = obj;
    }

    /**
     * @return the et
     */
    public String getEt()
    {
        return et;
    }

    /**
     * @param et the et to set
     */
    public void setEt(String et)
    {
        this.et = et;
    }

    /**
     * @return the sig
     */
    public Nodo getSig()
    {
        return sig;
    }

    /**
     * @param sig the sig to set
     */
    public void setSig(Nodo sig)
    {
        this.sig = sig;
    }

}
