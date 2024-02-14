package com.jaws.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Slf4j
@Component
public class JwtProvider {

    @Value("${jwt.key}")
    private String customKey;

    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.accessTokenExpiration}")
    private Long accessTokenExpiration;

    @Value("${jwt.refreshTokenExpiration}")
    private Long refreshTokenExpiration;

    private final SecretKey secretKey = Keys.hmacShaKeyFor(customKey.getBytes());

    public String generateAccessToken(String email) {
        String token = createToken(email, accessTokenExpiration);
        log.info("생성된 accessToken = {}", token);

        return token;
    }

    public String generateRefreshToken(String email) {
        String token = createToken(email, refreshTokenExpiration);
        log.info("생성된 refreshToken = {}", token);

        return token;
    }

    private String createToken(String email, Long expiration) {

        Date currentDate = new Date();
        Date expirationDate = new Date(currentDate.getTime() + expiration);

        return Jwts.builder()
                .claim("email", email)
                .issuer(issuer)
                .issuedAt(currentDate)
                .expiration(expirationDate)
                .signWith(secretKey)
                .compact();
    }
}
