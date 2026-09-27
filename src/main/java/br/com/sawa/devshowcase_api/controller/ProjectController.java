package br.com.sawa.devshowcase_api.controller;

import br.com.sawa.devshowcase_api.dto.FeedbackRequestDTO;
import br.com.sawa.devshowcase_api.dto.FeedbackResponseDTO;
import br.com.sawa.devshowcase_api.dto.ProjectResponseDTO;
import br.com.sawa.devshowcase_api.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<Page<ProjectResponseDTO>> findAll(
            @RequestParam(required = false) String technology,
            Pageable pageable) {
        Page<ProjectResponseDTO> page = projectService.findAll(technology, pageable);
        return ResponseEntity.ok(page);
    }

    @PostMapping("/{id}/feedbacks")
    public ResponseEntity<FeedbackResponseDTO> addFeedback(
            @PathVariable Long id,
            @Valid @RequestBody FeedbackRequestDTO dto) {
        FeedbackResponseDTO response = projectService.addFeedback(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}/upvote")
    public ResponseEntity<ProjectResponseDTO> upvote(@PathVariable Long id) {
        ProjectResponseDTO response = projectService.upvote(id);
        return ResponseEntity.ok(response);
    }
}