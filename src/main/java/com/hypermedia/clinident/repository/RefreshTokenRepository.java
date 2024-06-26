package com.hypermedia.clinident.repository;

import com.hypermedia.clinident.model.entities.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
}
