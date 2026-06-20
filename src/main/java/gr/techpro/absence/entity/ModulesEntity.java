package gr.techpro.absence.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

@Entity
@Table(name="module")
public class ModulesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank  // No null, no "" or " "
    @Column(name="code",length = 20,nullable = false, unique = true)
    private String code;

    @NotBlank
    @Column(name="title", length = 255, nullable = false)
    private String title;


    @NotNull  // checks if null before persistence
    @Positive // checks if 0 or positive before persistence
    @Column(name="credits", nullable = false)
    private int credits;

    @NotBlank
    @Column(name="semester", length = 20, nullable = false)
    private String semester;

    @NotNull
    @Column(name="academic_year",nullable = false)
    private Integer acadYear;

    @Column(name="created_at", nullable = false)
    private LocalDate createdDate;
}
