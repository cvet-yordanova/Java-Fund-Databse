package softuni.utils;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileIO {
    public String readFile(String fileName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        InputStream is = this.getClass().getResourceAsStream(fileName);

        try {
            BufferedReader bfr = new BufferedReader(new InputStreamReader(is));
            String line = "";

            while ((line = bfr.readLine()) != null){
                stringBuilder.append(line);
            }
        } finally {

            try{is.close();
            } catch (IOException io){
                    //log
            }
        }

        return stringBuilder.toString();
    }

    public void writeFile(String content, String fileName) throws IOException {
        FileOutputStream os = new FileOutputStream(fileName);

        try{
           BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(os));
           bfw.write(content);
        } finally {
            try {
                os.close();
            } catch (IOException io){
                //log
            }
        }
    }
}
