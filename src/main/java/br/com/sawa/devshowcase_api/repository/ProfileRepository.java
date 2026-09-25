package br.com.sawa.devshowcase_api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.sawa.devshowcase_api.model.Profile;
public interface ProfileRepository extends JpaRepository<Profile, Long> {}
