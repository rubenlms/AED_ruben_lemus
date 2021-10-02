/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.numerosprimos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author rubenlemusDAM
 */
public class EsIespuertodelacruzRlNumerosPrimos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedWriter bw = new BufferedWriter(new FileWriter("num_primos.txt"));
        int size = 1000;
        boolean esPrimo = true;
        ArrayList<Integer>listaNP = new ArrayList();
        int posPrimo = 13;
       
        for (int i = 3; i < posPrimo; i+=2) {
            
            if(posPrimo%i==0){
                    esPrimo=false;
                } else if((i*i)>posPrimo){
                    break;
                }
            }
        
            if (esPrimo){
                listaNP.add(posPrimo);
            }
        
        for (Integer e : listaNP) {
            bw.write(e.toString() + "\n");
            bw.close();
        }
    }    
    
}
