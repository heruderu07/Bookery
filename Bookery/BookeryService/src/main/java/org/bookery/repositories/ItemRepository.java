package org.bookery.repositories;

import java.util.UUID;

import org.bookery.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, UUID> { }