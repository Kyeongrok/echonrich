package com.assignment.ecoandrichtest.controller;


import com.assignment.ecoandrichtest.domain.entity.Department;
import com.assignment.ecoandrichtest.repository.DepartmentRepository;
import com.assignment.ecoandrichtest.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Tag(name = "departments API", description = "부서 관련 API.")
@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentRepository departmentRepository;
    private final DepartmentService departmentService;

    @Operation(summary = "부서 정보 조회", description = "부서조회 API.")
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        // Department를 조회하고 반환합니다.
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + id));
        return ResponseEntity.ok(department);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException exx) {
        // EntityNotFoundException이 발생한 경우 클라이언트에게 에러 응답을 반환합니다.
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exx.getMessage());
    }


    @Operation(description = "특정 부서의 급여를 특정 비율로 인상합니다.")
    // 특정 부서의 급여를 특정 비율로 인상하는 API
    @PostMapping("/{departmentName}/{increase-salary}")
    public ResponseEntity<Map<String, String>> increaseSalary(
            @PathVariable String departmentName,
            @RequestParam BigDecimal salaryIncreasePercentage
    ) {
        departmentService.increaseSalaryForDepartmentByName(departmentName, salaryIncreasePercentage);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Salary increased successfully.");

        return ResponseEntity.ok(response);
    }
}









