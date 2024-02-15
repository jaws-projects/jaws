package com.jaws.login.controller;

import com.jaws.login.service.LoginService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @GetMapping
    public String login() {
        return "contents/login";
    }

    @GetMapping("/kakao")
    public void kakaoLogin(HttpServletResponse response) {
        String uri = loginService.redirectKakaoLogin();

        try {
            response.sendRedirect(uri);
        } catch (IOException e) {
            log.error("카카오 로그인 에러");
        }
    }

    @GetMapping("/kakao/callback")
    public String getKakaoAuthenticationCode(@RequestParam(name = "code") String code) {
        loginService.getAccessToken(code);

        return "redirect:/";
    }
}
