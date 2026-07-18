package com.varun.placement.service;

import com.varun.placement.entity.Student;
import com.varun.placement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Create Student
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Get All Students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get Student By ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Update Student
    public Student updateStudent(Long id, Student updatedStudent) {

        Student student = studentRepository.findById(id).orElseThrow();

        student.setName(updatedStudent.getName());
        student.setEmail(updatedStudent.getEmail());
        student.setPhone(updatedStudent.getPhone());
        student.setBranch(updatedStudent.getBranch());
        student.setCgpa(updatedStudent.getCgpa());
        student.setGraduationYear(updatedStudent.getGraduationYear());
        student.setSkills(updatedStudent.getSkills());

        return studentRepository.save(student);
    }

    // Delete Student
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}