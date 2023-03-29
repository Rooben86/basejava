package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            System.out.println("no resume with " + resume.getUuid() + " found in the storage");
        } else {
            storage[index] = resume;
            System.out.println("Resume " + resume.toString() + " has been updated");
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("no resume with such uuid - " + uuid + " - found in the storage");
            return null;
        }
        return storage[index];
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            System.out.println("The resume " + resume.getUuid() + " is already present in the storage");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("storage overflown");
        } else {
            insertElement(resume, index);
            size++;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("no resume with such uuid found in the storage");
        } else {
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        }
    }

    protected abstract void insertElement(Resume resume, int index);

    protected abstract void fillDeletedElement(int index);

    protected abstract int getIndex(String uuid);

}