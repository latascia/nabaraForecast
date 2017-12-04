package file_input_runner;

import com.google.gson.Gson;
import request.Request;
import request.RequestList;

import java.io.FileNotFoundException;


class FileInputGetter {

    RequestList getRequestFromFile() throws FileNotFoundException {
        FileReader reader = new FileReader();
        String input = reader.getInputFromFile();
        Gson gson = new Gson();
        return gson.fromJson(input, RequestList.class);
    }
}
