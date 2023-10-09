package fr.eql.ai114.ngouriou.localappback.repository;

import fr.eql.ai114.ngouriou.localappback.entity.post.CityPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<CityPost, Long> {
}
