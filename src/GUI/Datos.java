/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.io.Serializable;

/**
 *
 * @author artea
 */
public class Datos implements Serializable
{

    private MultiLista multilista = new MultiLista();
    private TablaHash hash = new TablaHash();

    public MultiLista getMultilista()
    {
        return multilista;
    }

    public void setMultilista(MultiLista multilista)
    {
        this.multilista = multilista;
    }

    public TablaHash getHash()
    {
        return hash;
    }

    public void setHash(TablaHash hash)
    {
        this.hash = hash;
    }

}
