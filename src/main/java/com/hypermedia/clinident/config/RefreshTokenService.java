package com.hypermedia.clinident.config;

import com.hypermedia.clinident.exception.EmailNotFoundException;
import com.hypermedia.clinident.model.entities.RefreshToken;
import com.hypermedia.clinident.model.entities.User;
import com.hypermedia.clinident.repository.RefreshTokenRepository;
import com.hypermedia.clinident.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken createRefreshToken(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new EmailNotFoundException("User not found: " + email));

        RefreshToken refreshToken = user.getRefreshToken();
        if (refreshToken == null) {
            refreshToken = RefreshToken.builder()
                    .refreshToken(UUID.randomUUID().toString())
                    .expiresAt(LocalDateTime.now())
                    .user(user)
                    .build();
            refreshTokenRepository.save(refreshToken);
        }
        return refreshToken;
    }

    public RefreshToken verifyRefreshToken(String refreshToken) {
        RefreshToken refToken = refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new RuntimeException("Refresh token not found: " + refreshToken));

        if (refToken.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Refresh token expired");
        }

        return refToken;
    }
}
