package br.com.sawa.devshowcase_api.dto;
import java.time.Instant;
import java.util.List;
public record StandardError(Instant timestamp, Integer status, String error, String message, String path, List<ValidationError> errors) {
    public record ValidationError(String field, String message) {}
}
