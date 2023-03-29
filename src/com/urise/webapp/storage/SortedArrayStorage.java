package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertElement(Resume resume, int index) {
        int shiftedElement = -index - 1;
        System.arraycopy(storage, shiftedElement, storage, shiftedElement + 1, size - shiftedElement);
        storage[shiftedElement] = resume;
    }

    @Override
    protected void fillDeletedElement(int index) {
        int shiftedElements = size - index - 1;
        if (shiftedElements > 0) {
            System.arraycopy(storage, index + 1, storage, index, shiftedElements);
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}