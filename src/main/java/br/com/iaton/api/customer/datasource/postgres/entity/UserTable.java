package br.com.iaton.api.customer.datasource.postgres.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "\"user\"")
public class UserTable {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
        @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
        private Long id;
        private String username;
        private String password;

        public Long getId() {
                return id;
        }

        public UserTable setId(Long id) {
                this.id = id;
                return this;
        }

        public String getUsername() {
                return username;
        }

        public UserTable setUsername(String username) {
                this.username = username;
                return this;
        }

        public String getPassword() {
                return password;
        }

        public UserTable setPassword(String password) {
                this.password = password;
                return this;
        }
}
