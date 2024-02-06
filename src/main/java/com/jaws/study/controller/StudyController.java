package com.jaws.study.controller;

import com.jaws.study.dto.StudyCreateDto;
import com.jaws.study.service.StudyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/study")
public class StudyController {

    private final StudyService studyService;

    @PostMapping("/create")
    public void createStudy(@RequestBody StudyCreateDto dto) {
        studyService.createStudy(dto);
    }

    @PostMapping("/remove/{id}")
    public void removeStudy(@PathVariable(name = "id") Long id) {
        studyService.removeStudy(id);
    }
}
