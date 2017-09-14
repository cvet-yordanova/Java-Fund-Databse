package photography.serialize;


import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

@Component(value = "XMLSerializer")
public class XMLSerializer implements Serializer{

    @Override
    public <T> void serialize(T o, String fileName) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(o.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller .setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            String path = System.getProperty("user.dir")+File.separator+fileName;

            File f = new File(path);
            if(!f.exists()){
                f.getParentFile().mkdirs();
                f.createNewFile();
            }

            try(OutputStream os = new FileOutputStream(fileName);
            BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(os))){
                marshaller.marshal(o, bfw);
            }
        } catch (JAXBException e) {
            //log here
            throw new SerializeExc("Could ot serialize "+ o, e);
        } catch(IOException ioe){

            //log here
            throw new SerializeExc("Unable to write to file  "+ fileName, ioe);
        }
    }

    @Override
    public <T> T deserialize(Class<T> classT, String fileName) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(classT);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            try(InputStream is = classT.getResourceAsStream(fileName);
            BufferedReader bfr = new BufferedReader(new InputStreamReader(is));){
                T t = (T)unmarshaller.unmarshal(bfr);
                return t;
            }
        } catch (JAXBException e) {
            //log here
            throw new SerializeExc("Could not deserialize to class "+ classT, e);
        }catch (IOException e) {
            //log here
            throw new SerializeExc("Unable to write to file  "+ fileName, e);
        }
    }
}
