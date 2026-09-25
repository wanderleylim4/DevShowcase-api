package br.com.sawa.devshowcase_api.dto;
import jakarta.validation.constraints.NotBlank;
public record ProfileRequestDTO(@NotBlank(message = "O nome do desenvolvedor é obrigatório") String name, String bio) {}
