package com.jaws.login.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class KakaoProfile {
    private String nickname;

    @JsonProperty("profile_image_url")
    private String profileImageUrl;
}
