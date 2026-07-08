package gr.techpro.absence.entity;

import gr.techpro.absence.enums.AbsenceStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Length;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name="absence")
public class AbsenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="enrollment_id")
    private Long enrollment;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="session_id")
    private SessionEntity session;


    @Enumerated(EnumType.STRING)
    @Column(name="status", length = 20, nullable = false)
    private AbsenceStatus status;

    @Column(name="justification")
    private String justification;

    @Column(name="justified", nullable = false)
    private boolean justified;

    @Column(name="recorded_at", nullable = false)
    private LocalDateTime recordedAt;

    @Column(name="updated_at", nullable = false)
    private  LocalDateTime updatedAt;

}
