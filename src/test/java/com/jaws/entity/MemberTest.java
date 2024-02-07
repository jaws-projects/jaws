package com.jaws.entity;

import com.jaws.entitiy.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberTest {

    @Test
    void memberTest() throws Exception {
        //given
        Member member = new Member("test@email.com", "승호");

        //when
        member.updateNickname("변경된 승호");

        //then
        Assertions.assertThat(member.getNickname()).isEqualTo("변경된 승호");
    }
}
