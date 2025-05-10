package br.com.iaquant.api.customer.user.entity;

import jakarta.persistence.*;

@Entity
public class Address {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
        @SequenceGenerator(name = "address_seq", sequenceName = "address_seq", allocationSize = 1)
        Long id;
        String zipCode;
        String address;
        String neighborhood;
        String city;
        String state;
        String complement;

        public Long getId() {
                return id;
        }

        public Address setId(Long id) {
                this.id = id;
                return this;
        }

        public String getZipCode() {
                return zipCode;
        }

        public Address setZipCode(String zipCode) {
                this.zipCode = zipCode;
                return this;
        }

        public String getAddress() {
                return address;
        }

        public Address setAddress(String address) {
                this.address = address;
                return this;
        }

        public String getNeighborhood() {
                return neighborhood;
        }

        public Address setNeighborhood(String neighborhood) {
                this.neighborhood = neighborhood;
                return this;
        }

        public String getCity() {
                return city;
        }

        public Address setCity(String city) {
                this.city = city;
                return this;
        }

        public String getState() {
                return state;
        }

        public Address setState(String state) {
                this.state = state;
                return this;
        }

        public String getComplement() {
                return complement;
        }

        public Address setComplement(String complement) {
                this.complement = complement;
                return this;
        }
}
