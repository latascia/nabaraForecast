package output_writer;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputWriter {


    void writeToFile(String path, String content){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.append(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
