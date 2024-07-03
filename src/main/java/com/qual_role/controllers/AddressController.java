package com.qual_role.controllers;

import com.qual_role.dtos.AddressRecordDto;
import com.qual_role.models.AddressModel;
import com.qual_role.services.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/address")
    public ResponseEntity<AddressModel> createAddress(@RequestBody AddressRecordDto addressRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.createAddress(addressRecordDto));
    }

    @GetMapping("/address/{addressId}")
    public ResponseEntity<AddressModel> getAddressById(@PathVariable(value = "addressId") UUID addressId) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAddressById(addressId));
    }

    @DeleteMapping("/address/{addressId}")
    public ResponseEntity<String> deleteAddress(@PathVariable(value = "addressId") UUID addressId) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.deleteAddress(addressId));
    }

    @PutMapping("/address/{addressId}")
    public ResponseEntity<AddressModel> updateAddress(@PathVariable(value = "addressId") UUID addressId,
                                                      @RequestBody AddressRecordDto addressRecordDto) {

        return ResponseEntity.status(HttpStatus.OK).body(addressService.updateAddress(addressId, addressRecordDto));
    }

}
