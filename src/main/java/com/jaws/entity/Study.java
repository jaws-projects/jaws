package com.jaws.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Study extends TimeStamped {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "study_id")
    private Long id;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Member owner;

    private int maxParticipants;

    @Embedded
    private Location location;

    @Enumerated(EnumType.STRING)
    private StudyStatus status;

    private List<String> tags;

    @OneToMany(mappedBy = "study", orphanRemoval = true)
    private List<StudyEnrollment> enrollments;

    public Study(String title, String content, Member owner, int maxParticipants, Location location, StudyStatus status, List<String> tags) {
        this.title = title;
        this.content = content;
        this.owner = owner;
        this.maxParticipants = maxParticipants;
        this.location = location;
        this.status = status;
        this.tags = tags;
    }
}
