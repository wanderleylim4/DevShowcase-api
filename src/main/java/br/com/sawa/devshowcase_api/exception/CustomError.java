package br.com.sawa.devshowcase_api.exception;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CustomError {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;
    private List<String> errors = new ArrayList<>();

    public CustomError(Instant timestamp, Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public void addError(String message) {
        errors.add(message);
    }

    public Instant getTimestamp() { return timestamp; }
    public Integer getStatus() { return status; }
    public String getError() { return error; }
    public String getPath() { return path; }
    public List<String> getErrors() { return errors; }
}
