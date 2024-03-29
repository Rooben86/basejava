package com.urise.webapp.exception;

public class ExistStorageException extends StorageException {
    public ExistStorageException(String uuid) {
        super("resume with " + uuid + " already exists", uuid);
    }
}
