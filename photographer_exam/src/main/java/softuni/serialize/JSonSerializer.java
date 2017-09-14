package softuni.serialize;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import softuni.utils.FileIO;


import java.io.IOException;

@Component(value = "JSonSerializer")
public class JSonSerializer implements Serializer{

    private Gson gson;

    @Autowired
    private FileIO fileIO;

    public JSonSerializer(){
        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    @Override
    public <T> void serialize(T o, String fileName) {
        String json = gson.toJson(o);
        try {
            fileIO.writeFile(json,fileName);
        } catch (IOException e) {
            //log here
            throw new SerializeExc(json+" was not serialized to "+fileName,e);
        }
    }

    @Override
    public <T> T deserialize(Class<T> classT, String fileName) {
        try {
            String json = fileIO.readFile(fileName);
            return gson.fromJson(json, classT);

        } catch (IOException e) {
            //log here

            throw new SerializeExc(fileName+" cannot be read.",e);
        }
    }
}
