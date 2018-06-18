package com.mbmk.model.repository;

import com.mbmk.model.domain.ChangeSuggestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChangeSuggestionRepository extends JpaRepository<ChangeSuggestion, Long> {
}
