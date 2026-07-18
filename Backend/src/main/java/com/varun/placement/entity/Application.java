package com.varun.placement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "applications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonIgnoreProperties({"applications","offers"})
    private Student student;

    @ManyToOne
    @JoinColumn(name = "drive_id")
    @JsonIgnoreProperties({"applications"})
    private PlacementDrive placementDrive;
    
    private String status;
}