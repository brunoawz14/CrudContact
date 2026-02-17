package com.bruno.CrudContact.Repository;

import com.bruno.CrudContact.Model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
