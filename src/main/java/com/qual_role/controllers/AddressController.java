package com.qual_role.controllers;

import com.qual_role.dtos.AddressRecordDto;
import com.qual_role.models.AddressModel;
import com.qual_role.services.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<AddressModel> createAddress(@Valid @RequestBody AddressRecordDto addressRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.createAddress(addressRecordDto));
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<AddressModel> getAddressById(@PathVariable(value = "addressId") UUID addressId) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAddressById(addressId));
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<String> deleteAddress(@PathVariable(value = "addressId") UUID addressId) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.deleteAddress(addressId));
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<AddressModel> updateAddress(@PathVariable(value = "addressId") UUID addressId,
                                                      @Valid @RequestBody AddressRecordDto addressRecordDto) {

        return ResponseEntity.status(HttpStatus.OK).body(addressService.updateAddress(addressId, addressRecordDto));
    }

}
