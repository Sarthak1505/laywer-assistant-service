package org.example.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "case_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CaseHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "case_id", nullable = false)
    private LegalCase legalCase;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lawyer_id", nullable = false)
    private Lawyer lawyer;
    @Column(name = "field_changed", nullable = false)
    private String fieldChanged;
    @Column(name = "old_value")
    private String oldValue;
    @Column(name = "new_value")
    private String newValue;
    @Column(name = "change_source")
    @Builder.Default
    private String changeSource = "SCRAPER";
    @Column(name = "detected_at")
    private LocalDateTime detectedAt;

}
