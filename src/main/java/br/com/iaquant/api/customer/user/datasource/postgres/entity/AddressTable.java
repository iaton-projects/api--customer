package br.com.iaquant.api.customer.user.datasource.postgres.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class AddressTable {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
        @SequenceGenerator(name = "address_seq", sequenceName = "address_seq", allocationSize = 1)
        private Long id;
        private String zipCode;
        private String address;
        private String neighborhood;
        private String city;
        private String state;
        private String complement;

        public Long getId() {
                return id;
        }

        public AddressTable setId(Long id) {
                this.id = id;
                return this;
        }

        public String getZipCode() {
                return zipCode;
        }

        public AddressTable setZipCode(String zipCode) {
                this.zipCode = zipCode;
                return this;
        }

        public String getAddress() {
                return address;
        }

        public AddressTable setAddress(String address) {
                this.address = address;
                return this;
        }

        public String getNeighborhood() {
                return neighborhood;
        }

        public AddressTable setNeighborhood(String neighborhood) {
                this.neighborhood = neighborhood;
                return this;
        }

        public String getCity() {
                return city;
        }

        public AddressTable setCity(String city) {
                this.city = city;
                return this;
        }

        public String getState() {
                return state;
        }

        public AddressTable setState(String state) {
                this.state = state;
                return this;
        }

        public String getComplement() {
                return complement;
        }

        public AddressTable setComplement(String complement) {
                this.complement = complement;
                return this;
        }
}
