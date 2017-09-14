package softuni.io;


import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileReader {

    public String readFile(String path){

        StringBuilder builder  = new StringBuilder();

        try(
                InputStream inputStream = this.getClass().getResourceAsStream(path);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                ){

            String line ="";
            while( (line = reader.readLine()) != null){
                builder.append(line);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }

    public void writeFile(String path, String content){

        try(
                OutputStream os = new FileOutputStream(path);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
                ) {

            bw.write(content);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
