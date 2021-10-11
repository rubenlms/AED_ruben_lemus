/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.jc.monedasxml.entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
/**
 *
 * @author rubenlemusDAM
 */

@XmlRootElement(name="monedas")
@XmlAccessorType(XmlAccessType.FIELD)
public class Almacen implements Serializable {
    
    ArrayList<Moneda>monedas;

    public Almacen(ArrayList<Moneda> monedas) {
        this.monedas = monedas;
    }
    
    public Almacen(){}
    
    //@XmlElement(name="monedas")
    public void setMonedas(ArrayList<Moneda>monedas) {
        this.monedas = monedas;
    }
    
    public ArrayList<Moneda> getMoneda(){
        return monedas;
    }
}
