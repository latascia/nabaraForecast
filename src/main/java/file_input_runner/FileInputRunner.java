package file_input_runner;


public class FileInputRunner {
    public static void main(String[] args) {
        FileDataHandler handler = new FileDataHandler();
        handler.run(new FileInputGetter(new FileReader()));
    }
}
