package time_formatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TimeFormatterTest {

    @Test void shouldFormatWhenZeroSeconds() {
        var input = 0;

        var formattedString = TimeFormatter.formatDuration(input);

        assertEquals("", formattedString);
    }

    @ParameterizedTest @CsvSource(value = {"1, 1 second", "2, 2 seconds", "59, 59 seconds"})//
    void shouldFormatSeconds(String input, String expected) {

        var formattedString = TimeFormatter.formatDuration(Integer.parseInt(input));

        assertEquals(expected, formattedString);
    }

    @Test void shouldFormatWhenZeroMinutes() {
        var input = 0;

        var formattedString = TimeFormatter.formatDuration(input);

        assertEquals("", formattedString);
    }

    @ParameterizedTest @CsvSource(value = {"60, 1 minute"})//
    void shouldFormatMinutes(String input, String expected) {

        var formattedString = TimeFormatter.formatDuration(Integer.parseInt(input));

        assertEquals(expected, formattedString);
    }


    @Test @Disabled("while developing with TDD") void exampleTests() {
        assertEquals("1 second", TimeFormatter.formatDuration(1));
        assertEquals("1 minute and 2 seconds", TimeFormatter.formatDuration(62));
        assertEquals("2 minutes", TimeFormatter.formatDuration(120));
        assertEquals("1 hour", TimeFormatter.formatDuration(3600));
        assertEquals("1 hour, 1 minute and 2 seconds", TimeFormatter.formatDuration(3662));
    }

}