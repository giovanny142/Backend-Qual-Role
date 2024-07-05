package com.qual_role.dtos;

import com.qual_role.enums.CategoryEnum;
import com.qual_role.enums.OperatingDaysEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record CompanyRecordDto(
        @NotNull UUID addressId,
        @NotEmpty String document,
        @NotEmpty String name,
        @NotEmpty String phone,
        @NotEmpty List<String> socialNetwork,
        @NotEmpty String addressNumber,
        @NotEmpty String addressComplement,
        @NotNull CategoryEnum category,
        @NotEmpty String description,
        @NotEmpty List<String> companyImages,
        @NotNull LocalDate startOpeningHour,
        @NotNull LocalDate endOpeningHour,
        @NotNull List<OperatingDaysEnum> operatingDays,
        Boolean isOpen,
        @NotNull LocalDate createdAt,
        @NotNull LocalDate updatedAt) {
}
