package com.varun.placement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import java.time.LocalDate;

@Entity
@Table(name = "placement_drives")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlacementDrive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driveId;

    private String jobRole;

    private LocalDate driveDate;

    private LocalDate lastDateToApply;

    private Integer vacancies;

    @ManyToOne
    @JoinColumn(name = "company_id")
    
    private Company company;
    @OneToMany(mappedBy = "placementDrive")
    @JsonIgnore
    private List<Application> applications;
}