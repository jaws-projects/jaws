package com.jaws.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Member extends TimeStamped {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;
    private String nickname;

    @OneToMany(mappedBy = "member", cascade = ALL, orphanRemoval = true)
    private List<Study> studies = new ArrayList<>();

    public Member(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    // 업데이트 메서드
    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }

    public void addStudy(Study study) {
        this.studies.add(study);
    }

    public void removeStudy(Study study) {
        this.studies.remove(study);
    }
}
