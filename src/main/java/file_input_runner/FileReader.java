package file_input_runner;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class FileReader {
    String getInputFromFile() throws FileNotFoundException {
        StringBuilder input = new StringBuilder();
        final String PATH = "input.txt";
        File file = new File(PATH);
        Scanner scanner = new Scanner(file);

        while(scanner.hasNextLine()) {
            input.append(scanner.nextLine());
        }
        scanner.close();
        return input.toString();
    }
}
