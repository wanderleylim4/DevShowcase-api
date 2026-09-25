package br.com.sawa.devshowcase_api.dto;
import br.com.sawa.devshowcase_api.model.Technology;
public record TechnologyResponseDTO(Long id, String name) {
    public TechnologyResponseDTO(Technology tech) { this(tech.getId(), tech.getName()); }
}
