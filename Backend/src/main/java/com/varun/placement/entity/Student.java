package com.varun.placement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToMany;

import com.varun.placement.entity.Application;
import com.varun.placement.entity.Offer;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @NotBlank(message = "Student name is required")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Phone number is required")
    private String phone;

    @NotBlank(message = "Branch is required")
    private String branch;

    @PositiveOrZero(message = "CGPA cannot be negative")
    private Double cgpa;

    private Integer graduationYear;

    private String skills;
    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<Application> applications;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<Offer> offers;
}