package br.com.videos.repository;

import br.com.videos.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findByTituloContainsIgnoreCase(String titulo);

}
