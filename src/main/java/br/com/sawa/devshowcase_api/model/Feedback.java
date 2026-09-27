package br.com.sawa.devshowcase_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer rating; // Nota de 1 a 5
    private String comment;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Feedback() {}

    public Feedback(Long id, Integer rating, String comment, Project project) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.project = project;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public Project getProject() { return project; }
    public void setProject(Project project) { this.project = project; }
}