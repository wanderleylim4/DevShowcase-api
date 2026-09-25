package br.com.sawa.devshowcase_api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.sawa.devshowcase_api.model.Project;
public interface ProjectRepository extends JpaRepository<Project, Long> {}
