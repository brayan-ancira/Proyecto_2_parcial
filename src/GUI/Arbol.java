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
public class Arbol implements Serializable 
{

    private NodoArbol r = null;

    

    public NodoArbol getR()
    {
        return r;
    }

    /**
     * @param r the r to set
     */
    public void setR(NodoArbol r)
    {
        this.r = r;
    }

    /**
     * 
     *  Metodo que nos ayuda a la insercion de nodoArbol a un arbol
     *  Lo inserta en in orden
     * 
     * @param r la raiz del arbol
     * @param n el nuevo nodoarbol a insertar
     * @return la raiz del arbol con el nodo conectado en el espacio libre 
     *         dependiendo de si hay o no espacio y si es menor o mayor a la 
     *         raiz evaluda al momento
     * 
     */
    public NodoArbol inserta(NodoArbol r, NodoArbol n)
    {
        if (n != null) //si el nodo n es null no se inserta
        {
            if (r == null) //Si el nodo del arbol es nulo regresa solo el nodo n
            {
                return n; 
            } else
            {
                //Si n es menor a r
                if (n.getEtiqueta().compareTo(r.getEtiqueta()) < 0)
                {

                    r.setIzq(inserta(r.getIzq(), n));
                    
                    
                } else//Si n es mayor a r 
                {
                    r.setDer(inserta(r.getDer(), n));
                }
            }
        }
        return r;
    }

    
    //Inserción con la implementación de métodos de árbol AVL
    public NodoArbol insertar(NodoArbol r,  NodoArbol n)
    {
        if (n != null) //si el nodo n es null no se inserta
        {
            if (r == null) //Si el nodo del arbol es nulo regresa solo el nodo n
            {
                return n; 
            } else
            {
                //Si n es menor a r
                if (n.getEtiqueta().compareTo(r.getEtiqueta()) < 0)
                {

                    r.setIzq(insertar(r.getIzq(), n));
                    
                    
                } else//Si n es mayor a r 
                {
                    r.setDer(insertar(r.getDer(), n));
                }
            }
            
            return balancear(r);

        }
        return r;
    }

    
    /**
     * 
     * Funcion elimina noto, se requiere un string del nodo a eliminar
     * el arreglo de nodo arbol es para regresar en la posicion [0] el nodo 
     * en la posicion de [1] es la nueva r de nuestro arbol
     *
     * @param arr arreglo de NodoArbol
     * @param s Etiqueta del nodo a eliminar
     * @param r Raiz del arbol a buscar
     */
    public void elimina(NodoArbol arr[], String s, NodoArbol r)
    {
        if (r == null)
        {
            arr[0] = null;
            arr[1] = null;

        } else
        {

            if (r.getEtiqueta().equals(s))
            {
                
                arr[0] = r;//La r a eliminar es la unica que hay
                
                //Si no tiene hijos la raiz la nueva r es nula
                if (r.getIzq() == null&& r.getDer() == null)
                {
                    arr[1] = null;
                } else
                {
                    //Si hay aunque sea un hijo
                    if (!(r.getIzq() != null
                            && r.getDer() != null))
                    {
                        //Si es el izquiedo entonces regresa el izq
                        if (r.getIzq() != null)
                        {
                            arr[1] = r.getIzq();
                        } else
                        {
                            //Si no es el izquierda entonces regresa el der
                            arr[1] = r.getDer();
                        }
                    } else
                    {
                        
                        //Si del aldo derecho no tiene nada a la izquierda
                        if (r.getDer().getIzq() == null)
                        {
                            
                            //Al nodo de la derecha a su izquierda 
                            // le asigna el nodo a la izq de la raiz en su izq
                            r.getDer().setIzq(r.getIzq());
                            //Se convierte en la nueva raiz el nodo derecho
                            arr[1] = r.getDer();
                            
                            //Lo que paso fue que como la raiz ya no existe
                            //el hijo izq se vuelve el hijo izq del hijo der org
                        } else
                        {
                            //buscamos si a derecha hay algo a su izq 
                            //si no hay regresa el derecha 
                            //si hay regresa esa izq
                            NodoArbol se = buscaSE(r.getDer());
                            
                            //La raiz se vuelve la izquierda del nodo que buscamos
                            arr[1] = se.getIzq();
                            
                            //Se conecta la izquierda de ese nodo que buscamos
                            //a el hijo derecho de la izquierd del nodo que buscamos
                            se.setIzq(se.getIzq().getDer());
                            
                            //el nodo que encontramos a su izq conectamos la izq
                            // de la raiz
                            arr[1].setIzq(r.getIzq());
                            
                            //el nodo que encontramos a su der conectamos la der 
                            // de la raiz
                            arr[1].setDer(r.getDer());
                        }
                    }
                }
                //Desconecta el nodo que sacamos del arbol
                arr[0].setDer(null); 
                arr[0].setIzq(null);
            } else
            {
                //Sino es la raiz el nodo a eliminar 
                //vemos si es mayor a la raiz para hacer la recursion
                if (r.getEtiqueta().compareTo(s) > 0)
                {
                    //recursion del lado izq
                    elimina(arr, s, r.getIzq());
                    r.setIzq(arr[1]);
                } else
                {
                    //recursion del lado derecho
                    elimina(arr, s, r.getDer());
                    r.setDer(arr[1]);
                }
                //Regresa la nueva raiz
                arr[1] = r;
            }
        }
    }

    public NodoArbol buscaSE(NodoArbol r)
    {
        //Busca el nodo a la izquierda de la izquierda de la raiz que se le de
        //hasta que ya no haya nada
        if (r.getIzq().getIzq() != null)
        {
            return buscaSE(r.getIzq()); //regresa el siguiente nodo
        }
        return r;
        //regresa la raiz original
    }

    
    ////////////////////////////////////////////////////
    //SKIBIDI
    // Método auxiliar para obtener la altura de un nodo
    
    private int obtenerAltura(NodoArbol nodo)
    {
        //Si la raiz esta en null, la altura del arbol es 0
        if (nodo == null)
        {
            return 0;
        }
        
        // Calculamos la altura recorriendo la izquierda y la derecha
        
        /*
            En esta parte de bajo del comentario es una terna
            que al valor de altIzq y altDer el resultado del propio 
            metodo (recursivo) para conocer la altura general del lado izquierdo
            o derecho
        */
        int altIzq = (nodo.getIzq() == null) ? 0 : obtenerAltura(nodo.getIzq());
        int altDer = (nodo.getDer() == null) ? 0 : obtenerAltura(nodo.getDer());

        /*
            Como el nodo de la raiz es diferente de null entonces ya tiene 
            como minimo una altura de 1 entonces se le suma la mayor altura 
            alcanzada por alguna de las ramas
        */
        return 1 + Math.max(altIzq, altDer);
    }

    // Método para obtener el factor de equilibrio de un nodo [arbol]
    private int obtenerFactorEquilibrio(NodoArbol nodo)
    {
        if (nodo == null)
        {
            return 0;
        }
        
        int altIzq = (nodo.getIzq() == null) ? 0 : obtenerAltura(nodo.getIzq());
        int altDer = (nodo.getDer() == null) ? 0 : obtenerAltura(nodo.getDer());

        return altDer - altIzq;
    }

    // Rotación Simple a la Derecha (RSD)
    private NodoArbol rotacionDerecha(NodoArbol nodo)
    {
        
        NodoArbol hijoIzquierdo = nodo.getIzq();
        NodoArbol subArbolDerecho = hijoIzquierdo.getDer();

        // Realizar la rotación
        hijoIzquierdo.setDer(nodo);
        nodo.setIzq(subArbolDerecho);

        return hijoIzquierdo;
    }

    // Rotación Simple a la Izquierda (RSI)
    private NodoArbol rotacionIzquierda(NodoArbol nodo)
    {
        NodoArbol hijoDerecho = nodo.getDer();
        NodoArbol subArbolIzquierdo = hijoDerecho.getIzq();

        // Realizar la rotación
        hijoDerecho.setIzq(nodo);
        nodo.setDer(subArbolIzquierdo);

        return hijoDerecho;
    }

    public NodoArbol balancear(NodoArbol nodo)
    {
        //guard clauss
        if (nodo == null)
        {
            return nodo;
        }

        // Obtenemos el factor de equilibrio del nodo actual
        int fe = obtenerFactorEquilibrio(nodo);

        // Caso 1: Desequilibrio hacia la derecha (fe > 1)
        
        if (fe > 1)
        {
            
            // Obtenemos el factor de equilibrio del hijo derecho
            /*
                Rotacion doble si es que esta en -1 porque quiere
                decir que esta en zigzag
            */
            if (obtenerFactorEquilibrio(nodo.getDer()) < 0)
            {
                // Desequilibrio en zigzag: Rotación Doble (Derecha-Izquierda)
                nodo.setDer(rotacionDerecha(nodo.getDer()));
                return rotacionIzquierda(nodo);
                
            } else
            {
                // Desequilibrio lineal: Rotación Simple a la Izquierda
                
                return rotacionIzquierda(nodo);
            }
        }

        // Caso 2: Desequilibrio hacia la izquierda (fe < -1)
        if (fe < -1)
        {
            // Obtenemos el factor de equilibrio del hijo izquierdo
            if (obtenerFactorEquilibrio(nodo.getIzq()) > 0)
            {
                // Desequilibrio en zigzag: Rotación Doble (Izquierda-Derecha)
                nodo.setIzq(rotacionIzquierda(nodo.getIzq()));
                return rotacionDerecha(nodo);
            } else
            {
                // Desequilibrio lineal: Rotación Simple a la Derecha
                return rotacionDerecha(nodo);
            }
        }

        // Si el factor de equilibrio está entre -1 y 1, el nodo no necesita balanceo
        return nodo;
    }

    
    
    /**
     * Método principal que devuelve un String con el árbol recorrido por niveles.
     * Puede ser llamado desde Main imprimiendo su resultado.
     */
    
    public String despArbolPorNiveles()
    {
        if (this.r == null)
        {
            return "Tree is empty\n";
        }

        String resultado = "";
        
        // Reutilizamos tu método obtenerAltura que ya tienes en la clase
        int altura = obtenerAltura(this.r);

        // Iteramos sobre cada nivel (empezando desde 1 hasta la altura máxima)
        for (int nivel = 1; nivel <= altura; nivel++)
        {
            resultado += "Nivel " + (nivel - 1) + ": ";
            resultado += obtenerNodosDelNivel(this.r, nivel);
            resultado += "\n";
        }

        return resultado;
    }

    /**
     * Método auxiliar recursivo que busca y concatena las etiquetas 
     * de los nodos que pertenecen a un nivel específico.
     */
    private String obtenerNodosDelNivel(NodoArbol nodo, int nivel)
    {
        if (nodo == null)
        {
            return "Ø ";
        }
        
        // Si llegamos al nivel objetivo, devolvemos la etiqueta del nodo
        if (nivel == 1)
        {
            return nodo.getEtiqueta() + " ";
        }else         // Si el nivel objetivo está más abajo, bajamos un nivel restando 1
        {
            if (nivel > 1)
            {
                String subIzquierdo = obtenerNodosDelNivel(nodo.getIzq(), nivel - 1);
                String subDerecho = obtenerNodosDelNivel(nodo.getDer(), nivel - 1);
                return subIzquierdo + subDerecho;
            }
        
        }
        return "";
    }
    
    
}
