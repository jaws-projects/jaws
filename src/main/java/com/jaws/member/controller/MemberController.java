package com.jaws.member.controller;

import com.jaws.member.dto.MemberCreateDto;
import com.jaws.member.dto.MemberResponseDto;
import com.jaws.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/create")
    public void createMember(@RequestBody MemberCreateDto dto) {
        memberService.createMember(dto);
    }

    @GetMapping("/list")
    public List<MemberResponseDto> memberList() {
        return memberService.getMemberList();
    }
}
