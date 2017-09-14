package softuni.io;


import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileIO {

    public String read(String fileName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        InputStream is = this.getClass().getResourceAsStream(fileName);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = "";

            while((line = reader.readLine()) != null){
                    stringBuilder.append(line);
            }
        }
        finally {
            try {
                is.close();
            } catch (IOException e) {
                //log
            }
        }

        return stringBuilder.toString();

    }

    public void write (String content, String fileName) throws IOException {
        FileOutputStream os =  new FileOutputStream(fileName);

        try{
            BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(os));
            bfw.write(content);
            bfw.flush();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                //log
            }
        }
    }
}
