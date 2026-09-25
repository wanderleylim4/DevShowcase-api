package br.com.sawa.devshowcase_api.model;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity @Table(name = "tb_profile")
public class Profile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String name; private String bio;
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL) private List<Project> projects = new ArrayList<>();
    public Profile() {}
    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getName() { return name; } public void setName(String name) { this.name = name; }
    public String getBio() { return bio; } public void setBio(String bio) { this.bio = bio; }
    public List<Project> getProjects() { return projects; }
}
