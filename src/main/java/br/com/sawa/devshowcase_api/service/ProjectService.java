package br.com.sawa.devshowcase_api.service;

import br.com.sawa.devshowcase_api.dto.FeedbackRequestDTO;
import br.com.sawa.devshowcase_api.dto.FeedbackResponseDTO;
import br.com.sawa.devshowcase_api.dto.ProjectResponseDTO;
import br.com.sawa.devshowcase_api.exception.ResourceNotFoundException;
import br.com.sawa.devshowcase_api.model.Feedback;
import br.com.sawa.devshowcase_api.model.Project;
import br.com.sawa.devshowcase_api.repository.FeedbackRepository;
import br.com.sawa.devshowcase_api.repository.ProjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final FeedbackRepository feedbackRepository;

    public ProjectService(ProjectRepository projectRepository, FeedbackRepository feedbackRepository) {
        this.projectRepository = projectRepository;
        this.feedbackRepository = feedbackRepository;
    }

    @Transactional(readOnly = true)
    public Page<ProjectResponseDTO> findAll(String technology, Pageable pageable) {
        Page<Project> projects = projectRepository.findByTechnology(technology, pageable);
        return projects.map(ProjectResponseDTO::new);
    }

    @Transactional
    public FeedbackResponseDTO addFeedback(Long projectId, FeedbackRequestDTO dto) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado com o ID: " + projectId));

        Feedback feedback = new Feedback();
        feedback.setRating(dto.rating());
        feedback.setComment(dto.comment());
        feedback.setProject(project);

        feedback = feedbackRepository.save(feedback);

        project.getFeedbacks().add(feedback);
        project.updateAverageRating();
        projectRepository.save(project);

        return new FeedbackResponseDTO(feedback);
    }

    @Transactional
    public ProjectResponseDTO upvote(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Projeto não encontrado com o ID: " + projectId));

        project.setUpvotes(project.getUpvotes() + 1);
        project = projectRepository.save(project);

        return new ProjectResponseDTO(project);
    }
}