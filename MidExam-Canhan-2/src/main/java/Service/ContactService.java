package Service;

import Entity.Contact;

import java.util.List;

public interface ContactService {

    Iterable<Contact> findAll(); // Tim toan bo

    List<Contact> search(String term);

    Contact findOne(Integer id);// Tim 1

    void save(edu.till.Homestay.Contact contact); // Them 1 lien lac

    void delete(Integer id);	 // Xoa 1 lien lac

}
