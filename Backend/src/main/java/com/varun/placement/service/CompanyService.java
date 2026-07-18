package com.varun.placement.service;

import com.varun.placement.entity.Company;
import com.varun.placement.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    // Create Company
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    // Get All Companies
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    // Get Company By ID
    public Optional<Company> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    // Update Company
    public Company updateCompany(Long id, Company updatedCompany) {

        Company company = companyRepository.findById(id).orElseThrow();

        company.setCompanyName(updatedCompany.getCompanyName());
        company.setLocation(updatedCompany.getLocation());
        company.setPackageOffered(updatedCompany.getPackageOffered());
        company.setEligibleCgpa(updatedCompany.getEligibleCgpa());
        company.setDescription(updatedCompany.getDescription());

        return companyRepository.save(company);
    }

    // Delete Company
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}