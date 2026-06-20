package gr.techpro.absence.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="student")
public class StudentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column( name ="first_name",length =100,nullable = false)
    private String firstName;

    @NotBlank
    @Column(name="last_name",length = 100,nullable = false)
    private String lastName;

    @NotBlank
    @Column(name="emal", length = 255, unique = true, nullable = false)
    private String email;


    @NotBlank
    @Column(name="student_number", length = 50, unique = true,nullable = false)
    private String studentNumber;

    @Column(name="enrollment_date",insertable = false,nullable = false)
    //insertable=false. Database manages the dates
    private LocalDate enrollDate;

    @Column(name="created_at",insertable = false,nullable = false)
    private LocalDate createdDate;





}
