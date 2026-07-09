package gr.techpro.absence.entity;


import gr.techpro.absence.enums.Semester;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="module")
public class ModuleEntity {

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
    private Integer credits;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name="semester", length = 20, nullable = false)
    private Semester semester;

    @NotNull
    @Column(name="academic_year",nullable = false)
    private Integer acadYear;

    @Column(name="created_at", nullable = false)
    private LocalDateTime createdDate;
}
