package com.qual_role.dtos;

import jakarta.validation.constraints.NotNull;

public record AddressRecordDto(
        @NotNull String district,
        @NotNull String streetName,
        @NotNull String zipCode,
        @NotNull String city,
        @NotNull String state ) {
}
