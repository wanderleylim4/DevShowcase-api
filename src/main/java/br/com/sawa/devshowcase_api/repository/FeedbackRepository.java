package br.com.sawa.devshowcase_api.repository;

import br.com.sawa.devshowcase_api.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}