package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

    public class Module {

        public static final String EXAMPLE = "valid Module Name";
        public static final String MESSAGE_MODULE_CONSTRAINTS =
                "MODULE NAME SHOULD START AS 'MODULEC PREFIX' + 'MODULE CODE'";
        public static final String MODULE_VALIDATION_REGEX = "[\\w\\.]+@[\\w\\.]+";

        public final String value;
        private boolean isPrivate;

        public Module(String module,boolean isPrivate) throws IllegalValueException {

            this.isPrivate = isPrivate;
            module = module.trim();
            if (!isValidModule(module)) {
                throw new IllegalValueException(MESSAGE_MODULE_CONSTRAINTS);
            }
            this.value = module;

        }

        public static boolean isValidModule(String test) {

            return test.matches(MODULE_VALIDATION_REGEX);
        }

    }


