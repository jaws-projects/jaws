package com.jaws.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtAccessTokenTest {

    @Test
    void accessToken() throws Exception {
        //given
        String email = "test@email.com";
        String issuer = "jaws";

        long expiration = 60000L;

        Date currentDate = new Date();
        Date expirationDate = new Date(currentDate.getTime() + expiration);

        String customKey = "jawsProjectMadeBySeungHoAndKyungHyun";
        SecretKey secretKey = Keys.hmacShaKeyFor(customKey.getBytes());

        //when
        String token = Jwts.builder()
                .claim("email", email)
                .issuer(issuer)
                .issuedAt(currentDate)
                .expiration(expirationDate)
                .signWith(secretKey)
                .compact();

        //then
        System.out.println("token = " + token);
    }
}
