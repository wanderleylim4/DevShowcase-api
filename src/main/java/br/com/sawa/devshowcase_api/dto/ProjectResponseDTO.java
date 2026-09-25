package br.com.sawa.devshowcase_api.dto;
import br.com.sawa.devshowcase_api.model.Project;
import java.util.List;
public record ProjectResponseDTO(Long id, String title, String repositoryUrl, Long profileId, List<String> technologies) {
    public ProjectResponseDTO(Project project) {
        this(project.getId(), project.getTitle(), project.getRepositoryUrl(), project.getProfile().getId(), project.getTechnologies().stream().map(t -> t.getName()).toList());
    }
}
