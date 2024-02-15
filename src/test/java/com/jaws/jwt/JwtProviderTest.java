package com.jaws.jwt;

import com.jaws.security.jwt.JwtProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JwtProviderTest {

    @Autowired
    JwtProvider jwtProvider;

    @Test
    void createAccessTokenAndFindUserInfo() throws Exception {
        //given
        String email = "test@email.com";
        String token = jwtProvider.generateAccessToken(email);

        //when
        String emailFromToken = jwtProvider.getEmailFromToken(token);

        //then
        assertThat(emailFromToken).isEqualTo(email);
    }
}