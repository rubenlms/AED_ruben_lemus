/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ruben
 */
@XmlRootElement(name="monedas")
@XmlAccessorType(XmlAccessType.FIELD)
public class Almacen implements Serializable {
    
    ArrayList<Casa>casas;

    public Almacen(ArrayList<Casa> casas) {
        this.casas = casas;
    }
    
    public Almacen(){}

    public ArrayList<Casa> getCasas() {
        return casas;
    }

    public void setCasas(ArrayList<Casa> casas) {
        this.casas = casas;
    }
}
