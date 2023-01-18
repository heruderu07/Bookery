package org.bookery.repositories;

import java.util.UUID;

import org.bookery.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, UUID> { }