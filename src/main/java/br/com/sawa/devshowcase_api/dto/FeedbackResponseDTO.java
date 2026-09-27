package br.com.sawa.devshowcase_api.dto;

import br.com.sawa.devshowcase_api.model.Feedback;

public record FeedbackResponseDTO(
    Long id,
    Integer rating,
    String comment,
    Long projectId
) {
    public FeedbackResponseDTO(Feedback feedback) {
        this(
            feedback.getId(),
            feedback.getRating(),
            feedback.getComment(),
            feedback.getProject().getId()
        );
    }
}