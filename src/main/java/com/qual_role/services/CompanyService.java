package com.qual_role.services;

import com.qual_role.dtos.AddressRecordDto;
import com.qual_role.dtos.CompanyRecordDto;
import com.qual_role.models.AddressModel;
import com.qual_role.models.CompanyModel;
import com.qual_role.repositories.AddressRepository;
import com.qual_role.repositories.CompanyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final AddressRepository addressRepository;

    public CompanyService(CompanyRepository companyRepository, AddressRepository addressRepository) {
        this.companyRepository = companyRepository;
        this.addressRepository = addressRepository;
    }

    public CompanyModel createCompany(CompanyRecordDto companyRecordDto) {
        try {
            CompanyModel company = new CompanyModel();
            BeanUtils.copyProperties(companyRecordDto, company);
            company.setAddress(addressRepository.findById(companyRecordDto.addressId()).get());
            company.setCreatedAt(LocalDate.now());
            company.setUpdatedAt(LocalDate.now());

            return companyRepository.save(company);

        } catch (Exception e) {
            throw new RuntimeException("ERROR TO CREATE COMPANY");
        }
    }

    public CompanyModel getCompanyById(UUID companyId) {
        return companyRepository.findById(companyId).orElseThrow(() -> new NoSuchElementException("Company not found"));
    }

    public String deleteCompany(UUID companyId) {
        var company = companyRepository.findById(companyId);

        if (company.isEmpty()) {
            throw new NoSuchElementException("Company not found to delete.");
        }

        companyRepository.delete(company.get());
        return "company successfully deleted";
    }

    public CompanyModel updateCompany(UUID addressId, CompanyRecordDto companyRecordDto) {
        var companyFound = companyRepository.findById(addressId);

        if (companyFound.isEmpty()) {
            throw new NoSuchElementException("Address not found to update.");
        }

        var company = companyFound.get();
        company.setUpdatedAt(LocalDate.now());
        BeanUtils.copyProperties(companyRecordDto, company);
        return companyRepository.save(company);
    }
}
