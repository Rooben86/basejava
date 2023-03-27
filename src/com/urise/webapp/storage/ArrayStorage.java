package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index != -1) {
            storage[index] = resume;
            System.out.println("Resume " + resume.toString() + " has been updated");
            return;
        }
        System.out.println("no resume with " + resume.getUuid() + " found in the storage");
    }

    public void save(Resume resume) {
        if (getIndex(resume.getUuid()) == -1) {
            storage[size] = resume;
            size++;
        } else if (size == 10000){
            System.out.println("storage overflown");
        } else {
            System.out.println("The resume " + resume.getUuid() + " is already present in the storage");
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
                return storage[index];
            }
        System.out.println("no resume with such uuid - " + uuid + " - found in the storage");
        return null;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
                storage[index] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                } else {
            System.out.println("no resume with such uuid found in the storage");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] result = Arrays.copyOfRange(storage, 0, size);
        return result;
    }

    public int size() {
        return size;
    }

    public int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid))
                return i;
        }
        return -1;
    }
}