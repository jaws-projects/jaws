package com.jaws.login.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KakaoResponseToken {

    @JsonProperty("access_token")
    private String accessToken;
}
