package fr.eql.ai114.ngouriou.localappback.repository.post;

import fr.eql.ai114.ngouriou.localappback.entity.post.AssociationPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssociationPostRepository extends JpaRepository<AssociationPost, Long> {
    @Query("SELECT o FROM AssociationPost o WHERE o.author.id = :id")
    List<AssociationPost> findByAuthor(long id);
}
