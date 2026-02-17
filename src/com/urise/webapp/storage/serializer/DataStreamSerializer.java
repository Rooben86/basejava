//package com.urise.webapp.storage.serializer;
//
//import com.urise.webapp.model.ContactType;
//import com.urise.webapp.model.Resume;
//import com.urise.webapp.model.Section;
//import com.urise.webapp.model.SectionType;
//
//import java.io.*;
//import java.util.Map;
//
//public class DataStreamSerializer implements StreamSerializer {
//    @Override
//    public void doWrite(Resume r, OutputStream os) throws IOException {
//        try (DataOutputStream dos = new DataOutputStream(os)) {
//            dos.writeUTF(r.getUuid());
//            dos.writeUTF(r.getFullName());
//            Map<ContactType, String> contacts = r.getContacts();
//            dos.writeInt(contacts.size());
//            for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
//                dos.writeUTF(entry.getKey().name());
//                dos.writeUTF(entry.getValue());
//            }
//            // TODO: implement sections
//            Map<SectionType, Section> sections = r.getSections();
//            dos.writeInt(sections.size());
//            for (Map.Entry<SectionType, Section> entry : sections.entrySet()) {
//                dos.writeUTF(entry.getKey().name());
//                dos.writeUTF(entry.getClass().toString());
//            }
//        }
//    }
//
//    @Override
//    public Resume doRead(InputStream is) throws IOException {
//        try (DataInputStream dis = new DataInputStream(is)) {
//            Resume resume = new Resume(dis.readUTF(), dis.readUTF());
//            for (int i = 0; i < dis.readInt(); i++) {
//                resume.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF());
//            }
//            // TODO: implement sections
//            for (int i = 0; i < dis.readInt(); i++) {
//                resume.addSection(SectionType.valueOf(dis.readUTF()), );
//            }
//            return resume;
//        }
//    }
//}
