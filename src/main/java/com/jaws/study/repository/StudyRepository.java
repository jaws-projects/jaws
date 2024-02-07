package com.jaws.study.repository;

import com.jaws.entitiy.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Long> {
}
