package softuni.serialize;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import softuni.io.FileIO;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

@Component(value = "JSonSerializer")
public class JSonSerializer implements Serializer{

    private Gson gson;

    @Autowired
    private FileIO fileIO;

    public JSonSerializer(){
        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();
    }

    @Override
    public <T> void serialize(T o, String fileName) {
        String json = gson.toJson(o);
        try {
            fileIO.write(json,fileName);
        } catch (IOException e) {
            //log here
            throw new SerializeExc(json+" was not serialized to "+fileName,e);
        }
    }

    @Override
    public <T> T deserialize(Class<T> classT, String fileName) {
        try {
            String json = fileIO.read(fileName);

            return gson.fromJson(json, classT);

        } catch (IOException e) {
            //log here

            throw new SerializeExc(fileName+" cannot be read.",e);
        }
    }

}
