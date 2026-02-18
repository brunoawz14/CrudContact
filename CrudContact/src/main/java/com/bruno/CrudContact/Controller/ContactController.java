package com.bruno.CrudContact.Controller;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

import com.bruno.CrudContact.Dto.ContactDto;
import com.bruno.CrudContact.Model.Contact;
import com.bruno.CrudContact.Repository.ContactRepository;
import com.bruno.CrudContact.Service.ContactService;
import org.apache.catalina.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    // GET ALL
    @GetMapping
    public List<Contact> getAll() {
        return contactService.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Contact> getById(@PathVariable Long id) {
        return contactService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // CREATE
    @PostMapping
    public Contact create(@RequestBody Contact contact) {
        return contactService.save(contact);
    }

    // PATCH (UPDATE PARCIAL)
    @PatchMapping("/{id}")
    public ResponseEntity<Contact> update(
            @PathVariable Long id,
            @RequestBody Contact dto) {

        return contactService.updatePartial(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        contactService.delete(id);
    }
}