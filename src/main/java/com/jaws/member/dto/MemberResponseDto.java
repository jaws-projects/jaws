package com.jaws.member.dto;

import com.jaws.entitiy.Member;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MemberResponseDto {

    private String email;
    private String nickname;

    private List<Long> studies;

    public MemberResponseDto(Member member) {
        this.email = member.getEmail();
        this.nickname = member.getNickname();

//        this.studies = member.getStudies().stream()
//                .map(Study::getId).toList();
    }
}
