package br.com.sawa.devshowcase_api.dto;
import br.com.sawa.devshowcase_api.model.Profile;
public record ProfileResponseDTO(Long id, String name, String bio) {
    public ProfileResponseDTO(Profile profile) { this(profile.getId(), profile.getName(), profile.getBio()); }
}
