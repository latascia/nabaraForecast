package file_input_runner;

import com.google.gson.Gson;
import request.Request;
import request.RequestList;

import java.io.FileNotFoundException;
import java.util.Optional;


class FileInputGetter {

    private final FileReader reader;

    FileInputGetter(FileReader reader) {
        this.reader = reader;
    }

    Optional<RequestList> getRequestFromFile() throws FileNotFoundException {
        String input = reader.getInputFromFile();
        Gson gson = new Gson();
        return Optional.ofNullable(gson.fromJson(input, RequestList.class));
    }
}
