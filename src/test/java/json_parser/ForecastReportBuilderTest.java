package json_parser;

import raw_data_storage.ForecastDataStorage;
import org.junit.Before;
import org.junit.Test;
import report.FinalReport;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;


public class ForecastReportBuilderTest {
    private ForecastReportBuilder parser;

    @Before
    public void prepareObjects() {
        parser = new ForecastReportBuilder(new ForecastDataStorage(), new FinalReport());
    }

    @Test
    public void testIfTempMaxChangesNegativeToPositive() {
        parser.max_temp = -2;
        parser.changeMaximum(1);
        assertEquals(1, parser.max_temp, 0.01);
    }

    @Test
    public void testIfTempMaxChangesAfterComaDifference() {
        parser.max_temp = -1.15;
        parser.changeMaximum(-1.12);
        assertEquals(-1.12, parser.max_temp, 0.01);
    }

    @Test
    public void testIfTempMaxChangesFirstResultNegative() {
        parser.changeMaximum(-1);
        assertEquals(-1, parser.max_temp,0.01);
    }

    @Test
    public void testIfTempMinChangesPositiveToNegative() {
        parser.min_temp = 10;
        parser.changeMinimum(-1);
        assertEquals(-1, parser.min_temp, 0.01);
    }

    @Test
    public void testIfTempMinChangesAfterComaDifference() {
        parser.min_temp = 10.01;
        parser.changeMinimum(10);
        assertEquals(10, parser.min_temp, 0.01);
    }

    @Test
    public void testIfTempMinChangesFirstValuePositive() {
        parser.changeMinimum(1);
        assertEquals(1, parser.min_temp, 0.01);
    }

    @Test
    public void testIfCountsRightValuesAmountWithMidnight() {
        LocalDateTime time = LocalDateTime.parse("2017-12-16 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        int amount = parser.countNeededValuesAmount(time);
        assertEquals(23, amount);
    }

    @Test
    public void testIfCountsRightValuesAmountOneAM() {
        LocalDateTime time = LocalDateTime.parse("2017-12-16 01:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        int amount = parser.countNeededValuesAmount(time);
        assertEquals(23, amount);
    }

    @Test
    public void testIfCountsRightValuesAmountInEvening() {
        LocalDateTime time = LocalDateTime.parse("2017-12-16 23:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        int amount = parser.countNeededValuesAmount(time);
        assertEquals(16, amount);
    }

    @Test
    public void testIfCountsRightValuesAmountTwoPM() {
        LocalDateTime time = LocalDateTime.parse("2017-12-16 14:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        int amount = parser.countNeededValuesAmount(time);
        assertEquals(19, amount);
    }

}
