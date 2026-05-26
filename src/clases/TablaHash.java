/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import clases.NodoArbol;
import clases.ArbolB;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author artea
 */
public class TablaHash implements Serializable
{

    private ArbolB arr[] = new ArbolB[27];

    public TablaHash()
    {
        for (int i = 0; i < 27; i++)
        {
            arr[i] = new ArbolB();
        }
    }

    public ArbolB[] getArr()
    {
        return arr;
    }

    public void setArr(ArbolB[] arr)
    {
        this.arr = arr;
    }

    public void inserta(NodoArbol n)
    {
        if (n == null)
        {
            JOptionPane.showMessageDialog(null, "Tu pinche nodo esta vacio");
        } else
        {
            int pos = calPeso(n.getEtiqueta());
            if (pos != -1)
            {
                arr[pos].setR(arr[pos].inserta(arr[pos].getR(), n));
            }
        }
    }

    public NodoArbol elimina(String et)
    {
        if (et == "")
        {
            JOptionPane.showMessageDialog(null, "Tu pinche nodo esta vacio");
        } else
        {
            int p = calPeso(et);
            if (p!=-1)
            {
                NodoArbol arraux[]=new NodoArbol[2];
                arr[p].elimina(arraux, et, arr[p].getR());
                arr[p].setR(arraux[1]);
                return arraux[0];
            }
        }
        return null;
    }

    public int calPeso(String et)
    {
        if (et != "")
        {
            int pos = ((int) et.toUpperCase().charAt(0)) - 65;
            if (pos >= 0 || pos <= 25)
            {
                return pos;
            }
        }
        return -1;
    }
}
