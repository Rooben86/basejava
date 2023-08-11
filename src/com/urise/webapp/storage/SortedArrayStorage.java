package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    private static final Comparator<Resume> RESUME_COMPARATOR = (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());
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
        protected Integer getSearchKey(String uuid) {
            Resume searchKey = new Resume(uuid, "dummy");
            return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
        }
}
