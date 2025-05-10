package br.com.iaquant.api.customer.user.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "\"user\"")
public class User{
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
        @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)

        Long id;
        String username;
        String password;

        public Long getId() {
                return id;
        }

        public User setId(Long id) {
                this.id = id;
                return this;
        }

        public String getUsername() {
                return username;
        }

        public User setUsername(String username) {
                this.username = username;
                return this;
        }

        public String getPassword() {
                return password;
        }

        public User setPassword(String password) {
                this.password = password;
                return this;
        }
}
