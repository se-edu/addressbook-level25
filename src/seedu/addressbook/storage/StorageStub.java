package seedu.addressbook.storage;

/**
 * Created by Francis on 21/9/2017.
 */
public class StorageStub extends StorageFile{

    public StorageStub() throws InvalidStorageFilePathException {
        super();
    }

    public StorageStub(String filePath) throws InvalidStorageFilePathException {
        super(filePath);
    }

    public void save() {
    }


}
