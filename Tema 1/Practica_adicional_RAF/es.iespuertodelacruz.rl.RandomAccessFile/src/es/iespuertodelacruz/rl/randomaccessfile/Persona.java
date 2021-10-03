/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.randomaccessfile;

/**
 *
 * @author Ruben Lemus 2ºDAM
 */
public class Persona {
    
    String dni;
    String nombre;
    double altura;
    int peso;

    public Persona(String dni, String nombre, double altura, int peso) {
        this.dni = dni;
        this.nombre = nombre;
        this.altura = altura;
        this.peso = peso;
    }
    
    public Persona(){}
    
    /**
     * Getters y setters.
     */

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
}
