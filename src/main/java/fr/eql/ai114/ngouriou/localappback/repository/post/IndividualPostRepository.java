package fr.eql.ai114.ngouriou.localappback.repository.post;

import fr.eql.ai114.ngouriou.localappback.entity.post.IndividualPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IndividualPostRepository extends JpaRepository<IndividualPost, Long> {
    @Query("SELECT o FROM IndividualPost o WHERE o.author.id = :id")
    List<IndividualPost> findByAuthor(long id);
}
