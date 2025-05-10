package br.com.iaquant.api.customer.user.repository;

import br.com.iaquant.api.customer.user.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);



    Optional<Customer> findByUserUsername
            (String username);
}

