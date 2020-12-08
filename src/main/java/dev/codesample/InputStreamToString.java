package dev.codesample;

import com.google.common.io.CharStreams;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class InputStreamToString {

    public static String inputStreamToStringApacheCommons(InputStream inputStream) throws IOException {

        // Ensure you specify the appropriate character set.
        return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
    }

    public static String inputStreamToStringGoogleGuava(InputStream inputStream) throws IOException {

        // Ensure you specify the appropriate character set.
        return CharStreams.toString(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
    }

public static String inputStreamToStringNoLibrary(InputStream inputStream, Charset charset) throws IOException {

    // Create an output stream that the data can be loaded into. Uses try-with-resources to ensure the
    // stream is closed.
    try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
        byte[] buffer = new byte[1024];
        int length;

        // Read the data into a byte array and then write it into the output stream until there is no data
        // left to be read.
        while ((length = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, length);
        }

        return new String(outputStream.toByteArray(), charset);
    }
}
}
