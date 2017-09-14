package softuni.io;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JsonParser {
    private Gson gson;

    private FileReader fileReader;

    @Autowired
    public JsonParser(FileReader fileReader) {
        this.fileReader = fileReader;
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    public <T> T getObject(Class<T> clazz, String path){
        T obj = null;

        String json = this.fileReader.readFile(path);
        obj  = this.gson.fromJson(json,clazz);
        return obj;
    }

    public <T> void writeObject(T clazz, String path){
            String content = this.gson.toJson(clazz);
            this.fileReader.writeFile(path, content);
    }
}
