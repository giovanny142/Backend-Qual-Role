package com.qual_role.models;

import com.qual_role.enums.CategoryEnum;
import com.qual_role.enums.OperatingDaysEnum;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_COMPANY")
public class CompanyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressModel address;

    @OneToOne(mappedBy = "company")
    private QueueModel queue;

    @Column()
    private String document;

    @Column()
    private String name;

    @Column()
    private String phone;

    @Column()
    private List<String> socialNetwork;

    @Column()
    private String addressNumber;

    @Column()
    private String addressComplement;

    @Enumerated(EnumType.STRING)
    @Column()
    private CategoryEnum category;

    @Column()
    private String description;

    @Column()
    private String logoImageUrl;

    @Column()
    private List<String> companyImages;

    @Column()
    private Date startOpeningHour;

    @Column()
    private Date endOpeningHour;

    @Enumerated(EnumType.STRING)
    @Column()
    private List<OperatingDaysEnum> operatingDays;

    @Column()
    private Boolean isOpen;

    @Column()
    private Date createdAt;

    @Column()
    private Date updatedAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getSocialNetwork() {
        return socialNetwork;
    }

    public void setSocialNetwork(List<String> socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getAddressComplement() {
        return addressComplement;
    }

    public void setAddressComplement(String addressComplement) {
        this.addressComplement = addressComplement;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogoImageUrl() {
        return logoImageUrl;
    }

    public void setLogoImageUrl(String logoImageUrl) {
        this.logoImageUrl = logoImageUrl;
    }

    public List<String> getCompanyImages() {
        return companyImages;
    }

    public void setCompanyImages(List<String> companyImages) {
        this.companyImages = companyImages;
    }

    public Date getStartOpeningHour() {
        return startOpeningHour;
    }

    public void setStartOpeningHour(Date startOpeningHour) {
        this.startOpeningHour = startOpeningHour;
    }

    public Date getEndOpeningHour() {
        return endOpeningHour;
    }

    public void setEndOpeningHour(Date endOpeningHour) {
        this.endOpeningHour = endOpeningHour;
    }

    public List<OperatingDaysEnum> getOperatingDays() {
        return operatingDays;
    }

    public void setOperatingDays(List<OperatingDaysEnum> operatingDays) {
        this.operatingDays = operatingDays;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }
}
