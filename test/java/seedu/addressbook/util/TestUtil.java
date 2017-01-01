package seedu.addressbook.util;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TestUtil {
    /**
     * Asserts whether the text in the two given files are the same. Ignores any
     * differences in line endings
     */
    public static void assertTextFilesEqual(Path path1, Path path2) throws IOException {
        List<String> list1 = Files.readAllLines(path1, Charset.defaultCharset());
        List<String> list2 = Files.readAllLines(path2, Charset.defaultCharset());
        assertEquals(String.join("\n", list1), String.join("\n", list2));
    }
}
