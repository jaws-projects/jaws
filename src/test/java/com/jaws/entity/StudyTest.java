package com.jaws.entity;

import com.jaws.entitiy.Member;
import com.jaws.entitiy.Study;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StudyTest {

    @Test
    void studyTest() throws Exception {
        //given
        Member member = createMember();

        //when
        Study study = new Study(member);

        //then
        assertThat(member.getNickname()).isEqualTo(study.getMember().getNickname());
        assertThat(member.getStudies().size()).isEqualTo(1);
        assertThat(member.getStudies().contains(study)).isTrue();
    }

    @Test
    void studyRemoveTest() throws Exception {
        //given
        Member member = createMember();
        Study study = new Study(member);

        //when
        study.removeStudy();

        //then
        assertThat(member.getStudies().size()).isEqualTo(0);
        //assertThat(study.getMember()).isEqualTo(null);
        assertThat(study.getMember().getNickname()).isEqualTo("승호");
    }

    private static Member createMember() {
        return new Member("test@email.com", "승호");
    }
}
