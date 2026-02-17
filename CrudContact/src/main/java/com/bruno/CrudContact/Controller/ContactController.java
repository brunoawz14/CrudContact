package com.bruno.CrudContact.Controller;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import com.bruno.CrudContact.Model.Contact;
import com.bruno.CrudContact.Repository.ContactRepository;
import com.bruno.CrudContact.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/Contact")
public class ContactController {
    @Autowired
    private ContactService service;

    @GetMapping
    public List<Contact> getAll() {
        return service.findAll();

    }

    @PostMapping
    public Contact create(@RequestBody Contact contact) {

        return service.save(contact);
    }

    @GetMapping("/{id}") public ResponseEntity<Contact> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
