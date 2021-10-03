/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.lecturaficheros;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author rubenlemusDAM
 */
public class DNI implements Serializable {
    
    int numero;
    char letra;
    
    public DNI(int numero, char letra){
        this.numero = numero;
        this.letra = letra;
    }
    
    public DNI(){}

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }
    
    public void comprobarDNI(String dni){
        
    try {
        char letras_dni [] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        
        String dniNumero = dni.substring(0, dni.length()-1);
        numero = Integer.parseInt(dniNumero);
        letra = dni.charAt(8);
        
        int calculoLetra = numero%23;
        
        char letraCalculada = letras_dni[calculoLetra];
        
        if (letra == letraCalculada){
            System.out.println("La letra es correcta.");
        } else {
            System.out.println("NO es correcta.");
        }
         
    } catch(Exception e) {
        e.printStackTrace();
    }
        
        
        
    }
    
}
