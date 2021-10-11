/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.monedasxml.xml;

import es.iespuertodelacruz.rl.monedasxml.entities.Almacen;
import es.iespuertodelacruz.rl.monedasxml.entities.Moneda;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author ruben
 */
public class MonedaXML implements JavaToXMLString<Moneda>{

    @Override
    public String objToStringXML(Moneda moneda) {
        //TRANSFORMA OBJ A UN STRING XML 
        JAXBContext contexto;
        Marshaller marshaller;
        OutputStream os=null;
        StringWriter sw = new StringWriter();
        try {
            contexto =  JAXBContext.newInstance(moneda.getClass());
            marshaller  = contexto.createMarshaller();
         marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(moneda, sw);
        } catch (JAXBException ex) {
            System.out.println(ex);
        }finally{
            return sw.toString();
        }
    }

    @Override
    public Moneda stringXMLToObj(String textoXML) {
        JAXBContext contexto;
        Marshaller marshaller;
        StringReader sr = new StringReader(textoXML);
        Moneda moneda = null;
        try {
            contexto =  JAXBContext.newInstance(Moneda.class);
            marshaller  = contexto.createMarshaller();
                        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            Unmarshaller unmarshaller = contexto.createUnmarshaller();
            moneda = (Moneda) unmarshaller.unmarshal(sr);
        } catch (JAXBException ex) {
            System.out.println(ex);
        }finally{
            return moneda;
        }
    }
    
}
