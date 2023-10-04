package com.assignment.ecoandrichtest.repository;

import com.assignment.ecoandrichtest.domain.entity.Employee;
import com.assignment.ecoandrichtest.domain.entity.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobHistoryRepository extends JpaRepository<JobHistory, Long> {

    List<JobHistory> findByEmployee(Employee employee);
}
