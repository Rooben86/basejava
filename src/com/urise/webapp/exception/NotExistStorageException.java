package com.urise.webapp.exception;

public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String uuid) {
        super("no resume with " + uuid + " found in the storage", uuid);
    }
}
