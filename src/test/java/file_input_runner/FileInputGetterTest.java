package file_input_runner;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import request.RequestList;

import java.io.FileNotFoundException;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileInputGetterTest {
    private FileReader reader;
    private FileInputGetter getter;

    @Before
    public void prepare() {
        reader = mock(FileReader.class);
        getter = new FileInputGetter(reader);
    }

    @Test
    public void testIfGetterAsksForInputFromReader() {
        try {
            getter.getRequestFromFile();
            Mockito.verify(reader).getInputFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIfInputIsEmpty() {
        try {
            when(reader.getInputFromFile()).thenReturn("");
            Optional<RequestList> requests = getter.getRequestFromFile();
            assert(!requests.isPresent());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIfInputIsNotEmpty() {
        try {
            when(reader.getInputFromFile()).thenReturn("{\"requests\":[{\"cityName\":\"Tokyo\",\"countryCode\":\"JP\"}]}");
            Optional<RequestList> requests = getter.getRequestFromFile();
            assert(requests.isPresent());
            assert(1 == requests.get().requests.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
