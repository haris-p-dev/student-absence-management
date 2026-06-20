package gr.techpro.absence.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "session")
public class SessionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)  // Lazy loads the obj
    @JoinColumn(name="module_id",nullable = false)  // Where the FK is stored
    private ModulesEntity moduleId;  //moduleEntity obj to many sessions

    @Column(name="session_date", nullable = false)
    private LocalDate sessionDate;

    @Column(name="start_time", nullable = false)
    private LocalTime startTime;

    @Column(name="end_time", unique = false)
    private LocalTime endTime;

    @Column(name="session_type", length=20, nullable = false)
    private String sessionType;

    @AssertTrue
    @Column()
    private String topic;

}
