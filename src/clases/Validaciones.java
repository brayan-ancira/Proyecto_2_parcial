/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author artea
 */
public class Validaciones
{

    public static boolean validaMarca(String s)
    {
        return s.matches("^[A-Za-z' ']{1,20}$");
    }
    public static boolean validaPlacas(String s)
    {
        return s.matches("^[A-Z0-9]{6,9}$");
    }
    public static boolean validaNombre(String s)
    {
        return s.matches("^[A-Za-z' ']{3,20}$");
    }
    public static boolean validaDireccion(String s)
    {
        return s.matches("^[A-Za-z0-9' ']{5,40}$");
    }
    public static boolean validaPrecio(String s)
    {
        return s.matches("\\d+(\\.\\d{1,2})?");
    }
    public static boolean validaEntero(String s)
    {
        return s.matches("^[0-9]{1,2}$");
    }

}
