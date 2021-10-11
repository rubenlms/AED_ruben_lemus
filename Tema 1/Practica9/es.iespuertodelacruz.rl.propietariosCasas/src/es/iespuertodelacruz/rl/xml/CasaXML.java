/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.xml;

import es.iespuertodelacruz.rl.entities.Almacen;
import es.iespuertodelacruz.rl.entities.Casa;
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
public class CasaXML implements JavaToXML<Casa> {

    @Override
    public String objToStringXML(Casa casa) {
        JAXBContext contexto;
        Marshaller marshaller;
        OutputStream os=null;
        StringWriter sw = new StringWriter();
        try {
            contexto =  JAXBContext.newInstance(casa.getClass());
            marshaller  = contexto.createMarshaller();
         marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(casa, sw);
        } catch (JAXBException ex) {
            System.out.println(ex);
        } finally{
            return sw.toString();
        }
    }

    @Override
    public Object stringXMLToObj(String textoXML) {
        JAXBContext contexto;
        Marshaller marshaller;
        StringReader sr = new StringReader(textoXML);
        Casa casa = null;
        try {
            contexto =  JAXBContext.newInstance(Casa.class);
            marshaller  = contexto.createMarshaller();
                        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            Unmarshaller unmarshaller = contexto.createUnmarshaller();
            casa = (Casa) unmarshaller.unmarshal(sr);
        } catch (JAXBException ex) {
            System.out.println(ex);
        } finally{
            return casa;
        }
    }
    
}
