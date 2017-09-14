package softuni.io;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

@Component
public class XMLParser {
    private JAXBContext jaxbContext;

    public XMLParser() throws JAXBException {
    }

    public <T> T getObject(Class<T> clazz, String path) throws JAXBException, IOException {
        this.jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();
        T object = null;

         try(
                 InputStream inputStream = this.getClass().getResourceAsStream(path);
                 ){
            object = (T)unmarshaller.unmarshal(inputStream);
         }

         return object;
    }


    public <T> void writeObject(T t, String path) throws JAXBException, IOException {
        this.jaxbContext = JAXBContext.newInstance(t.getClass());
        Marshaller marshaller = this.jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        try(
                OutputStream outputStream = new FileOutputStream(path);
                ){
            marshaller.marshal(t,outputStream);

        }
    }
}













