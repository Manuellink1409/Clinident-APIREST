package com.hypermedia.clinident.repository;

import com.hypermedia.clinident.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
