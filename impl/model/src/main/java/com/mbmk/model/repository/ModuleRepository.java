package com.mbmk.model.repository;

import com.mbmk.model.domain.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module, Long> {
}
