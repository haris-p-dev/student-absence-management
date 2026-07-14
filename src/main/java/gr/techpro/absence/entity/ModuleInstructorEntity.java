package gr.techpro.absence.entity;


import gr.techpro.absence.enums.InstructorRole;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="module_instructor", uniqueConstraints ={
                                        @UniqueConstraint( columnNames = {
                                                "module_id","instructor_id"})  })   //compination of the 2 columns must be unique
public class  ModuleInstructorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="module_id", nullable = false)
    private ModuleEntity module;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="instructor_id", nullable = false)
    private InstructorEntity   instructor;

    @Enumerated(EnumType.STRING)
    @Column(name="role", length=50, nullable = false)
    private InstructorRole role;


}
