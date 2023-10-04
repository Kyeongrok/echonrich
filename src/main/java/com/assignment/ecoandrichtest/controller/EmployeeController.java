package com.assignment.ecoandrichtest.controller;

import com.assignment.ecoandrichtest.domain.entity.Employee;
import com.assignment.ecoandrichtest.domain.entity.JobHistory;
import com.assignment.ecoandrichtest.repository.JobHistoryRepository;
import com.assignment.ecoandrichtest.repository.EmployeeRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Employees API", description = "Employees API.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/employees/v1")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final JobHistoryRepository jobHistoryRepository;

    // 특정 사원의 현재 정보 조회 API
    @Operation(summary = "사원 정보 조회", description = "사원 정보 조회 API.")
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        // 사원 아이디 조회 후 반환
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
        return ResponseEntity.ok(employee);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        // EntityNotFoundException이 발생한 경우 클라이언트에게 에러 응답을 반환합니다.
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    // 특정 사원의 이력 정보 조회 API
    @Operation(summary = "사원 이력 조회", description = "사원 이력 조회 API.")
    @GetMapping("/history/{employeeId}")
    public ResponseEntity<List<JobHistory>> getEmployeeHistory(@PathVariable Long employeeId) {
        // 특정 사원의 이력 정보를 조회하고 반환합니다.
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + employeeId));
        System.out.println("Employee 객체 내용 출력 " + employee);

        List<JobHistory> employeeHistory = jobHistoryRepository.findByEmployee(employee);

        return ResponseEntity.ok(employeeHistory);
    }
}
