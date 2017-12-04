package file_input_runner;

/**
 * Created by Nata on 03.12.17.
 */
public class FileInputRunner {
    public static void main(String[] args) {
        FileDataHandler handler = new FileDataHandler();
        handler.run(new FileInputGetter());
    }
}
