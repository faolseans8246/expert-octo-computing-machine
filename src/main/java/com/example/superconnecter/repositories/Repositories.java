package com.example.superconnecter.repositories;

import com.example.superconnecter.tables.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Repositories extends JpaRepository<Employee, Long>, CrudRepository<Employee, Long> {
}
