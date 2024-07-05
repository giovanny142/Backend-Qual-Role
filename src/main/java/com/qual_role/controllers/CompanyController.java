package com.qual_role.controllers;

import com.qual_role.dtos.AddressRecordDto;
import com.qual_role.dtos.CompanyRecordDto;
import com.qual_role.models.AddressModel;
import com.qual_role.models.CompanyModel;
import com.qual_role.services.AddressService;
import com.qual_role.services.CompanyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/company")
@Validated
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService addressService) {
        this.companyService = addressService;
    }

    @PostMapping
    public ResponseEntity<CompanyModel> createCompany(@Valid @RequestBody CompanyRecordDto companyRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.createCompany(companyRecordDto));
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyModel> getCompanyById(@PathVariable UUID companyId) {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getCompanyById(companyId));
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<String> deleteCompany(@PathVariable UUID companyId) {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.deleteCompany(companyId));
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<CompanyModel> updateCompany(@PathVariable UUID companyId,
                                                      @Valid @RequestBody CompanyRecordDto companyRecordDto) {

        return ResponseEntity.status(HttpStatus.OK).body(companyService.updateCompany(companyId, companyRecordDto));
    }

}
