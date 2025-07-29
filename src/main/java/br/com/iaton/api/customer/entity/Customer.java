package br.com.iaton.api.customer.entity;

import java.time.LocalDate;

public class Customer {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String taxId;
    private LocalDate birthDate;
    private String gender;
    private User user;

    private Address address;

    public Long getId() {
        return id;
    }

    public Customer setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Customer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Customer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Customer setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getTaxId() {
        return taxId;
    }

    public Customer setTaxId(String taxId) {
        this.taxId = taxId;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Customer setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Customer setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Customer setUser(User user) {
        this.user = user;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Customer setAddress(Address address) {
        this.address = address;
        return this;
    }
}
