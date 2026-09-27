package br.com.sawa.devshowcase_api.dto;

import br.com.sawa.devshowcase_api.model.Project;

public record ProjectResponseDTO(
    Long id,
    String title,
    String description,
    String url,
    Integer upvotes,
    Double averageRating,
    Long profileId
) {
    public ProjectResponseDTO(Project project) {
        this(
            project.getId(),
            project.getTitle(),
            project.getDescription(),
            project.getUrl(),
            project.getUpvotes(),
            project.getAverageRating(),
            project.getProfile() != null ? project.getProfile().getId() : null
        );
    }
}