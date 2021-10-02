/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.lecturaficheros;

import java.io.Serializable;

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
        
        char [] subDNI = dni.toCharArray();
        
        letra = subDNI[8];
        
        String num = subDNI.toString(); //comprobar si funciona
        numero = Integer.parseInt(num);
        
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
