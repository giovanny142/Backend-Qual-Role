package com.qual_role.repositories;

import com.qual_role.models.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyModel, UUID> {
}
