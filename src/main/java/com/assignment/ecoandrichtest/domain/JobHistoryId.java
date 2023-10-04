package com.assignment.ecoandrichtest.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter @Setter
public class JobHistoryId implements Serializable {
        // JPA에서 복합키(Composite Key)를 가진 엔티티 클래스의 식별자를 정의하는 클래스
        // 복합키 식별 클래스
        private Long employee;
        private LocalDate startDate;

}
