package file_input_runner;


import org.junit.Test;
import request.RequestList;

import java.io.FileNotFoundException;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static junit.framework.TestCase.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileDataHandlerTest {

    @Test
    public void testIfRunMethodCallsForInput() {
        try {

            FileDataHandler handler = new FileDataHandler();
            FileInputGetter inputGetter = mock(FileInputGetter.class);
            when(inputGetter.getRequestFromFile()).thenReturn(Optional.of(new RequestList()));
            handler.run(inputGetter);
            verify(inputGetter).getRequestFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testIfCaughtFileNotFoundException() {
        try {
            FileDataHandler handler = new FileDataHandler();
            FileInputGetter inputGetter = mock(FileInputGetter.class);
            given(inputGetter.getRequestFromFile()).willThrow(new FileNotFoundException());
            handler.run(inputGetter);
        } catch (FileNotFoundException e) {
            fail();
        }
    }


}
