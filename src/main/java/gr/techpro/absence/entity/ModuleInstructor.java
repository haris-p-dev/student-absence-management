package gr.techpro.absence.entity;


import gr.techpro.absence.enums.InstructorRole;
import jakarta.persistence.*;

@Entity
@Table(name="module_instructor", uniqueConstraints ={
                                        @UniqueConstraint( columnNames = {
                                                "module_id","instructor_id"})  })  //
public class ModuleInstructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="module_id", nullable = false)
    private ModulesEntity module;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="instructor_id", nullable = false)
    private InstructorsEntity instructor;

    @Enumerated(EnumType.STRING)
    @Column(name="role", length=50, nullable = false)
    private InstructorRole role;


}
