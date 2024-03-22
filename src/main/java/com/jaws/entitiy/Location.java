package com.jaws.entitiy;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Location {
    //추후 api에 따라 수정 필요
    private String city;
    private String street;
    private String zipcode;
}

