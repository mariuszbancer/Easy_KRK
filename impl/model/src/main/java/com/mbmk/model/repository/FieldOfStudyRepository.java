package com.mbmk.model.repository;

import com.mbmk.model.domain.FieldOfStudy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FieldOfStudyRepository extends JpaRepository<FieldOfStudy, Long> {
    List<FieldOfStudy> findByDepartmentId(Long departmentId);
}
