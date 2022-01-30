package io.hibernate.entity

import groovy.transform.Canonical

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name="Instructor_detail")
class InstructorDetail {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id

    @Column(name="youtube_channel")
    String youtubeChannel

    @Column(name="hobby")
    String hobby

    @OneToOne(mappedBy = "instructorDetail",
            cascade = [CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH])
    Instructor instructor


    InstructorDetail() {
    }

    InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel
        this.hobby = hobby
    }


    @Override
    public String toString() {
        return "InstructorDetail{" +
                "youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
