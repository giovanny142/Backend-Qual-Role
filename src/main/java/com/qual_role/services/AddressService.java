package com.qual_role.services;

import com.qual_role.dtos.AddressRecordDto;
import com.qual_role.models.AddressModel;
import com.qual_role.repositories.AddressRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Transactional
    public AddressModel createAddress(AddressRecordDto addressRecordDto) {
        try {
            AddressModel address = new AddressModel();
            BeanUtils.copyProperties(addressRecordDto, address);
            address.setCreatedAt(LocalDate.now());
            address.setUpdatedAt(LocalDate.now());

            return addressRepository.save(address);

        } catch (Exception e) {
            throw new RuntimeException("ERROR TO CREATE ADDRESS");
        }
    }

    public AddressModel getAddressById(UUID addressId) {
        return addressRepository.findById(addressId).orElseThrow(() -> new NoSuchElementException("Address not found"));
    }

    @Transactional
    public String deleteAddress(UUID addressId) {
        var address = addressRepository.findById(addressId);

        if (address.isEmpty()) {
        throw new NoSuchElementException("Address not found to delete.");
        }

        addressRepository.delete(address.get());
        return "address successfully deleted";
    }

    @Transactional
    public AddressModel updateAddress(UUID addressId, AddressRecordDto addressRecordDto) {
        var addressFound = addressRepository.findById(addressId);

        if (addressFound.isEmpty()) {
            throw new NoSuchElementException("Address not found to update.");
        }

        var address = addressFound.get();
        address.setUpdatedAt(LocalDate.now());
        BeanUtils.copyProperties(addressRecordDto, address);
        return addressRepository.save(address);
    }
}
