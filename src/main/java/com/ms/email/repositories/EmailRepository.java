package com.ms.email.repositories;

import com.ms.email.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Repository
public interface EmailRepository extends JpaRepository<EmailModel, UUID> {
    EmailModel findAllById( @PathVariable Long id);
}
