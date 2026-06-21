package gr.techpro.absence.entity;


import gr.techpro.absence.enums.EnrollmentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
@Table(name="enrollment", uniqueConstraints = {
                                @UniqueConstraint( columnNames = {       // Single Student enrollment per module
                                        "student_id", "module_id" })  })
public class EnrollmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="student_id", nullable = false)
    private StudentsEntity student;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="module_id",nullable = false)
    private ModulesEntity module;

    @Column(name="enrolled_at",nullable = false, insertable = false)    // prevents overwriting data auto-created by db
    private LocalDate enrolledAt;

    @Enumerated(EnumType.STRING)
    @Column(name="status",length = 20, nullable = false)
    private EnrollmentStatus  status;


}
