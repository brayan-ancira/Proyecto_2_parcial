package GUI;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author artea
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author artea
 */
public class ManipulaArchivos implements Serializable
{

    public static void guarda(Object obj,String cad)
    {
        try
        {
            FileOutputStream fox=new FileOutputStream("datos/"+cad);
            try
            {
                ObjectOutputStream arch= new ObjectOutputStream(fox);
                arch.writeObject(obj);
                arch.close();
            } catch (IOException ex)
            {
                System.out.println("Error de salida de datos...");
            }
        } catch (FileNotFoundException ex)
        {
            System.out.println("Archivo no encontrado "+cad);
        }
    }
    public static Object carga(String cad){
        Object obj=null;
        try
        {
            FileInputStream file= new FileInputStream("datos/"+cad);
            try
            {
                ObjectInputStream arch= new ObjectInputStream(file);
                try
                {
                    obj=arch.readObject();
                    arch.close();
                } catch (ClassNotFoundException ex)
                {
                    System.out.println("No coinciden las clases...");
                }
            } catch (IOException ex)
            {
                System.out.println("No se puede leer el archivo seleccionado...");
            }
        } catch (FileNotFoundException ex)
        {
            System.out.println("Archivo no encontrado "+cad);
        }
        return obj;
    }

}
 