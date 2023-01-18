package org.bookery.repositories;

import java.util.Optional;
import java.util.UUID;

import org.bookery.models.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialsRepository extends JpaRepository<Credential, UUID> 
{
Optional<Credential> findByLogin(String login);

}
