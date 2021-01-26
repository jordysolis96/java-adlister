package dao;

import dao.Contacts;
import models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactListDao implements Contacts {

    private List<Contact> contacts = new ArrayList<>();

    // Initially "seed" the contacts
    public ContactListDao() {
        contacts.add(new Contact(1, "John", "Conner", "2105556767"));
        contacts.add(new Contact(2, "Fred", "Smith", "2105556769"));
        contacts.add(new Contact(3, "Sarah", "Conner", "2105551010"));
        contacts.add(new Contact(4, "Kyle", "Reese", "2105551111"));
    }
    @Override
    public List<Contact> getContacts() {
        return contacts;
    }

    @Override
    public long saveContact(Contact contact) {
        if (contact.getId() == 0) {
            contact.setId(contacts.size() + 1);
            contacts.add(contact);
        } else {
            contacts.set((int) contact.getId(), contact);
        }

        return contact.getId();
    }

    @Override
    public void deleteContactById(long id) {
        List<Contact> updatedContacts = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getId() != id) {
                updatedContacts.add(contact);
            }
        }
        contacts = updatedContacts;
    }

    @Override
    public Contact getContactById(long id) {
        return contacts.get((int) id - 1);
    }

    // test DAO in main; run Tomcat server to run application
    public static void main(String[] args) {
        Contacts contactDao = new ContactListDao();

        // test getContacts()
        System.out.println("\n=== Testing getContacts()");
        List<Contact> allContacts = contactDao.getContacts();

        for (Contact contact : allContacts) {
            System.out.println(contact.getFirstName());
        }
    }
}
