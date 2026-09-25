package br.com.sawa.devshowcase_api.model;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity @Table(name = "tb_project")
public class Project {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String title; private String repositoryUrl;
    @ManyToOne @JoinColumn(name = "profile_id") private Profile profile;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL) private List<Feedback> feedbacks = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "tb_project_technology", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "technology_id"))
    private List<Technology> technologies = new ArrayList<>();
    public Project() {}
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; } public void setTitle(String title) { this.title = title; }
    public String getRepositoryUrl() { return repositoryUrl; } public void setRepositoryUrl(String repositoryUrl) { this.repositoryUrl = repositoryUrl; }
    public Profile getProfile() { return profile; } public void setProfile(Profile profile) { this.profile = profile; }
    public List<Feedback> getFeedbacks() { return feedbacks; } public List<Technology> getTechnologies() { return technologies; }
}
