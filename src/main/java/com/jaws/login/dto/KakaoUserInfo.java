package com.jaws.login.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class KakaoUserInfo {

    @JsonProperty("kakao_account")
    private KakaoAccount kakaoAccount;
}



