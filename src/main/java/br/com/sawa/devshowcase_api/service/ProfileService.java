package br.com.sawa.devshowcase_api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.sawa.devshowcase_api.dto.ProfileRequestDTO;
import br.com.sawa.devshowcase_api.dto.ProfileResponseDTO;
import br.com.sawa.devshowcase_api.model.Profile;
import br.com.sawa.devshowcase_api.repository.ProfileRepository;

@Service
public class ProfileService {
    private final ProfileRepository repository;

    public ProfileService(ProfileRepository repository) { 
        this.repository = repository; 
    }

    @Transactional
    public ProfileResponseDTO insert(ProfileRequestDTO dto) {
        Profile profile = new Profile(); 
        profile.setName(dto.name()); 
        profile.setBio(dto.bio());
        return new ProfileResponseDTO(repository.save(profile));
    }

    @Transactional(readOnly = true)
    public ProfileResponseDTO findById(Long id) {
        Profile profile = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Perfil não encontrado com o ID: " + id));
        return new ProfileResponseDTO(profile);
    }
}
