package gr.techpro.absence.entity;


import gr.techpro.absence.enums.SessionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "session")
public class SessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)    // Lazy loads the obj
    @JoinColumn(name="module_id",nullable = false)    // Where the FK is stored
    private ModulesEntity module;    //moduleEntity obj to many sessions

    @Column(name="session_date", nullable = false)
    private LocalDate sessionDate;

    @Column(name="start_time", nullable = false)
    private LocalTime startTime;

    @Column(name="end_time", nullable = false)
    private LocalTime endTime;

    @Enumerated(EnumType.STRING) //stores enum's name at db
    @Column(name="session_type", length=20, nullable = false)
    private SessionType sessionType;

    @Column(name="topic",length = 255)
    private String topic;



}
