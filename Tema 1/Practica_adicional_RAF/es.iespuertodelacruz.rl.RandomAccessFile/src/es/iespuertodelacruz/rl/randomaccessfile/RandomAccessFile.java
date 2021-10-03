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
public class RandomAccessFile {
    
    String path; 
    String modo;

    public RandomAccessFile(String path, String modo) {
        this.path = path;
        this.modo = modo;
    }
    
    public RandomAccessFile(){}
    
    /**
     * Getters y setters
     */
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }
    
}
