package br.com.iaquant.api.customer.user.datasource.postgres.repository;

import br.com.iaquant.api.customer.user.datasource.postgres.entity.CustomerTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerPostgresRepository extends JpaRepository<CustomerTable, Long> {
    CustomerTable findByEmail(String email);

    CustomerTable findByUserUsername(String username);

    @Query("""
        SELECT c FROM CustomerTable c
        JOIN c.user u
        WHERE (:username IS NULL OR :username = '' 
        OR LOWER(u.username) LIKE LOWER(CONCAT('%', :username, '%')))
    """)
    Page<CustomerTable> findAllByUsername(@Param("username") String username, Pageable page);

}

