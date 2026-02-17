package com.bruno.CrudContact.Service;

import com.bruno.CrudContact.Model.Contact;
import com.bruno.CrudContact.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private ContactRepository repository;

    public List<Contact> findAll() {
        return repository.findAll();
    }

    public Contact save(Contact contact) {
        return repository.save(contact);
    }

    public Optional<Contact> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
