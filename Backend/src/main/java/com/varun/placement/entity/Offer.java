package com.varun.placement.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "offers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonIgnoreProperties({"applications","offers"})
    private Student student;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnoreProperties({"placementDrives"})
    private Company company;

    private Double salary;

    private LocalDate joiningDate;

    private String status;
}