/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.jc.monedasxml;

import es.iespuertodelacruz.jc.monedasxml.entities.Historico;
import es.iespuertodelacruz.jc.monedasxml.entities.Moneda;
import es.iespuertodelacruz.jc.monedasxml.entities.Almacen;
import es.iespuertodelacruz.jc.monedasxml.utils.ManejoFichero;
import es.iespuertodelacruz.jc.monedasxml.xml.AlmacenXML;
import es.iespuertodelacruz.jc.monedasxml.xml.HistoricoXML;
import es.iespuertodelacruz.jc.monedasxml.xml.MonedaXML;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author carlos
 */
public class MonedasXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        ArrayList<Moneda>monedas = null;
        
        Almacen alm = new Almacen();
        alm.setMonedas(monedas);
        
        AlmacenXML almXML = new AlmacenXML();
        
        Moneda m = new Moneda(1,"libra","uk"); //crea una moneda nueva
        //alm.getMoneda().add(m);
        
        MonedaXML monedaXML = new MonedaXML(); 
        
        String strXMLmoneda = monedaXML.objToStringXML(m); //transforma el objeto anterior a XML
        
        System.out.println("PRIMER SOUT:"+
                strXMLmoneda
        );
        
        Moneda m2 = monedaXML.stringXMLToObj(strXMLmoneda); //Transforma un XML a objeto
        
        
        System.out.println("SEGUNDO SOUT" + m2);
        
        
        Historico h = new Historico(); //Crea el histórico 
        h.setMoneda(m2);
        h.setEquivalenteEuro(2.3);
        h.setFecha(new Date());
        h.setIdHistorico(1);
        
        HistoricoXML hXML = new HistoricoXML();
        
        System.out.println("TERCER SOUT"+
                hXML.objToStringXML(h)
        );
        
        
        m2.getHistoricos().add(h); //añade el histórico creado a la moneda anterior
        
        System.out.println("CUARTO SOUT"+monedaXML.objToStringXML(m2)
        );
     
        
        ManejoFichero mf = new ManejoFichero("mixml.txt"); //crea el fichero donde va a escribir el xml
        
        
        mf.agregarTexto(monedaXML.objToStringXML(m2)); //escribe el xml
        System.out.println("---- lectura ----");
        System.out.println("QUINTO SOUT"+
                mf.leerTodo() //lee el xml anterior
        );
        
        Moneda m3 = monedaXML.stringXMLToObj(mf.leerTodo()); //NO LEE!
        System.out.println("SEXTO SOUT"+m3);
        
    }
    
}
