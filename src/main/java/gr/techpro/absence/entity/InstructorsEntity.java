package gr.techpro.absence.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
@Table(name="instructor")
public class InstructorsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto generates the id
    private Long id;

    @NotBlank
    @Column(name="first_name", length = 100,nullable = false)
    private String firstName;

    @NotBlank
    @Column(name="last_name",length = 100,nullable = false)
    private String lastName;

    @NotBlank
    @Column(name="email", length = 255,nullable = false, unique = true)
    private String email;

    @Column(name="created_at", nullable = false)
    private LocalDate createdDate;

}
