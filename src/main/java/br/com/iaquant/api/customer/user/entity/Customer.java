package br.com.iaquant.api.customer.user.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Customer{
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
        @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)

        Long id;
        String name;
        String email;
        String phone;
        String taxId;
        LocalDate birthDate;
        String gender;
        @OneToOne(cascade = CascadeType.ALL) @JoinColumn(name = "user_id", referencedColumnName = "id")
        User user;
        @OneToOne(cascade = CascadeType.ALL) @JoinColumn(name = "address_id", referencedColumnName = "id")
        Address address;

        public Long getId() {
                return id;
        }

        public Customer setId(Long id) {
                this.id = id;
                return this;
        }

        public String getName() {
                return name;
        }

        public Customer setName(String name) {
                this.name = name;
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
