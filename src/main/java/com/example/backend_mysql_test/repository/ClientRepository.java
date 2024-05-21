package com.example.backend_mysql_test.repository;

import com.example.backend_mysql_test.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
