package com.qual_role.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AddressRecordDto(
        @NotEmpty String district,
        @NotEmpty String streetName,
        @NotEmpty String zipCode,
        @NotEmpty String city,
        @NotEmpty String state) {
}
