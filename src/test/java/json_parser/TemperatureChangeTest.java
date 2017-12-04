package json_parser;

import raw_data_storage.ForecastDataStorage;
import org.junit.Before;
import org.junit.Test;
import report.FinalReport;

import static org.mockito.Mockito.mock;

/**
 * Created by Nata on 17.11.17.
 */
public class TemperatureChangeTest {
    private ForecastReportBuilder parser;

    @Before
    public void prepareObjects() {
        parser = new ForecastReportBuilder(new ForecastDataStorage(), new FinalReport());
    }

    @Test
    public void testIfTempMaxChangesNegativeToPositive() {
        parser.max_temp = -2;
        parser.changeMaximum(1);
        assert(parser.max_temp == 1);
    }

    @Test
    public void testIfTempMaxChangesAfterComaDifference() {
        parser.max_temp = -1.15;
        parser.changeMaximum(-1.12);
        assert(parser.max_temp == -1.12);
    }

    @Test
    public void testIfTempMaxChangesFirstResultNegative() {
        parser.changeMaximum(-1);
        System.out.println(parser.max_temp);
        assert(parser.max_temp == -1);
    }

    @Test
    public void testIfTempMinChangesPositiveToNegative() {
        parser.min_temp = 10;
        parser.changeMinimum(-1);
        assert(parser.min_temp == -1);
    }

    @Test
    public void testIfTempMinChangesAfterComaDifference() {
        parser.min_temp = 10.01;
        parser.changeMinimum(10);
        assert(parser.min_temp == 10);
    }

    @Test
    public void testIfTempMinChangesFirstValuePositive() {
        parser.changeMinimum(1);
        assert(parser.min_temp == 1);
    }

}
