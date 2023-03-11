package time_formatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class TimeFormatterTest {

    private static Stream<Arguments> hoursMinutesAndSeconds() {
        return Stream.of(//
                         Arguments.of(3661, "1 hour, 1 minute and 1 second"),//
                         Arguments.of(3601, "1 hour and 1 second"),//
                         Arguments.of(3720, "1 hour and 2 minutes"),//
                         Arguments.of(3722, "1 hour, 2 minutes and 2 seconds")
        );
    }

    @Test void shouldFormatWhenZeroSeconds() {
        var input = 0;

        var formattedString = TimeFormatter.formatDuration(input);

        assertEquals("now", formattedString);
    }

    @ParameterizedTest @CsvSource(value = {"1, 1 second", "2, 2 seconds", "59, 59 seconds"})//
    void shouldFormatSeconds(String input, String expected) {

        var formattedString = TimeFormatter.formatDuration(Integer.parseInt(input));

        assertEquals(expected, formattedString);
    }


    @ParameterizedTest @CsvSource(value = {"60, 1 minute", "120, 2 minutes"})//
    void shouldFormatMinutes(String input, String expected) {

        var formattedString = TimeFormatter.formatDuration(Integer.parseInt(input));

        assertEquals(expected, formattedString);
    }

    @ParameterizedTest @CsvSource(value = {"61, 1 minute and 1 second", "130, 2 minutes and 10 seconds"})//
    void shouldFormatMinutesAndSeconds(String input, String expected) {

        var formattedString = TimeFormatter.formatDuration(Integer.parseInt(input));

        assertEquals(expected, formattedString);
    }

    @ParameterizedTest @CsvSource(value = {"3600, 1 hour", "7200, 2 hours"})//
    void shouldFormatHours(String input, String expected) {

        var formattedString = TimeFormatter.formatDuration(Integer.parseInt(input));

        assertEquals(expected, formattedString);
    }

    @ParameterizedTest @MethodSource("hoursMinutesAndSeconds")//
    void shouldFormatHoursMinutesAndSeconds(int input, String expected) {

        var formattedString = TimeFormatter.formatDuration(input);

        assertEquals(expected, formattedString);
    }

    @ParameterizedTest @CsvSource(value = {"86400, 1 day"})//
    void shouldFormatDays(String input, String expected) {

        var formattedString = TimeFormatter.formatDuration(Integer.parseInt(input));

        assertEquals(expected, formattedString);
    }

    @ParameterizedTest @CsvSource(value = {"31536000, 1 year", "63072000, 2 years"})//
    void shouldFormatYears(String input, String expected) {

        var formattedString = TimeFormatter.formatDuration(Integer.parseInt(input));

        assertEquals(expected, formattedString);
    }


    @Test void exampleTests() {
        assertEquals("1 second", TimeFormatter.formatDuration(1));
        assertEquals("1 minute and 2 seconds", TimeFormatter.formatDuration(62));
        assertEquals("2 minutes", TimeFormatter.formatDuration(120));
        assertEquals("1 hour", TimeFormatter.formatDuration(3600));
        assertEquals("1 hour, 1 minute and 2 seconds", TimeFormatter.formatDuration(3662));
    }

}