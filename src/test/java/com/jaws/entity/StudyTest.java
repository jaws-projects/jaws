package com.jaws.entity;

import com.jaws.entitiy.Member;
import org.junit.jupiter.api.Test;

public class StudyTest {

    @Test
    void studyTest() throws Exception {
        //given
        Member member = createMember();

        //when
        //Study study = new Study(member);

        //then
        //assertThat(member.getStudies().contains(study)).isTrue();
    }

    @Test
    void studyRemoveTest() throws Exception {
        //given
        Member member = createMember();
        //Study study = new Study(member);

        //when
        //study.removeStudy();

        //then
        //assertThat(member.getStudies().size()).isEqualTo(0);
        //assertThat(study.getMember()).isEqualTo(null);
    }

    private static Member createMember() {
        return new Member("test@email.com", "승호");
    }
}
