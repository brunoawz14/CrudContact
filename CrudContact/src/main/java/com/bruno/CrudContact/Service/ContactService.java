package com.bruno.CrudContact.Service;

import com.bruno.CrudContact.Model.Contact;
import com.bruno.CrudContact.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    private ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact save(Contact contact) {

        return contactRepository.save(contact);
    }

    public Optional<Contact> updatePartial(Long id, Contact dto) {

        return contactRepository.findById(id).map(contact -> {

            if (dto.getName() != null) {
                contact.setName(dto.getName());
            }

            if (dto.getEmail() != null) {
                contact.setEmail(dto.getEmail());
            }

            if (dto.getTelephone() != null) {
                contact.setTelephone(dto.getTelephone());
            }

            return contactRepository.save(contact);
        });
    }

    public Optional<Contact> findById(Long id) {

        return contactRepository.findById(id);
    }

    public void delete(Long id) {
        contactRepository.deleteById(id);
    }
}
