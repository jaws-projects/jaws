package com.jaws.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtAccessTokenTest {

    private final String customKey = "jawsProjectMadeBySeungHoAndKyungHyun";
    private final String ISSUER = "jaws";
    private final SecretKey secretKey = Keys.hmacShaKeyFor(customKey.getBytes());
    private final String E_MAIL = "email";
    private final Long EXPIRATION = 60000L;

    @Test
    void accessToken() throws Exception {
        //given
        String email = "test@email.com";

        //when
        Claims claims = createClaims(email);
        String token = createToken(claims);

        //then
        System.out.println("token = " + token);
    }

    @Test
    void findEmail() throws Exception {
        //given
        String email = "test@email.com";

        Claims claims = createClaims(email);
        String token = createToken(claims);

        //when
        String emailFromToken = getEmailFromToken(token);

        //then
        Assertions.assertThat(emailFromToken).isEqualTo(email);
    }

    private String createToken(Claims claims) {
        return Jwts.builder()
                .claims(claims)
                .signWith(secretKey)
                .compact();
    }

    private Claims createClaims(String email) {

        Date currentDate = new Date();
        Date expirationDate = new Date(currentDate.getTime() + EXPIRATION);

        return Jwts.claims()
                .add(E_MAIL, email)
                .issuer(ISSUER)
                .issuedAt(currentDate)
                .expiration(expirationDate)
                .build();
    }

    private String getEmailFromToken(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get(E_MAIL)
                .toString();
    }
}
