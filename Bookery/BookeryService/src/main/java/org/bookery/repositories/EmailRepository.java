package org.bookery.repositories;

import java.util.UUID;

import org.bookery.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, UUID> { }