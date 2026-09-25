package br.com.sawa.devshowcase_api.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;
import java.util.List;
public record ProjectRequestDTO(
    @NotBlank(message = "O título do projeto é obrigatório") String title,
    @NotBlank(message = "A URL do repositório é obrigatória") @URL(message = "Insira uma URL válida") String repositoryUrl,
    @NotNull(message = "O ID do perfil associado é obrigatório") Long profileId,
    List<Long> technologyIds
) {}
