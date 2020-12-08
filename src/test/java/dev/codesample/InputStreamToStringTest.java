package dev.codesample;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputStreamToStringTest {

    public static final String TEST_STRING = "This is a test!";
    public static final Charset TEST_CHARSET = Charset.forName("UTF-8");

    @Test
    public void testInputStreamToStringApacheCommons() throws IOException {

        // Create an input stream that contains bytes of a string
        try (InputStream inputStream = new ByteArrayInputStream(TEST_STRING.getBytes(TEST_CHARSET))) {
            String converted = InputStreamToString.inputStreamToStringApacheCommons(inputStream);
            assertEquals(TEST_STRING, converted);
        }

    }

    @Test
    public void testInputStreamToStringGoogleGuava() throws IOException {

        // Create an input stream that contains bytes of a string
        try (InputStream inputStream = new ByteArrayInputStream(TEST_STRING.getBytes(TEST_CHARSET))) {
            String converted = InputStreamToString.inputStreamToStringGoogleGuava(inputStream);
            assertEquals(TEST_STRING, converted);
        }
    }

    @Test
    public void testInputStreamToStringNoLibrary() throws IOException {

        // Create an input stream that contains bytes of a string
        try (InputStream inputStream = new ByteArrayInputStream(TEST_STRING.getBytes(TEST_CHARSET))) {
            String converted = InputStreamToString.inputStreamToStringNoLibrary(inputStream, TEST_CHARSET);
            assertEquals(TEST_STRING, converted);
        }
    }
}
