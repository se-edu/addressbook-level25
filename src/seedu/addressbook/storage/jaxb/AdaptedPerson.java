package seedu.addressbook.storage.jaxb;

import seedu.addressbook.common.Utils;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlValue;
import java.util.ArrayList;
import java.util.List;

/**
 * JAXB-friendly adapted person data holder class.
 */
public class AdaptedPerson {

    private static class AdaptedContactDetail {
        @XmlValue
        public String value;
        @XmlAttribute(required = true)
        public boolean isPrivate;
    }

    @XmlElement(required = true)
    private String name;
    @XmlElement(required = true)
    private AdaptedContactDetail phone;
    @XmlElement(required = true)
    private AdaptedContactDetail email;
    @XmlElement(required = true)
    private AdaptedContactDetail group;
    @XmlElement(required = true)
    private AdaptedContactDetail address;

    @XmlElement
    private List<AdaptedTag> tagged = new ArrayList<>();

    /**
     * No-arg constructor for JAXB use.
     */
    public AdaptedPerson() {}


    /**
     * Converts a given Person into this class for JAXB use.
     *
     * @param source future changes to this will not affect the created AdaptedPerson
     */
    public AdaptedPerson(ReadOnlyPerson source) {
        name = source.getName().fullName;

        phone = new AdaptedContactDetail();
        phone.isPrivate = source.getPhone().isPrivate();
        phone.value = source.getPhone().value;

        email = new AdaptedContactDetail();
        email.isPrivate = source.getEmail().isPrivate();
        email.value = source.getEmail().value;

        group = new AdaptedContactDetail();
        group.isPrivate = source.getGroup().isPrivate();
        group.value = source.getGroup().value;

        address = new AdaptedContactDetail();
        address.isPrivate = source.getAddress().isPrivate();
        address.value = source.getAddress().value;

        tagged = new ArrayList<>();
        for (Tag tag : source.getTags()) {
            tagged.add(new AdaptedTag(tag));
        }
    }

    /**
     * Returns true if any required field is missing.
     *
     * JAXB does not enforce (required = true) without a given XML schema.
     * Since we do most of our validation using the data class constructors, the only extra logic we need
     * is to ensure that every xml element in the document is present. JAXB sets missing elements as null,
     * so we check for that.
     */
    public boolean isAnyRequiredFieldMissing() {
        for (AdaptedTag tag : tagged) {
            if (tag.isAnyRequiredFieldMissing()) {
                return true;
            }
        }
        // second call only happens if phone/email/address are all not null
        return Utils.isAnyNull(name, phone, email, group, address)
                || Utils.isAnyNull(phone.value, email.value, group.value, address.value);
    }

    /**
     * Converts this jaxb-friendly adapted person object into the Person object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person
     */
    public Person toModelType() throws IllegalValueException {
        final List<Tag> personTags = new ArrayList<>();
        for (AdaptedTag tag : tagged) {
            personTags.add(tag.toModelType());
        }
        final Name name = new Name(this.name);
        final Phone phone = new Phone(this.phone.value, this.phone.isPrivate);
        final Email email = new Email(this.email.value, this.email.isPrivate);
        final Group group = new Group(this.group.value, this.group.isPrivate);
        final Address address = new Address(this.address.value, this.address.isPrivate);
        final UniqueTagList tags = new UniqueTagList(personTags);
        return new Person(name, phone, email, group, address, tags);
    }
}
