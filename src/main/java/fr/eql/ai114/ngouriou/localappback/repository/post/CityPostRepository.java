package fr.eql.ai114.ngouriou.localappback.repository.post;

import fr.eql.ai114.ngouriou.localappback.entity.User;
import fr.eql.ai114.ngouriou.localappback.entity.post.CityPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityPostRepository extends JpaRepository<CityPost, Long> {
    @Query("SELECT o FROM CityPost o WHERE o.author.id = :id")
    List<CityPost> findByAuthor(long id);

    @Query("SELECT o FROM CityPost o WHERE o.cityPostId = :id")
    CityPost findByCityPostId(long id);

    @Query(nativeQuery = true)
    void saveCustom();

}
