package org.example.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "lawyers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lawyer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    // add converter to encrypt bar number
    @Column(name = "bar_number", unique = true, nullable = false)
    private String barNumber;
    @Column(name = "state_code", nullable = false)
    private String stateCode;
    @Column(nullable = false)
    private String district;
    @Column(name = "court_codes", columnDefinition = "text[]")
    private List<String> courtCodes;
    // add converter to encrypt number
    @Column(name = "whatsapp_number", nullable = false)
    private String whatsappNumber;
    @Column(name = "is_active")
    @Builder.Default
    private Boolean active = true;
    @Column(name = "total_cases_tracked")
    @Builder.Default
    private Integer totalCasesTracked = 0;
    @Column(name = "onboarded_at")
    private LocalDateTime onboardedAt;
    @Column(name = "last_refreshed_at")
    private LocalDateTime lastRefreshedAt;
    @OneToMany(mappedBy = "lawyer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LegalCase> legalCases;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
