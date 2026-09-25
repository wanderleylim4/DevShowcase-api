package br.com.sawa.devshowcase_api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.sawa.devshowcase_api.dto.ProjectRequestDTO;
import br.com.sawa.devshowcase_api.dto.ProjectResponseDTO;
import br.com.sawa.devshowcase_api.model.Project;
import br.com.sawa.devshowcase_api.model.Profile;
import br.com.sawa.devshowcase_api.model.Technology;
import br.com.sawa.devshowcase_api.repository.ProjectRepository;
import br.com.sawa.devshowcase_api.repository.ProfileRepository;
import br.com.sawa.devshowcase_api.repository.TechnologyRepository;
import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository repository; 
    private final ProfileRepository profileRepository; 
    private final TechnologyRepository techRepository;

    public ProjectService(ProjectRepository repository, ProfileRepository profileRepository, TechnologyRepository techRepository) {
        this.repository = repository; 
        this.profileRepository = profileRepository; 
        this.techRepository = techRepository;
    }

    @Transactional
    public ProjectResponseDTO insert(ProjectRequestDTO dto) {
        Profile profile = profileRepository.findById(dto.profileId())
            .orElseThrow(() -> new RuntimeException("Perfil não encontrado"));

        Project project = new Project(); 
        project.setTitle(dto.title()); 
        project.setRepositoryUrl(dto.repositoryUrl()); 
        project.setProfile(profile);
        
        if (dto.technologyIds() != null) { 
            List<Technology> techs = techRepository.findAllById(dto.technologyIds()); 
            project.getTechnologies().addAll(techs); 
        }
        return new ProjectResponseDTO(repository.save(project));
    }

    @Transactional(readOnly = true)
    public List<ProjectResponseDTO> findAll() { 
        return repository.findAll().stream().map(ProjectResponseDTO::new).toList(); 
    }
}
