/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.xml;

import es.iespuertodelacruz.rl.entities.Almacen;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author ruben
 */
public class AlmacenXML implements JavaToXML<Almacen> {

    @Override
    public String objToStringXML(Almacen almacen) {
        JAXBContext contexto;
        Marshaller marshaller;
        OutputStream os=null;
        StringWriter sw = new StringWriter();
        try {
            contexto =  JAXBContext.newInstance(almacen.getClass());
            marshaller  = contexto.createMarshaller();
         marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(almacen, sw);
        } catch (JAXBException ex) {
            System.out.println(ex);
        } finally{
            return sw.toString();
        }
    }

    @Override
    public Almacen stringXMLToObj(String textoXML) {
        JAXBContext contexto;
        Marshaller marshaller;
        StringReader sr = new StringReader(textoXML);
        Almacen almacen = null;
        try {
            contexto =  JAXBContext.newInstance(Almacen.class);
            marshaller  = contexto.createMarshaller();
                        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            Unmarshaller unmarshaller = contexto.createUnmarshaller();
            almacen = (Almacen) unmarshaller.unmarshal(sr);
        } catch (JAXBException ex) {
            System.out.println(ex);
        } finally{
            return almacen;
        }
    }
    
}
