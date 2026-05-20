/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author artea
 */
public class Validaciones
{

    public static boolean validaMarca(String s)
    {
        return s.matches("^[A-Za-z' ']{3,19}$");
    }

}
