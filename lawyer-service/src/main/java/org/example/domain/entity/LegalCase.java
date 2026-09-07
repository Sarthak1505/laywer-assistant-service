package org.example.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.domain.entity.enums.CaseStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "legal_cases")
public class LegalCase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "cnr", unique = true, nullable = false)
    private String cnr;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lawyer_id", nullable = false)
    private Lawyer lawyer;
    @Column(name = "case_title")
    private String caseTitle;
    @Column(name = "case_type")
    private String caseType;
    @Column(name = "case_number")
    private String caseNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "case_status")
    private CaseStatus caseStatus;
    @Column(name = "court_code")
    private String courtCode;
    @Column(name = "court_name")
    private String courtName;
    @Column(name = "judge_name")
    private String judgeName;
    @Column(name = "petitioners", columnDefinition = "text[]")
    private List<String> petitioners;
    @Column(name = "respondents", columnDefinition = "text[]")
    private List<String> respondents;
    @Column(name = "petitioner_advocates", columnDefinition = "text[]")
    private List<String> petitionerAdvocates;
    @Column(name = "respondent_advocates", columnDefinition = "text[]")
    private List<String> respondentAdvocates;
    @Column(name = "next_hearing_date")
    private LocalDateTime nextHearingDate;
    @Column(name = "previous_hearing_date")
    private LocalDateTime previousHearingDate;
    @Column(name = "filing_date")
    private LocalDate filingDate;
    @Column(name = "decision_date")
    private LocalDate decisionDate;
    @Column(name = "order_count")
    @Builder.Default
    private Integer orderCount = 0;
    @Column(name = "hearing_count")
    @Builder.Default
    private Integer hearingCount = 0;
    @Column(name = "tracked")
    @Builder.Default
    private Boolean tracked = true;
    @Column(name = "last_checked_at")
    private LocalDateTime lastCheckedAt;
    @Column(name = "last_notified_at")
    private LocalDateTime lastNotifiedAt;
    // add converter/type for jsonb mapping
    @Column(name = "last_scraped_data", columnDefinition = "jsonb")
    private Map<String, Object> lastScrapedData;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
