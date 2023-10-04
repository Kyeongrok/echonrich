package com.assignment.ecoandrichtest.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@Table(name = "departments")
public class Department {

    @Id
    @Column(name = "department_id")
    private Long id;

    @Column(name = "department_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private List<Employee> employees; // employees 필드 추가

    // employees 필드에 대한 게터 추가
    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location=" + (location != null ? location.getId() : null) + // 예시로 Location 엔티티의 getId() 메서드를 호출하여 사용
                '}';
    }
}
