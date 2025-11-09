package com.springsecuritydemo.springsecurityapp.model;

import jakarta.persistence.*;

@Entity
@Table(name="subjects", schema = "cdp")
public class Subject {

    @Id
    @SequenceGenerator(name = "SubjectSequence", sequenceName = "subjects_subject_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SubjectSequence")
    @Column(name="subject_id")
    private long subjectId;
    @Column(name="subject_name")
    private String subjectName;
    @Column(name="tutor")
    private String tutor;

    public long getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }
}
