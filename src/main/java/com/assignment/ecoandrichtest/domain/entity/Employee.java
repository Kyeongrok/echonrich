package com.assignment.ecoandrichtest.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Getter @Setter
public class Employee {

    @Id
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "commission_pct")
    private BigDecimal commissionPct;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    public void setEmployeeId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hireDate=" + hireDate +
                ", job=" + (job != null ? job.getTitle() : null) + // 예시로 Job 엔티티의 getTitle() 메서드를 호출하여 사용
                ", salary=" + salary +
                ", commissionPct=" + commissionPct +
                ", department=" + (department != null ? department.getName() : null) + // 예시로 Department 엔티티의 getName() 메서드를 호출하여 사용
                ", manager=" + (manager != null ? manager.getFirstName() + " " + manager.getLastName() : null) + // 예시로 manager 엔티티의 이름을 합쳐서 사용
                '}';
    }

}
