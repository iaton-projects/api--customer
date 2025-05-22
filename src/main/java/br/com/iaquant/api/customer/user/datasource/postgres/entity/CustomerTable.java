package br.com.iaquant.api.customer.user.datasource.postgres.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "customer")
public class CustomerTable {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
        @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String taxId;
        private LocalDate birthDate;
        private String gender;
        @OneToOne(cascade = CascadeType.ALL) @JoinColumn(name = "user_id", referencedColumnName = "id")
        private UserTable user;
        @OneToOne(cascade = CascadeType.ALL) @JoinColumn(name = "address_id", referencedColumnName = "id")
        private AddressTable address;

        public Long getId() {
                return id;
        }

        public CustomerTable setId(Long id) {
                this.id = id;
                return this;
        }

        public String getFirstName() {
                return firstName;
        }

        public CustomerTable setFirstName(String firstName) {
                this.firstName = firstName;
                return this;
        }

        public String getLastName() {
                return lastName;
        }

        public CustomerTable setLastName(String lastName) {
                this.lastName = lastName;
                return this;
        }

        public String getEmail() {
                return email;
        }

        public CustomerTable setEmail(String email) {
                this.email = email;
                return this;
        }

        public String getPhone() {
                return phone;
        }

        public CustomerTable setPhone(String phone) {
                this.phone = phone;
                return this;
        }

        public String getTaxId() {
                return taxId;
        }

        public CustomerTable setTaxId(String taxId) {
                this.taxId = taxId;
                return this;
        }

        public LocalDate getBirthDate() {
                return birthDate;
        }

        public CustomerTable setBirthDate(LocalDate birthDate) {
                this.birthDate = birthDate;
                return this;
        }

        public String getGender() {
                return gender;
        }

        public CustomerTable setGender(String gender) {
                this.gender = gender;
                return this;
        }

        public UserTable getUser() {
                return user;
        }

        public CustomerTable setUser(UserTable user) {
                this.user = user;
                return this;
        }

        public AddressTable getAddress() {
                return address;
        }

        public CustomerTable setAddress(AddressTable address) {
                this.address = address;
                return this;
        }
}
