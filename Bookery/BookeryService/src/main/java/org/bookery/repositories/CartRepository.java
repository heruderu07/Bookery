package org.bookery.repositories;

import java.util.UUID;

import org.bookery.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, UUID> { }