package br.com.iaquant.api.customer.user.datasource.postgres.repository;

import br.com.iaquant.api.customer.user.datasource.postgres.entity.CustomerTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerPostgresRepository extends JpaRepository<CustomerTable, Long> {
    CustomerTable findByEmail(String email);

    CustomerTable findByUserUsername(String username);

}

