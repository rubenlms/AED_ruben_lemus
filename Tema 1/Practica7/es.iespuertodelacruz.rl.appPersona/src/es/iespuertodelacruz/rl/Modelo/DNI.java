/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.Modelo;
import java.io.Serializable;

/**
 *
 * @author ruben
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
}
