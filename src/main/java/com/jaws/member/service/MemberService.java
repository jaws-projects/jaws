package com.jaws.member.service;

import com.jaws.entity.Member;
import com.jaws.member.dto.MemberCreateDto;
import com.jaws.member.dto.MemberResponseDto;
import com.jaws.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void createMember(MemberCreateDto dto) {
        Member member = new Member(dto.getEmail(), dto.getNickname());

        memberRepository.save(member);
    }

    public List<MemberResponseDto> getMemberList() {
        return memberRepository.findAll().stream().map(MemberResponseDto::new).toList();
    }
}
