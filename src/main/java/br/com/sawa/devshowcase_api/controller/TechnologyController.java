package br.com.sawa.devshowcase_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.sawa.devshowcase_api.dto.ProfileResponseDTO;
import br.com.sawa.devshowcase_api.dto.ProfileRequestDTO;
import br.com.sawa.devshowcase_api.dto.TechnologyResponseDTO;
import br.com.sawa.devshowcase_api.service.TechnologyService;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {

    private final TechnologyService service;

    public TechnologyController(TechnologyService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProfileResponseDTO> insert(@Valid @RequestBody ProfileRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(dto));
    }

    @GetMapping
    public ResponseEntity<List<TechnologyResponseDTO>> findAll() {
        return ResponseEntity.ok(List.of());
    }
}
