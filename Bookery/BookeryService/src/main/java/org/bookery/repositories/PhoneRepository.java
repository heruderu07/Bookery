package org.bookery.repositories;

import java.util.UUID;

import org.bookery.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, UUID> { }