package org.bookery.repositories;

import java.util.UUID;

import org.bookery.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, UUID> { }