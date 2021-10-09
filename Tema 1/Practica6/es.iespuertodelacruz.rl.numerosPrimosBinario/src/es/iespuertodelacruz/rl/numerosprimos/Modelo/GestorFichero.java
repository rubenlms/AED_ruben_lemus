/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.numerosprimos.Modelo;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author rubenlemusDAM
 */
public class GestorFichero {
    
    /**
     * Comprueba si son primos hasta el número indicado en el parámetro size, si son primos los añade a una lista y al final los escribe en un fichero.
     * @throws IOException 
     */
    public void escribirPrimos(File f) throws IOException{
        
        FileOutputStream fis=new FileOutputStream(f);
        DataOutputStream dos=new DataOutputStream(fis);
        int size = 10000000;
        ArrayList<Integer>listaNP = new ArrayList();

        for (int posPrimo = 2; posPrimo <= size; posPrimo++) {
            if (esPrimo(posPrimo)) {
                //System.out.println(posPrimo);
                listaNP.add(posPrimo);
            }
        }
        
        for (Integer e : listaNP) {
                dos.writeInt(e);
            }
        dos.close();
    }
    
    /**
     * Comprueba si un número es primo.
     * @param posPrimo número a comprobar
     * @return  true si es un número primo
     */
    public boolean esPrimo(int posPrimo) {
        if (posPrimo == 2 || posPrimo == 3) {
            return true;
        }

        if (posPrimo % 2 == 0 || posPrimo % 3 == 0) {
            return false;
        }

        for (int i = 3; i < Math.sqrt(posPrimo); i += 2) {
            if (posPrimo % i == 0 || posPrimo % Math.sqrt(posPrimo) == 0) {
                return false;
            }
        }
        return true;

    }
}
