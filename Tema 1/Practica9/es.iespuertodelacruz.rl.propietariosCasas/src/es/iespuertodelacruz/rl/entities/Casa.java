/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.entities;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author ruben
 */
@XmlRootElement(name="casa")
public class Casa implements Serializable {
    
    int idCasa;
    String Calle;

    public Casa(int idCasa, String Calle) {
        this.idCasa = idCasa;
        this.Calle = Calle;
    }
    
    public Casa(){}

    public int getIdCasa() {
        return idCasa;
    }
    
    @XmlElement(name="idCasa")
    public void setIdCasa(int idCasa) {
        this.idCasa = idCasa;
    }

    public String getCalle() {
        return Calle;
    }
    
    @XmlElement(name="calle")
    public void setCalle(String Calle) {
        this.Calle = Calle;
    }
    
}
