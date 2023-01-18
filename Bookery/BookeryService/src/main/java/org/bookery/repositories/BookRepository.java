package org.bookery.repositories;

import java.util.UUID;

import org.bookery.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, UUID> { }