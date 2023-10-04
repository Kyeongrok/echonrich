package com.assignment.ecoandrichtest.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
@Table(name = "regions")
public class Regions {
    @Id
    @Column(name = "region_id")
    private Long id;

    @Column(name = "region_name")
    private String name;
}
