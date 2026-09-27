package br.com.sawa.devshowcase_api.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String url;

    private Integer upvotes = 0;
    private Double averageRating = 0.0;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Feedback> feedbacks = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "tb_project_technology",
        joinColumns = @JoinColumn(name = "project_id"),
        inverseJoinColumns = @JoinColumn(name = "technology_id")
    )
    private List<Technology> technologies = new ArrayList<>();

    public Project() {}

    public Project(Long id, String title, String description, String url, Profile profile) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.url = url;
        this.profile = profile;
        this.upvotes = 0;
        this.averageRating = 0.0;
    }

    // Método utilitário para recalcular a média das notas dos feedbacks
    public void updateAverageRating() {
        if (feedbacks == null || feedbacks.isEmpty()) {
            this.averageRating = 0.0;
        } else {
            double sum = 0.0;
            for (Feedback feedback : feedbacks) {
                sum += feedback.getRating();
            }
            this.averageRating = sum / feedbacks.size();
        }
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public Integer getUpvotes() { return upvotes; }
    public void setUpvotes(Integer upvotes) { this.upvotes = upvotes; }

    public Double getAverageRating() { return averageRating; }
    public void setAverageRating(Double averageRating) { this.averageRating = averageRating; }

    public Profile getProfile() { return profile; }
    public void setProfile(Profile profile) { this.profile = profile; }

    public List<Feedback> getFeedbacks() { return feedbacks; }
    public void setFeedbacks(List<Feedback> feedbacks) { this.feedbacks = feedbacks; }

    public List<Technology> getTechnologies() { return technologies; }
    public void setTechnologies(List<Technology> technologies) { this.technologies = technologies; }
}