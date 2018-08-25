package com.mbmk.model.repository;

import com.mbmk.model.domain.ChangeSuggestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChangeRepository extends JpaRepository<ChangeSuggestion, Long> {
}
