package seedu.addressbook.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.tag.UniqueTagList;

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
    
    public static Person generateTestPerson() {
        try {
            return new Person(new Name(Name.EXAMPLE), new Phone(Phone.EXAMPLE, false),
                    new Email(Email.EXAMPLE, true), new Address(Address.EXAMPLE, false), new UniqueTagList());
        } catch (IllegalValueException e) {
            fail("test person data should be valid by definition");
            return null;
        }
    }
}
