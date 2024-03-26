package com.jaws.study.service;

import com.jaws.entity.Member;
import com.jaws.entity.Study;
import com.jaws.member.repository.MemberRepository;
import com.jaws.study.dto.StudyCreateDto;
import com.jaws.study.repository.StudyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudyService {

    private final StudyRepository studyRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void createStudy(StudyCreateDto dto) {
        Member member = memberRepository.findById(dto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("멤버를 찾을 수 없습니다."));

//        Study study = new Study(member);
//        studyRepository.save(study);
    }

    @Transactional
    public void removeStudy(Long id) {
        Study study = studyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 스터디를 찾을 수 없습니다."));

//        study.removeStudy();
//
//        log.info("스터디 제거");
//        log.info(study.getOwner().getStudies().stream().map(Study::getId).toList().toString());
    }
}
